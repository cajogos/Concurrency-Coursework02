import java.util.Random;

public class Helpers {
	public static void sleepRand(int start, int end) throws InterruptedException {
		int timeToSleep = new Random().nextInt(((int) end - (int) start) + 1) + start;
		Thread.sleep(timeToSleep);
	}
}
