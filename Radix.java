public class Radix{
	public static void radixsort(int[] data){
		int maxabsval = 0;
		MyLinkedList<Integer> holder = new MyLinkedList<Integer>();
		for(int i = 0; i < data.length; i++){
			if(Math.abs(data[i]) > maxabsval){
				maxabsval = Math.abs(data[i]);
			}
			holder.addLast(data[i]);
		}
		int a = 1;
		int numrounds = 0;
		while(maxabsval >= a){
			numrounds++;
			a *= 10;
		}
		MyLinkedList<Integer>[] buckets = new MyLinkedList<Integer>[10];
	}

	public static void sortBuckets(int[] data, int round, MyLinkedList<Integer>[] buckets, MyLinkedList<Integer> holder){
		for(int i = 0; i < data.length; i++){
			if(data[i] >= 0){
				buckets[getNthDig(data[i], round)].addLast(data[i]);
			}
			else{
				buckets[getNthDig(Math.abs(data[i]), round)].addFirst(data[i]);
			}
		}

		holder.clear();
		for(int j = 0; j < 10; j++){
			Node cur = buckets[j].getStart();
			while(cur != null){
				if(buckets[j])
			}
		}
	}

	public static int getNthDig(int x, int n){
		return (x / (int)Math.pow(10, n-1)) % 10;
	}
}
