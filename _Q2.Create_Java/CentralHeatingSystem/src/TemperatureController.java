public class TemperatureController implements Temperatures {

	static final int MAX_RETRIES = 2;

	// Initial temperatures for the controller
	private int gfTemp = 18;
	private int ffTemp = 20;
	private int atTemp = 21;

	// RULE: GF temp < FF temp
	public synchronized void setGFtemp(int newgfTemp) {
		int tries = 0;
		while (!(newgfTemp < ffTemp)) {
			System.out.println("[WAIT]: New GF Temp [" + newgfTemp + "] IS NOT <  FF Temp [" + ffTemp + "]");
			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries == MAX_RETRIES)
				break;
			tries++;
		}

		if (newgfTemp < ffTemp) {
			System.out.println("New GF temp: " + newgfTemp);
			gfTemp = newgfTemp;
		}

		notifyAll();
	}

	// RULE: FF temp > GF temp
	// RULE: FF temp <= AT temp
	public synchronized void setFFtemp(int newffTemp) {
		int tries = 0;
		while (!(newffTemp > gfTemp) || !(newffTemp <= atTemp)) {
			System.out.println("[WAIT]: New FF Temp [" + newffTemp + "] IS NOT >  GF Temp [" + gfTemp + "] OR IS NOT <= AT Temp [" + atTemp + "]");
			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries == MAX_RETRIES)
				break;
			tries++;
		}

		if ((newffTemp > gfTemp) && (newffTemp <= atTemp)) {
			System.out.println("New FF temp: " + newffTemp);
			ffTemp = newffTemp;
		}

		notifyAll();
	}

	// RULE: AT temp >= FF temp
	public synchronized void setATtemp(int newatTemp) {
		int tries = 0;
		while (!(newatTemp >= ffTemp)) {
			System.out.println("[WAIT]: New AT Temp [" + newatTemp + "] IS NOT >= FF Temp [" + ffTemp + "]");
			try {
				wait(500);
			} catch (InterruptedException ignored) {
			}

			if (tries == MAX_RETRIES)
				break;
			tries++;
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
