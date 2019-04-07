import java.util.*;
public class Radix{
	public static void radixsort(int[] data){
		int maxabsval = 0;
		for(int i = 0; i < data.length; i++){
			if(Math.abs(data[i]) > maxabsval){
				maxabsval = Math.abs(data[i]);
			}
		}//holder contains all the data in a linked list
		int a = 1;
		int numrounds = 0;
		while(maxabsval >= a){
			numrounds++;
			a *= 10;
		}//this will get the absolute value of the highest number (maxabsval), and the number of digits it has (numrounds)
		@SuppressWarnings({"rawtypes", "unchecked"})
		MyLinkedList<Integer>[] buckets = new MyLinkedList[19];//ending in -9 to 9
		for(int x = 0; x < 19; x++){
			buckets[x] = new MyLinkedList<Integer>();
		}
		int place = 1;
		for(int i = 0; i < numrounds; i++){
			for(int n = 0; n < data.length; n++){
				//System.out.println(getNthDig(data[n], place));
				buckets[getNthDig(data[n], place) + 9].addLast(data[n]);
			}
			int counter = 0;
			for(int k = 0; k < 19; k++){
				while(buckets[k].getSize() > 0){//now we copy from the buckets to the array
					data[counter] = buckets[k].removeFront();
					counter++;
				}
			}
			place++;
		}
	}

	public static int getNthDig(int x, int n){
		return (x / (int)Math.pow(10, n-1)) % 10;
	}
}
