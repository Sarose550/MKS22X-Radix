public class Node<E>{
	private int prev;
	private int next;
	private E data;

	public Node<E>(){
		data = null;
		next = null;
		prev = null;
	}

	public Node<E>(E data, int prev, int next){
		data = null;
		next = null;
		prev = null;
	}

	public int next(){
		return next;
	}

	public int prev(){
		return prev;
	}
}
