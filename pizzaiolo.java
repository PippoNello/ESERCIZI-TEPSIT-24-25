package pizzeria;

import java.util.Random;

public class pizzaiolo implements Runnable {

	private buffer_ordini cp;
	private buffer_pizza pc;

	public void run() {
		Random r = new Random();
		int tav;
		int pizza;
		while(true) {
			pizza = cp.popPizza();
			tav = cp.popNTav();
			try {
				Thread.sleep(r.nextInt(1000,4000));
			} catch (Exception e) {}
			pc.push(pizza, tav);
		}
	}

}
