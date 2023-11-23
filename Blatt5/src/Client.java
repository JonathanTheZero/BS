import java.util.Random;

public class Client extends Thread{

	private Server server; 
	public final int ID;
	private Random zufall;
	
	
	public Client(Server s, int id){
		this.ID = id;
		this.server= s;
		zufall = new Random();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(zufall.nextInt(2000) + 500);
			server.daten_ablegen(this);
			System.out.println("Client "+this.ID+" legt Daten auf den Server.");
			Thread.sleep(zufall.nextInt(2000) + 500);
			server.daten_ablegen_beenden();
			System.out.println("Client "+this.ID+" hat Daten abgelegt.");
		} catch (InterruptedException e) {};
	}
}
