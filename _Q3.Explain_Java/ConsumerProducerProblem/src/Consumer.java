class Consumer extends Thread {
	private final Buffer buffer;

	public Consumer(Buffer buffer) {
		super("Consumer");
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			int data = buffer.take();
			System.out.println(getName() + " taken: " + data);
		}
	}
}