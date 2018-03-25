package daluong;

public class RunnableTest {
	public static void main(String[] args) throws InterruptedException {
		 
	       System.out.println("Main thread running..");
	 
	       // Tạo một thread từ Runnable.
	       Thread thread = new Thread(new RunnableDemo());
	 
	       thread.start();
	 
	       // Ngủ 5 giây.
	       Thread.sleep(7000);
	       System.out.println("Main thread stopped");
	   }
}
