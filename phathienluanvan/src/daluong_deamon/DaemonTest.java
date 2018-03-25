package daluong_deamon;

public class DaemonTest {
	public static void main(String[] args) {
	       System.out.println("==> Main Thread running..\n");
	       // Tạo một Thread
	       Thread deamonThread = new DeamonThread();
	       // Sét nó là Deamon Thread.
	       deamonThread.setDaemon(true);
	       deamonThread.start();
	 
	       // Tạo một Thread khác
	       new NoneDeamonThread().start();
	 
	       try {
	           // Ngủ 5 giây.
	           Thread.sleep(5000);
	       } catch (InterruptedException e) {
	       }
	        
	       // Ghi ra thông báo luồng main này kết thúc.
	       System.out.println("\n==> Main Thread ending\n");
	   }
}
