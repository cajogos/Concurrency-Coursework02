public class ThermostatFF extends Thread {

	private final TemperatureController temperatureController;

	public ThermostatFF(ThreadGroup tg, String name, TemperatureController controller) {
		super(tg, name);
		temperatureController = controller;
	}

	public void run() {
		int[] temperatures = { 22, 28, 19, 30 };
		for (int temp : temperatures) {
			try {
				temperatureController.setFFtemp(temp);
				Helpers.sleepRand(1000, 5000);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
