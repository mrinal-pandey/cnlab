import java.io.*;
import java.net.*;
class UDPClient{
	public static void main(String[] args)throws Exception{
		int portNo = 2000;
		boolean closeConnection = false;
		while(true && !closeConnection){
			byte[] buf = new byte[1024];
			DatagramSocket datagramSocket = new DatagramSocket(portNo);
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			datagramSocket.receive(datagramPacket);
			String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
			if(str.equals("Exiting at server...")){
				datagramSocket.close();
				str = "exit";
				closeConnection = true;
			}
			System.out.println("New message from server : " + str);
			portNo = portNo + 1;
		}
	}	
}
