import java.util.*;

class CRC{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String divisor = "10001000000100001";
		System.out.print("Enter data bits: ");
		String data = in.nextLine();
		System.out.println();
		String modifiedData = "0" + data;
		for(int i = 0; i < 16; ++i){
			modifiedData += "0";
		}
		String checksum = crc(divisor, modifiedData);
		System.out.println("Checksum generated according to data = " + checksum + "\n");
		System.out.print("Enter data to be transmitted: ");
		modifiedData = in.nextLine();
		modifiedData = "0" + modifiedData;
		checksum = crc(divisor, modifiedData);
		if(checksum.equals("0000000000000000")){
			System.out.println("\nNo error in transmitted data!\n");
		}else{
			System.out.println("\nError in transmitted data!\n");
		}
	}

	static String crc(String divisor, String data){
		String subtractedFrom = data.substring(0, 18);
		String remainingData = data.substring(18, data.length());
		String afterSubtraction = "";
		int k, l = 0;
		for(int i = 0; i <= remainingData.length(); ++i){
			char leftMost = subtractedFrom.charAt(1);
			afterSubtraction = "";
			if(leftMost == '1'){
				k = 1;
				for(int j = 0; j < divisor.length(); ++j){
					afterSubtraction += xor(subtractedFrom.charAt(k), divisor.charAt(j));
					++k;
				}
			}
			if(leftMost == '0'){
				k = 1;
				for(int j = 0; j < divisor.length(); ++j){
					afterSubtraction += xor(subtractedFrom.charAt(k), '0');
					++k;
				}
			}
			subtractedFrom = afterSubtraction;
			if(l < remainingData.length()){
				subtractedFrom += remainingData.charAt(l);
			}
			++l;
		}
		return subtractedFrom.substring(1, subtractedFrom.length());
	}
	
	static String xor(char A, char B){
		int a = Integer.valueOf(String.valueOf(A));
		int b = Integer.valueOf(String.valueOf(B));
		return String.valueOf(a ^ b);
	}

}
