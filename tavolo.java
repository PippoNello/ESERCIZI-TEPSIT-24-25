package pizzeria;

import java.util.Random;

public class tavolo implements Runnable {
	
	private buffer_ordini tc;
	private buffer_pizza ct;
	private int n_tavolo;
	
	public tavolo(buffer_ordini a, buffer_pizza b, int n) {
		tc = a;
		ct = b;
		n_tavolo = n;
	}
	
	public void run() {
		Random random = new Random();;
		while(true) {
			try {
				Thread.sleep(random.nextInt(1000, 4000));
			} catch (Exception e) {	}
			tc.push(random.nextInt(1,100), n_tavolo);
			if(ct.popNTav() == n_tavolo) {
				System.out.println("Pizza: " + ct.popPizza() + " al tavolo N. : " + ct.popNTav());
			}
		}
	}

}
