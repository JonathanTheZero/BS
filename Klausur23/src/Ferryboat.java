
public class Ferryboat extends Thread {
	private boolean west;
	private int maxCars;
	private boolean beenUnloaded;
	private int numberCars;

	public Ferryboat(int max) {
		this.maxCars = max;
		west = true;
		beenUnloaded = true;
		numberCars = 0;
	}

	public void run() {
		while (true) {
			goEast();
			goWest();
		}
	}

	public synchronized void enter(int carId, boolean carPosition) {
		while (west != carPosition || !beenUnloaded || numberCars > maxCars) {
			try {
				System.out.println("Car" + carId + ": muss auf Einfahrt warten: " + carPosition + " Anz: " + numberCars
						+ " Entladen: " + beenUnloaded);
				wait();
			} catch (InterruptedException e) {
			}
		}
		numberCars++;
		System.out.println("Car" + carId + ": ist auf Fähre. Anz: " + numberCars);
		notify();
	}

	public synchronized void leave(int carId, boolean oldCarPosition) {
		while (oldCarPosition == west) {
			try {
				System.out.println("Car" + carId + ": muss auf Ausfahrt warten: " + oldCarPosition + " Anz: "
						+ numberCars + " Entladen: " + beenUnloaded);
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Car" + carId + ": verlässt Fähre auf Fähre. Anz: " + numberCars);
		numberCars--;
		if (numberCars == 0) {
			beenUnloaded = true;
		}
	}

	public synchronized void goEast() {
		while (!west || numberCars < maxCars) {
			try {
				System.out
						.println("Fähre: muss warten: " + west + " Anz: " + numberCars + " Entladen: " + beenUnloaded);
				wait();
			} catch (InterruptedException e) {
			}
		}
		beenUnloaded = false;
		System.out.println("Fähre: goEast");
		west = false;
		notifyAll();
	}

	public synchronized void goWest() {
		while (west ||numberCars < maxCars) {
			try {
				System.out
						.println("Fähre: muss warten: " + west + " Anz: " + numberCars + " Entladen: " + beenUnloaded);
				wait();
			} catch (InterruptedException e) {
			}
		}
		beenUnloaded = false;
		System.out.println("Fähre: goWest");
		west = true;
		notifyAll();
	}
}
