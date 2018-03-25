package daluong_join;

import test.test2;

public class JoinThread extends Thread{
	private String threadName;
	private int count;
	 
	public String getTheradName(){
		return this.threadName;
	}
	  public JoinThread(String threadName, int count) {
	      this.threadName = threadName;
	      this.count = count;
	  }
	  @Override
	  public void run() {
	 
	      for (int i = 1; i < count + 1; i++) {
	    	  //threadName+="hay qua\n";
	          System.out.println("Hello from threadName"+threadName + i);
//	          try {
//	              Thread.sleep(1000);
//	          } catch (InterruptedException e) {
//	          }
	      }
	      System.out.println("\n==> Thread threadName end!\n");
	  }
}
