public class TemperatureController implements Temperatures {

	private int gfTemp = 18;
	private int ffTemp = 20;
	private int atTemp = 21;

	public synchronized void setGFtemp(int newgftemp) {
		// GF temp < FF temp

		this.gfTemp = newgftemp;
	}

	public synchronized void setFFtemp(int newfftemp) {
		// FF temp > GF temp
		// FF temp <= AT temp

		this.ffTemp = newfftemp;
	}

	public synchronized void setATtemp(int newattemp) {
		// AT temp >= FF temp

		this.atTemp = newattemp;
	}

	public synchronized void displayTemperatures() {
		System.out.println("Ground Floor Temperature: \t" + gfTemp + "C");
		System.out.println("Fisrt Floor Temperature: \t" + ffTemp + "C");
		System.out.println("Attic Temperature: \t\t" + atTemp + "C");
	}
}
