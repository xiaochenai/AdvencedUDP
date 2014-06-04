   import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;	

import IDACS_Connection.*;
import IDACS_Common.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import biz.source_code.base64Coder.Base64Coder;

public class SenderStart {
	public static void main(String argv[]) 
	 {
		try{
			byte[] buf = new byte["start".getBytes().length];
            // don't wait for request...just send a quote

            String dString = "start";
           
            buf = dString.getBytes();
			MulticastSocket socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("228.5.6.7");
            DatagramPacket packet;
            packet = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);
			while(true);
			
		}catch(Exception e ){
			
			e.printStackTrace();
		}
	  
	  
	 }
}
