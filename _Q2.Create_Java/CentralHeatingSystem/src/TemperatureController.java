public class TemperatureController implements Temperatures {

	// Up to 2 retries allowed (total of 3 tries)
	static final int MAX_RETRIES = 2;

	// Initial temperatures for the controller
	private int gfTemp = 18;
	private int ffTemp = 20;
	private int atTemp = 21;

	// RULE: Ground Floor Temp < First Floor Temp
	public synchronized void setGFtemp(int newgfTemp) {
		int tries = 0;
		while (!(newgfTemp < ffTemp)) {
			tries++;

			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries > MAX_RETRIES) {
				break;
			}
		}

		if (newgfTemp < ffTemp) {
			gfTemp = newgfTemp;
		}

		notifyAll();
	}

	// RULE: First Floor Temp > Ground Floor Temp
	// RULE: First Floor Temp <= Attic Temp
	public synchronized void setFFtemp(int newffTemp) {
		int tries = 0;
		while (!(newffTemp > gfTemp) || !(newffTemp <= atTemp)) {
			tries++;

			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries > MAX_RETRIES) {
				break;
			}
		}

		if ((newffTemp > gfTemp) && (newffTemp <= atTemp)) {
			ffTemp = newffTemp;
		}

		notifyAll();
	}

	// RULE: Attic Temp >= First Floor Temp
	public synchronized void setATtemp(int newatTemp) {
		int tries = 0;
		while (!(newatTemp >= ffTemp)) {
			tries++;

			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries > MAX_RETRIES) {
				break;
			}
		}

		if (newatTemp >= ffTemp) {
			atTemp = newatTemp;
		}

		notifyAll();
	}

	public synchronized void displayTemperatures() {
		System.out.println("====================================");
		System.out.println("Ground Floor Temperature: \t" + gfTemp + "C");
		System.out.println("Fisrt Floor Temperature: \t" + ffTemp + "C");
		System.out.println("Attic Temperature: \t\t" + atTemp + "C");
		System.out.println("====================================");
	}
}
