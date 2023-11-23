public class SimpleThread extends Thread {

	String msg;
	int cycles;

	SimpleThread(String m, int c) {
		msg = m;
		cycles = c;
	}

	// Overrides run() in Thread class to define object's
	// behavior.
	public void run() {
		for (int i = 0; i < cycles; i++) {
			System.out.println(msg + " cycle " + i);
		}
	}

	// Command-line argument is the number of cycles c
	// which must be converted from String to int.
	// Builds and starts two threads of type SimpleThread.
	// Continues for c cycles.
	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Arguments are:");
			System.out.println("  cycles");
			System.exit(-1);
		}

		int c = Integer.parseInt(args[0]);

		SimpleThread t1 = new SimpleThread("Thread 1", c);
		SimpleThread t2 = new SimpleThread("Thread 2", c);

		t1.start();
		t2.start();
	}
}
