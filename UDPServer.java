import java.io.*;
import java.net.*;
class UDPServer{
	public static void main(String[] args)throws Exception{
		int portNo = 2000;
		boolean closeConnection = false;
		System.out.println("Server is running...");
		String exitCommand = new String("exit");
		while(true && !closeConnection){
			InetAddress clientIP = InetAddress.getLocalHost();
			int clientPort = portNo;
			byte[] buf = new byte[1024];
			DatagramSocket datagramSocket = new DatagramSocket();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String str = new String(bufferedReader.readLine());
			if(str.equals(exitCommand)){
				closeConnection = true;
				str = "Exiting at server...";
			}
			buf = str.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buf, str.length(), clientIP, clientPort);
			datagramSocket.send(datagramPacket);
			portNo = portNo + 1;
			if(closeConnection){
				datagramSocket.close();
			}
		}
	}
}
