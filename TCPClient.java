import java.net.*;
import java.io.*;
class TCPClient{
	public static void main(String[] args)throws Exception{
		BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
		Socket socket = new Socket("127.0.0.1", 4000);
		System.out.print("Enter file name: ");
		String fileName = keyReader.readLine();
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream, true);
		writer.println(fileName);
		InputStream inputStream = socket.getInputStream();
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));
		String string;
		while((string = socketReader.readLine()) != null){
			System.out.println(string);
		}
		writer.close();
		socketReader.close();
		keyReader.close();
	}
}
