import java.util.concurrent.*;

public class CallBackTest {
   private static int NUM_OF_TASKS = 50;
   Object result;
   int cnt = 0;
   long begTest, endTest;

   public CallBackTest() {
      begTest = new java.util.Date().getTime();
   }

   public void callBack(Object result) {
      System.out.println("result "+result);
      this.result = result;
      if(++cnt == 50) {
         Double secs = new Double((new java.util.Date().getTime() - begTest)*0.001);
         System.out.println("run time " + secs + " secs");
         System.exit(0);
      }
   }

   public void run() {
      int nrOfProcessors = Runtime.getRuntime().availableProcessors();
      ExecutorService es = Executors.newFixedThreadPool(20);
      for(int i = 0;  i < NUM_OF_TASKS; i++) {
         CallBackTask task = new CallBackTask(i);
         task.setCaller(this);
         es.submit(task);
         // at this point after submitting the tasks the
         // main thread is free to perform other work.
      }
   }

   public static void main(String[] args) {
      new CallBackTest().run();
   }
}