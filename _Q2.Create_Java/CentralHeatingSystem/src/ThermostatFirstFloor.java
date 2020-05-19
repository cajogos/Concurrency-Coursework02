public class ThermostatFirstFloor extends Thread {

	private TemperatureController temperatureController;

	public ThermostatFirstFloor(TemperatureController controller) {
		temperatureController = controller;
	}

	public void run() {
		temperatureController.setFFtemp(22);
	}

}
