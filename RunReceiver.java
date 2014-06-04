import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.io.FileOutputStream;
import java.io.File;
import biz.source_code.base64Coder.Base64Coder;
import Sender_Receiver.ServerListener;
public class RunReceiver implements Runnable {
   private ArrayList<String> receivedStrings;
   public RunReceiver() {}
   public RunReceiver(ArrayList<String> receivedStrings) { this.receivedStrings = receivedStrings; }
   private ArrayList<String> IPList = new ArrayList<String>();


public void run(){
	// TODO Auto-generated method stub
	ServerListener serverListener = new ServerListener();
	   try {
		serverListener.init();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   do{
		   byte[] data;
		try {
			System.out.println("before trying to read out data");
			data = serverListener.ReadData();
			System.out.println("try to read out data");
			if(data != null){
				String receivedString = new String(Base64Coder.decodeLines(new String(data)));
				String rmtIP = serverListener.getIP();
				System.out.println("received data from " + rmtIP);
				int index = 0;
				System.out.println("fos");
				FileOutputStream fos = new FileOutputStream(new File(rmtIP + ".txt"),true);
				//System.out.println("Data : " + new String(Base64Coder.decodeLines(receivedString)));
				System.out.println("write data");
				fos.write(Base64Coder.decodeLines(receivedString));
				System.out.println("close");
				//fos.flush();
				fos.close();
			}
			
			//receivedStrings.add(receivedString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   
	   }while(true);
}
}