public class CentralHeatingSystem {

	public static void main(String[] args) {
		TemperatureController controller = new TemperatureController();

		// 3 thermostat controls
		ThermostatGroundFloor gfControl = new ThermostatGroundFloor(controller);
		ThermostatFirstFloor ffControl = new ThermostatFirstFloor(controller);
		ThermostatAttic atControl = new ThermostatAttic(controller);
		
		gfControl.start();
		ffControl.start();
		atControl.start();

		try {
			gfControl.join();
			ffControl.join();
			atControl.join();
		} catch (InterruptedException ignored) {
		}

		controller.displayTemperatures();
	}

}