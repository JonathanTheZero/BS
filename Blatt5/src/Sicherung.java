
public class Sicherung extends Thread{
	
	private Server server;
	
	public Sicherung(Server server){
		this.server=server; 
	}
	
	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(1000);
				server.sicherungAktivieren();
				System.out.println("Skript sichert die Daten...");
				Thread.sleep(10000);
				server.sicherungDeaktivieren();				
			} catch (InterruptedException e) {};
		}
	}
	
}
