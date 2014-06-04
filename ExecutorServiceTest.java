import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;



public class ExecutorServiceTest {
   private static int NUM_OF_TASKS = 0;
   public static final ArrayList<String> receivedStrings = new ArrayList<String>();
   public ExecutorServiceTest() {}

   public void run() throws IOException{
      long begTest = new java.util.Date().getTime();

      List< Future > futuresList = new ArrayList< Future >();
      int nrOfProcessors = Runtime.getRuntime().availableProcessors();
      ExecutorService eservice = Executors.newFixedThreadPool(nrOfProcessors);
      eservice.execute(new RunReceiver(receivedStrings));
	  for(int i=0;i<NUM_OF_TASKS;i++){
    	  eservice.execute(new Task());  
      }
      int size = receivedStrings.size();
	 // FileOutputStream fos = new FileOutputStream(new File("receiveddata.txt"));
      while(true){
    	  
    	  if(size != receivedStrings.size()){
    		  size = receivedStrings.size();
    		 // System.out.println("Thread : " + Thread.currentThread() + "size changed  : " + receivedStrings.get(size-1));
			 // fos.write(receivedStrings.get(size-1).getBytes());
			//  fos.write("\r\n".getBytes());
    	  }
      }
	  //fos.close();
	  //System.out.println("end");
	  //while(true);
    }

    public static void main(String[] args) throws IOException{
       new ExecutorServiceTest().run();
       System.exit(0);
    }
}