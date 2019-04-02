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

	public boolean addLast(E data){
		Node<E> n = new Node<E>(data, null, null);
		end.setNext(n);
		n.setPrev(end);
		this.end = n;
		size += 1;
		return true;
	}

	public boolean addFirst(E data){
		Node<E> n = new Node<E>(data, null, null);
		start.setPrev(n);
		n.setNext(start);
		this.start = n;
		size += 1;
		return true;
	}

	public void extend(MyLinkedList<E> other){
		end.setNext(other.start);
		other.start.setPrev(end);
		end = other.end;
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
	private Node prev;
	private E data;

	public Node(){
		data = null;
		prev = null;
		next = null;
	}

	public Node(E stuff, Node o, Node n){
		data = stuff;
		prev = o;
		next = n;
	}

	public Node getNext(){
		return next;
	}

	public Node getPrev(){
		return prev;
	}

	public E getData(){
		return data;
	}
	
	public void setNext(Node other){
		next = other;
	}

	public Node setPrev(Node other){
		prev = other;
	}

	public void setData(E stuff){
		data = stuff;
	}
}
