class Buffer {
	private int contents = -1;
	private boolean new_data = false;

	public synchronized int take() {
		while (!new_data) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		new_data = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (new_data) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		contents = value;
		new_data = true;

		notifyAll();
	}

}