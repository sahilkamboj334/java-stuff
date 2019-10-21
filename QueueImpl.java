package randon;

import java.util.ArrayList;

public class QueueImpl<T> {
	private ArrayList<T> list;
	private int rear = 0, front = -1;

	public QueueImpl() {
		list = new ArrayList<T>();
	}

	public void enqueue(T data) {
		list.add(data);
		this.front++;
	}
	public boolean isEmpty() {
		return front==-1;
	}

	public T dequeue() {
		if (this.front < 0) {
			return null;
		}
		T item = this.list.get(rear);
		this.list.remove(rear);
		this.list.trimToSize();
		this.front--;
		return item;
	}

	public int size() {
		return this.list.size();
	}

	public T peek() {
		if (front < 0) {
			return null;
		}
		return this.list.get(rear);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return list.toString();
	}
}

class EmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyException(String msg) {
		super(msg);
	}
}
