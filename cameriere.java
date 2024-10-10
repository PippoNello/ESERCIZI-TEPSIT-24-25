package pizzeria;

import java.util.Random;

public class cameriere implements Runnable {
	
	private buffer_ordini tc;
	private buffer_ordini cp;
	private buffer_pizza ct;
	private buffer_pizza pc;

	public cameriere(buffer_ordini a, buffer_ordini b, buffer_pizza c, buffer_pizza d) {
		tc = a;
		cp = b;
		pc = c;
		ct = d;
		
	}
	
	public void run() {
		Random random = new Random();
		while(true) {
			cp.push(tc.popPizza(), tc.popNTav());
			try {
				Thread.sleep(random.nextInt(1000,4000));
			} catch (Exception e) {
			}
			pc.popPizza();
			pc.popNTav();
		}
	}

}
