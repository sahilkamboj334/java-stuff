package randon;

import java.util.HashSet;

//reverse//sort
public class LinkListImpl<T> {
	Node head;

	public void insert(T data) {
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (this.head == null) {
			this.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = this.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;

		}

	}

	public Node getNode(int pos) {
		System.out.println("getting node for pos " + pos);
		if (pos <= 0) {
			return null;
		}
		int count = 1;
		Node current = head;
		Node tmp = null;
		while (current != null) {
			if (count == pos) {
				tmp = current;
				break;
			}
			current = current.next;
			count++;
		}
		return tmp;
	}

	public void addFirst(T data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public void insertAt(int pos, Node a) {
		Node pre = getNode(pos - 1);
		a.next = pre.next;
		pre.next = a;
	}

	public void traverse() {
		Node cr = head;
		while (cr != null) {
			System.out.print(cr.data+"=");
			cr = cr.next;
		}
		System.out.println();
	}

	public void deleteNode(T data) {
		Node temp=null;
		if(head.data==data && head.next!=null) {
			head=head.next;
			return;
		}
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				Node delete = current;
				Node pre = temp;
				pre.next = delete.next;
				break;
			}
			temp=current;
			current = current.next;

		}
	}

	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@SuppressWarnings("rawtypes")
	public LinkListImpl reverse() {
		int count = this.size();
		LinkListImpl<T> tmp = new LinkListImpl<T>();
		while (count > 0) {
			tmp.insert((T) getNode(count).data);
			count--;
		}
		this.head = tmp.head;
		return this;
	}

	public void reverseWithoutTemp() {
		Node current = head;
		Node pre = null,next=null;
		while (current != null) { 
            next = current.next; 
            current.next = pre; 
            pre = current; 
            current = next; 
        } 
        head = pre; 
	}

	class Node implements Comparable<T>{
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public int compareTo(T o) {
			return this.compareTo(o);
		}
	}
	
	public void removeDuplicatesSorted() {
		Node current=head;
		while(current!=null && current.next!=null) {
			if(current.data==current.next.data) {
				current.next=current.next.next;
			}else {
			current=current.next;
			}
		}
	}
	public void removeDuplicatesUnSorted() {
		Node current=head;
		Node temp=null;
		HashSet<T> set=new HashSet<T>();
		while(current!=null) {
			if(set.contains(current.data)) {
				temp.next=current.next;
				current=temp.next;
			}else {
			set.add(current.data);
			temp=current;
			current=current.next;
			}

		}
	}

	public static void main(String[] args) {
		LinkListImpl<Integer> l = new LinkListImpl<Integer>();
		l.insert(5);
		l.insert(5);
		l.insert(6);
		l.insert(7);
		l.insert(8);
		l.insert(10);
		l.insert(5);
		l.insert(5);
//		l.insertAt(3, l.new Node(10));

//		l.deleteNode(7);
		l.addFirst(2);
//		l.removeDuplicatesUnSorted();
//		l.deleteNode(10);
		l.traverse();
		l.reverseWithoutTemp();
		l.traverse();
	}

}
