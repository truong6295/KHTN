package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CWSDemo {
	private static Thread th1;
	public static void main(String[] args) {
		Set<Integer> numSet = new CopyOnWriteArraySet<Integer>();
		// Adding 5 elements to the set
		for (int i = 1; i <= 5; i++) {
			numSet.add(i);
		}
		// Creating new thread
		 th1=new Thread() {
			@Override
			public void run() {
				try {
					// introducing some delay
					th1.sleep(30);
				} catch (InterruptedException e) {
					th1.interrupt();
				}
				// add new element to the set
				numSet.add(6);
				System.out.println("" + numSet);
			}

		};
		th1.start();
		try {
			th1.join(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					// introducing some delay
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					Thread.currentThread().interrupt();
//				}
//				// add new element to the set
//				numSet.add(7);
//				System.out.println("" + numSet);
//			}
//
//		}).start();
		// get an iterator
		Iterator<Integer> itr = numSet.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("" + i);
		}
	}
}
