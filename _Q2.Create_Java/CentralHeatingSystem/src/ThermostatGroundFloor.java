public class ThermostatGroundFloor extends Thread {

	private TemperatureController temperatureController;

	public ThermostatGroundFloor(TemperatureController controller) {
		temperatureController = controller;
	}

	public void run() {
		temperatureController.setGFtemp(22);
	}

}
