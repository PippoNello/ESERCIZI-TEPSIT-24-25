package pizzeria;
import java.util.LinkedList;
import java.util.Queue;

public class buffer_ordini {
	Queue <Integer> coda = new LinkedList<>();
	int ordini [] = new int[16];
	
	public void push(int val, int n) {
		coda.add(val);
		coda.add(n);
	}
	
	public int popPizza() {
		return coda.poll();
	}
	public int popNTav() {
		return coda.poll();
	}
}
