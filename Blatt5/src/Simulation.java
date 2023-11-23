public class Simulation {

	private static final int MAX_CLIENTS = 5; 
	
	public static void main(String[] args) {
		
		Server server = new Server(MAX_CLIENTS);
		
		new Sicherung(server).start();
		
		for(int i=0;i<1000;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			new Client(server,i).start();
		}
	}
}
