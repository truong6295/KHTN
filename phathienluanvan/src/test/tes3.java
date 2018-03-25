package test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class tes3 {
	private static Thread th1;
	private static Thread th2;
	private static HashSet<String>hset =new HashSet<>();
	private static HashSet<String>hset1 =new HashSet<>();

	private static Set<String> sls1 = new CopyOnWriteArraySet<String>();
	private static Set<String> sls2 = new CopyOnWriteArraySet<String>();
	public static void main(String[] args) throws InterruptedException{
		System.out.print("bawt dau! ");
		th1=new Thread(){
			public void run(){
				int i=0;
				while(i<20){
					sls1.add("Them 1 lan: "+i);
					i++;
				}
				
				for(String ds:sls1){
					int j=0;
					while(j<2){
					sls2.add(ds+j);
					System.out.println("Thread 1 ");
					try {
						th1.sleep(1000);
					} catch (InterruptedException e) {}
					j++;
					}
				}
				System.out.println(sls2.size());
			}
		};
		th1.start();
		th1.join(7000);
		th2=new Thread(){
			public void run(){
				System.out.println(sls2.size());
				for(String dt:sls2){
					System.out.println("Thread 2 "+dt);
					try {
						th2.sleep(4000);
					} catch (InterruptedException e) {}
				}
			}
		};
		th2.start();
		th2.join(4000);
	}
}
