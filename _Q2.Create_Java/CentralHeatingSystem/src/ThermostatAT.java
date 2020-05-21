public class ThermostatAT extends Thread {

	private TemperatureController temperatureController;

	public ThermostatAT(ThreadGroup tg, String name, TemperatureController controller) {
		super(tg, name);
		temperatureController = controller;
	}

	public void run() {
		int[] temperatures = { 19, 22, 23, 24 };
		for (int temp : temperatures) {
			try {
				temperatureController.setATtemp(temp);
				Helpers.sleepRand(1000, 5000);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
