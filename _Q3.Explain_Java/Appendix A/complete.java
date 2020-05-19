class Buffer
{
    private int contents = -1 ;
    private boolean new_data = false ;

    public synchronized int take( )
    {
        while ( !new_data )
        {
            try {
                wait() ;
            } catch(InterruptedException e){ }
        }
        new_data = false ;
        notifyAll() ;
        return contents ;
    }

    public synchronized void put( int value )
    {
        while ( new_data )
        {
            try {
                wait() ;
            } catch(InterruptedException e){ }
        }

        contents = value ;
        new_data = true ;

        notifyAll() ;
    }

} // Buffer
class Producer extends Thread
{
    private final Buffer buffer ;

    public Producer( Buffer buffer )
    {
        super( "Producer" ) ;
        this.buffer = buffer ;
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            buffer.put( i ) ;
            System.out.println(getName() + " put: " + i) ;
            try { sleep( 1000 ) ; }
            catch (InterruptedException e) { }
        }
    }
} // Producer
class Consumer extends Thread
{
    private final Buffer buffer ;

    public Consumer( Buffer buffer )
    {
        super( "Consumer" ) ;
        this.buffer = buffer ;
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            int data = buffer.take() ;
            System.out.println(getName() + " taken: " + data) ;
        }
    }
} // Consumer
class ProducerConsumerProblem
{
    public static void main( String args[] )
    {
        Buffer buffer = new Buffer() ;

        Producer p1 = new Producer( buffer ) ;
        Consumer c1 = new Consumer( buffer ) ;

        p1.start() ;
        c1.start() ;
    }
} // ProducerConsumerProblem
