import java.util.*;
public class MyLinkedList<E>{
	private int size;
	private Node<E> start;
	private Node<E> end;

	public class Node<E>{
		private Node<E> next;
		private Node<E> prev;
		private E data;

		@SuppressWarnings("unchecked")
		public Node(){
			data = null;
		}

		public Node(E stuff){
			data = stuff;
		}

		public Node<E> getNext(){
			return next;
		}

		public Node<E> getPrev(){
			return prev;
		}

		public E getData(){
			return data;
		}
	
		public void setNext(Node<E> other){
			next = other;
		}

		public void setPrev(Node<E> other){
			prev = other;
		}

		public void setData(E stuff){
			data = stuff;
		}
	}


	public MyLinkedList(){
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public void clear(){
		size = 0;
		start = null;
		end = null;
	}

	public int getSize(){
		return size;
	}

	@SuppressWarnings("unchecked")
	public boolean addLast(E data){
		Node<E> n = new Node<E>(data);
		if(size == 0){
			start = n;
			end = n;
			size++;
			return true;
		}
		end.setNext(n);
		n.setPrev(end);
		this.end = n;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean addFirst(E data){
		Node<E> n = new Node<E>(data);
		if(size == 0){
			start = n;
			end = n;
			size++;
			return true;
		}
		start.setPrev(n);
		n.setNext(start);
		this.start = n;
		size++;
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
			end = null;
			size = 0;
		}

		else{
			Node newstart = start.getNext();
			start = newstart;
			size--;
		}
		return data;
	}

	public E removeLast(){
		E data = end.getData();
		if(size == 1){
			start = null;
			end = null;
			size = 0;
		}

		else{
			Node newend = end.getPrev();
			end = newend;
			size--;
		}
		return data;
	}

	public E getFirst(){
		return start.getData();
	}

	public E getLast(){
		return end.getData();
	}
}
