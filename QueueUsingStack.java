package randon;

public class QueueUsingStack<T> {

	private MyStack<T> m1,m2;
	
	public QueueUsingStack() {
		m1=new MyStack<T>();
		m2=new MyStack<T>();
	}
	public void enqueue(T data) {
		m1.push(data);
	}
	
	public T dequeue() throws Exception {
		if(m1.isEmpty()) {
			throw new Exception("null");
		}
		while(!m1.isEmpty()) {
			m2.push(m1.pop());
		}
		T item=m2.pop();
		while(!m2.isEmpty()) {
			m1.push(m2.pop());
		}
		return item;
	}
	
}
