package randon;

import java.util.ArrayList;

public class MyStack<T> {

	private ArrayList<T> objList;
	private int top = -1;
	
	public MyStack() {
		objList = new ArrayList<T>();
	}
public boolean isEmpty() {
	return top==-1;
}
	public void push(T obj) {
		if (obj != null) {
			this.objList.add(obj);
			this.top++;
		}
	}

	public T pop() {
		if (top >= 0) {
			T item = this.objList.get(top);
			this.objList.remove(top);
			this.objList.trimToSize();
			this.top--;
			return item;
		} else {
			return null;
		}
	}
	public void pip() {
		System.out.println(this.objList);
	}
	
	public static void main(String[] args) {
		MyStack<Integer> m=new MyStack<Integer>();
		m.push(5);
		m.push(8);
		m.push(9);
		m.push(10);
		System.out.println(m.pop());
		m.pip();
	}
}
