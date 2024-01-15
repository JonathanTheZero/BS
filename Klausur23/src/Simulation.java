
public class Simulation {
	public final static int MAX_CARS = 3;
	
	public static void main(String...strings ) {
		Ferryboat ferry = new Ferryboat(MAX_CARS);
		ferry.start();
		
		for(int i = 0; i < 6; ++i) {
			Car car = new Car(i, ferry, (i % 2) == 1);
			car.start();
		}
	}
}
