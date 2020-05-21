public class CentralHeatingSystem {

	public static void main(String[] args) {
		
		// 1 Temperature Controller
		TemperatureController controller = new TemperatureController();
		
		// Create a Thread Group for all Thermostats
		ThreadGroup thermos = new ThreadGroup("thermostats");

		// 3 Thermostat Controls
		ThermostatGF gfControl = new ThermostatGF(thermos, "Ground_Floor", controller);
		ThermostatFF ffControl = new ThermostatFF(thermos, "First_Floor", controller);
		ThermostatAT atControl = new ThermostatAT(thermos, "Attic", controller);
		
		// Start all threads
		gfControl.start();
		ffControl.start();
		atControl.start();
		
		// Wait for all threads to finish
		try {
			gfControl.join();
			ffControl.join();
			atControl.join();
		} catch (InterruptedException ignored) {
		}
		
		// Display final temperatures per floor
		controller.displayTemperatures();
	}

}