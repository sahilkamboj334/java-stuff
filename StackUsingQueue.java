package randon;

public class StackUsingQueue<T> {

	private QueueImpl<T> queue1,queue2;
	
	public StackUsingQueue() {
		queue1=new QueueImpl<T>();
		queue2=new QueueImpl<T>();
	}
	public void push(T data) {
		if(data!=null) {
			queue1.enqueue(data);
		}
	}
	public boolean isEmpty() {
		return queue1.size()==0;
	}
	public int size() {
		return queue1.size();
	}
	public T pop() {
		if(queue1.isEmpty()) {
			return null;
		}
		while(queue1.size()>1) {
			queue2.enqueue(queue1.dequeue());
		}
		System.out.println(queue1+"   "+queue2);
		T item=queue1.dequeue();
		while(!queue2.isEmpty()) {
			queue1.enqueue(queue2.dequeue());
		}
		return item;
	}
}
