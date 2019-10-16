import java.net.*;
import java.io.*;
class TCPServer{
	public static void main(String[] args)throws Exception{
		ServerSocket serverSocket = new ServerSocket(4000);
		System.out.println("Server ready for connection");
		Socket socket = serverSocket.accept();
		System.out.println("Connection successful, waiting to chat");
		InputStream inputStream = socket.getInputStream();
		BufferedReader readFile = new BufferedReader(new InputStreamReader(inputStream));
		String fileName = readFile.readLine();
		BufferedReader contentReader = new BufferedReader(new FileReader(fileName));
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream, true);
		String string;
		while((string = contentReader.readLine()) != null){
			writer.println(string);
		}
		socket.close();
		serverSocket.close();
		writer.close();
		readFile.close();
		contentReader.close();
	}
}
