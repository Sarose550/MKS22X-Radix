public class MyLinkedList<E>{
	private int size;
	private Node<E> start;
	private Node<E> end;


	public MyLinkedList(){
		size = 0;
	}

	public void clear(){
		size = 0;
		start = null;
		end = null;
	}

	public boolean add(E data){
		Node<E> n = new Node<E>(data, null);
		end.setNext(n);
		this.end = n;
		size += 1;
		return true;
	}

	public void extend(MyLinkedList<E> other){
		end.setNext(other.start);
		this.end = other.end;
		size += other.size;
		other.clear();
	}

	public E removeFront(){
		E data = start.getData();
		if(size == 1){
			start = null;
			size = 0;
		}
		else{
			Node newstart = start.getNext();
			start = newstart;
			size -= 1;
		}
		return data;
	}
}

class Node<E>{
	private Node next;
	private E data;

	public Node(){
		data = null;
		next = null;
	}

	public Node(E stuff, Node n){
		data = stuff;
		next = n;
	}

	public Node getNext(){
		return next;
	}

	public E getData(){
		return data;
	}
	
	public void setNext(Node other){
		next = other;
	}

	public void setData(E stuff){
		data = stuff;
	}
}
