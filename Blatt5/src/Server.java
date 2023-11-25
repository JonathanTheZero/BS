public class Server {
	private int maxClients;
	private int anzahlClients;
	private boolean sicherungswunsch;

	public Server(int maxClients) {
		this.maxClients = maxClients;
		this.anzahlClients = 0;
		this.sicherungswunsch = false;
	}

	public synchronized void daten_ablegen(Client c) throws InterruptedException {
		System.out.println("Client " + c.ID + " will Daten ablegen");

		while (sicherungswunsch) {
			System.out.println("Client " + c.ID + " wartet auf Freigabe. Sicherung läuft.");
			wait();
		}

		if (anzahlClients >= maxClients) {
			System.out.println("Zu viele Clients sind aktiv. " + c.ID + " muss warten.");
			anzahlClients++;
			wait();
		} else {
			anzahlClients++;
			notify();
		}

		System.out.println(anzahlClients + " Clients legen Daten ab.");
	}

	public synchronized void daten_ablegen_beenden() {
		anzahlClients--;
		notifyAll();
	}

	public synchronized void sicherungAktivieren() throws InterruptedException {
		sicherungswunsch = true;
		System.out.println("Sicherungswunsch angemeldet!");

		while (anzahlClients != 0) {
			System.out.println("Zur Zeit sind noch " + anzahlClients + " Clients aktiv. Warte auf Beenden...");
			wait();
		}

		// Zum Sichern bereit.
	}

	public synchronized void sicherungDeaktivieren() {
		sicherungswunsch = false;
		System.out.println("Sicherungswunsch deaktiviert.");
		notifyAll();
	}
}
