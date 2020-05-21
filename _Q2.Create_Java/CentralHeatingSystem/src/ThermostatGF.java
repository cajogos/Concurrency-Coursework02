public class ThermostatGF extends Thread {

	private TemperatureController temperatureController;

	public ThermostatGF(ThreadGroup tg, String name, TemperatureController controller) {
		super(tg, name);
		temperatureController = controller;
	}

	public void run() {
		int[] temperatures = { 20, 30, 17, 25 };
		for (int temp : temperatures) {
			try {
				temperatureController.setGFtemp(temp);
				Helpers.sleepRand(1000, 5000);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
