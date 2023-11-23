public class Server {	
	private int maxClients;
	private int anzahlClients;
	private boolean sicherungswunsch;
	
	public Server(int maxClients, int anzahlClients, boolean sicherungswunsch){
		this.maxClients = maxClients;
		this.anzahlClients = anzahlClients;
		this.sicherungswunsch = sicherungswunsch;
	}	
	
	
	public synchronized void daten_ablegen(Client c) throws InterruptedException{
		
		System.out.println("Client "+c.ID+" will Daten ablegen");
		
		while(								){
			
			
						
		}
	
	
		
		System.out.println(anzahlClients +" Clients legen Daten ab.");
	}
	public synchronized void daten_ablegen_beenden(){
		




	}	
	public synchronized void sicherungAktivieren() throws InterruptedException{		
		
		
		
		System.out.println("Sicherungswunsch angemeldet!");
		
		while(								){



		}
		// Zum Sichern bereit.
	}	
	public synchronized void sicherungDeaktivieren(){
		


		System.out.println("Sicherungswunsch deaktiviert.");



	}
}
