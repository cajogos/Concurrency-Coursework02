public class ThermostatAttic extends Thread {

	private TemperatureController temperatureController;

	public ThermostatAttic(TemperatureController controller) {
		temperatureController = controller;
	}

	public void run() {
		temperatureController.setATtemp(22);
	}

}
