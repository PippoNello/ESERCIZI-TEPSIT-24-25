package pizzeria;

public class Main {

	public static void main(String[] args) {
		
		Thread arrCam[] = new Thread[3];
		Thread arrTav[] = new Thread[20];
		
		//creo i due buffer per gli ordini
		buffer_ordini b_ordini[] = new buffer_ordini[2];
		for(int i = 0; i < 2; i++) {
			b_ordini[i] = new buffer_ordini();
		}
		
		//creo i due buffer per le pizze
		buffer_pizza b_pizza[] = new buffer_pizza[2];
		for(int i = 0; i < 2; i++) {
			b_pizza[i] = new buffer_pizza();
		}
		
		tavolo t;
		Thread tav;
		
		//ogni thread ha una istanza diversa della classe
		for(int i = 0; i < 20; i++) {
			t = new tavolo(b_ordini[0], b_pizza[0], i); //prende in ingresso i due buffer di comunicazione
			tav = new Thread(t);
			arrTav[i] = tav;
			arrTav[i].start();
		}
		
		cameriere c = new cameriere(b_ordini[0], b_ordini[1], b_pizza[0], b_pizza[1]);
		Thread cam;	
		
		//3 thread che condividono la stessa istanza
		for(int i = 0; i < 3; i++ ) {
			cam = new Thread(c);
			arrCam[i] = cam;
			arrCam[i].start();
		}
		
		//creo la mia istanza della classe pizzaiolo e creo il suo thread
		pizzaiolo p = new pizzaiolo();
		Thread piz = new Thread(p);
		
	}

}
