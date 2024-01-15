
public class Car extends Thread {
	private int id;
	private Ferryboat ferry;
	private boolean isWest;

	public Car(int id, Ferryboat ferry, boolean isWest) {
		this.id = id;
		this.ferry = ferry;
		this.isWest = isWest;
	}

	public void run() {
		ferry.enter(id, isWest);
		ferry.leave(id, isWest);

		System.out.println("Car" + id + " just changed the position.");
		isWest = !isWest;
	}
}
