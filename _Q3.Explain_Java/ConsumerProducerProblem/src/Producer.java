class Producer extends Thread {
	private final Buffer buffer;

	public Producer(Buffer buffer) {
		super("Producer");
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println(getName() + " put: " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}