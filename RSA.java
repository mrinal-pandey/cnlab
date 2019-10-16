import java.util.Scanner;
import java.math.BigInteger;
class RSA{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the message: ");
		String message = in.nextLine();
		int messageLength = message.length();
		int P = 0;
		int Q = 0;
		int N = 0;
		int Z = 0;
		int gcd = 0;
		int e = 2;
		int d = 2;
		boolean PFlag = false;
		boolean QFlag = false;
		do{
			P = (int)((Math.random()) * 100 + 1);
			PFlag = checkPrime(P);
		}while(!PFlag);
		do{
			Q = (int)((Math.random()) * 100 + 1);
			QFlag = checkPrime(Q);
		}while(!QFlag);
		N = P * Q;
		Z = (P - 1) * (Q - 1);
		do{
			gcd = gcdCalc(e, Z);
			++e;
		}while(gcd != 1);
		--e;
		do
		{
			++d;
		}while((e * d - 1) % Z != 0);
		System.out.println("\nP = " + P + " Q = " + Q);
		System.out.println("N = " + N);
		System.out.println("Z = " + Z);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		int[] messageToInt = new int[messageLength];
		for(int i = 0; i < messageLength; ++i){
			messageToInt[i] = (int)message.charAt(i) - 96;
		}
		int[] encrypted = new int[messageLength];
		for(int i = 0; i < messageLength; ++i){
			encrypted[i] = 1;
			for(int j = 0; j < e; ++j){
				encrypted[i] = (encrypted[i] * messageToInt[i]) % N;
			}
		}
		System.out.println("\nEncrypted message:");
		for(int i = 0; i < messageLength; ++i){
			System.out.print((char)(encrypted[i] + 96));
		}
		System.out.println();
		int[] decrypted = new int[messageLength];
		for(int i = 0; i < messageLength; ++i){
			decrypted[i] = 1;
			for(int j = 0; j < d; ++j){
				decrypted[i] = (decrypted[i] * encrypted[i]) % N;
			}
		}
		char[] intToMessage = new char[messageLength];
		for(int i = 0; i < messageLength; ++i){
			intToMessage[i] = (char)(decrypted[i] + 96);
		}
		System.out.println("\nDecrypted message:");
		for(int i = 0; i < messageLength; ++i){
			System.out.print(intToMessage[i]);
		}
		System.out.println("\n");
	}

	static int gcdCalc(int e, int z){
		if(z % e == 0){
			return e;
		}
		return gcdCalc(z % e, e);
	}

	static boolean checkPrime(int N){
		int count = 0;
		for(int i = 1; i < N / 2; ++i){
			if(N % i == 0){
				++count;
			}
		}
		if(count == 1){
			return true;
		}
		return false;
	}
}
