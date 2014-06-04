import java.io.IOException;
import java.net.BindException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import biz.source_code.base64Coder.Base64Coder;
import Sender_Receiver.Sender;
import Sender_Receiver.ServerListener;
public class RunSender implements Runnable {
   private int seq;
   public RunSender() {}
   public RunSender(int i) { seq = i; }

  
public void run() {
	// TODO Auto-generated method stub
	 Sender sender = new Sender();
	   try {
		sender.init("127.0.0.1");
	} catch (BindException | UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   do{
		   try {
			sender.SendData(sender.PreparePacket(Base64Coder.encodeLines("aa".getBytes()).getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }while(true);
}
}