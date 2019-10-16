import java.util.*;

class LeakyBucket{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the bucket size: ");
		int bucketSize = in.nextInt();
		System.out.println("\nEnter the operation rate: ");
		int operationRate = in.nextInt();
		System.out.println("\nEnter number of seconds to simulate: ");
		int noOfSeconds = in.nextInt();
		int[] packets = new int[noOfSeconds];
		System.out.println();
		for(int i = 0; i < noOfSeconds; ++i){
			System.out.print("Enter the size of packet transmitted at " + (i + 1) + " seconds: ");
			packets[i] = in.nextInt();
		}
		int packetsDropped = 0;
		int packetsSent = 0;
		int currentPacketCount = 0;
		int i = 0;
		System.out.println("\nTime\tPackets Received\tPackets sent\tPackets left\tPackets Dropped");
		for(i = 0; i < noOfSeconds; ++i){
			packetsDropped = 0;
			currentPacketCount += packets[i];
			if(currentPacketCount > bucketSize){
				packetsDropped = currentPacketCount - bucketSize;
				currentPacketCount = bucketSize;
			}
			if(currentPacketCount > operationRate){
				packetsSent = operationRate;
			}else{
				packetsSent = currentPacketCount;
			}
			currentPacketCount -= packetsSent;
			System.out.println("\n" + (i + 1) + "\t\t" + packets[i] + "\t\t" + packetsSent + "\t\t" + currentPacketCount + "\t\t" + packetsDropped);
		}
		for(; currentPacketCount != 0; ++i){
			if(currentPacketCount > bucketSize){
				packetsDropped = currentPacketCount - bucketSize;
				currentPacketCount = bucketSize;
			}
			if(currentPacketCount > operationRate){
				packetsSent = operationRate;
			}else{
				packetsSent = currentPacketCount;
			}
			currentPacketCount -= packetsSent;
			System.out.println("\n" + (i + 1) + "\t\t" + "0" + "\t\t" + packetsSent + "\t\t" + currentPacketCount + "\t\t" + packetsDropped);
		}
		System.out.println();
	}
}
