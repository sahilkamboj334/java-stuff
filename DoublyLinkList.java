package randon;

public class DoublyLinkList<T extends Object> {
	Node head;

	class Node {

		Node pre;
		T data;
		Node next;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((pre == null) ? 0 : pre.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (pre == null) {
				if (other.pre != null)
					return false;
			} else if (!pre.equals(other.pre))
				return false;
			return true;
		}

		public Node(T data) {
			this.data = data;
		}

		@SuppressWarnings("rawtypes")
		private DoublyLinkList getEnclosingInstance() {
			return DoublyLinkList.this;
		}

	}

	public void insert(T data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node temp = new Node(data);
			current.next = temp;
			temp.pre = current;
		}
	}

	public void addFirst(T data) {
		Node n = new Node(data);
		n.pre = null;
		n.next = head;
		head.pre = n;
		head = n;
	}

	public void traverse() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		Node current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public Object get(int index) {
		if (index <= 0) {
			return head.data;
		} else if (this.size() < index) {
			return null;
		}
		Node current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
			if (count == index) {
				return current.data;
			}
		}
		return null;
	}

	public void insertAt(int pos, T data) {
		if (pos < 0) {
			return;
		} else if (pos == 0) {
			addFirst(data);
			return;
		}
		int count = 1;
		Node current = head.next;
		while (current != null) {
			if (count == pos) {
				Node tmp = new Node(data);
				tmp.next = current;
				current.pre.next = tmp;
				tmp.pre = current.pre;
				current.pre = tmp;

			}
			count++;
			current = current.next;
		}
	}

	public void reverse() {
		Node current = head;
		Node temp = null;
		while (current != null) {
			temp = current.pre;
			current.pre = current.next;
			current.next = temp;
			current = current.pre;
		}
		if (temp != null) {
			head = temp.pre;
		}
	}

	public void reverseRecursive() {
		reverseRecursive(head);
	}

	private Node reverseRecursive(Node node) {
		if (node == null)
			return null;
		Node temp = node.pre;
		node.pre = node.next;
		node.next = temp;
		if (node.pre == null) {
			head = node;
			return node;
		} else
			return reverseRecursive(node.pre);

	}

	public Object[] toArray() {
		int i = 0;
		Object[] a = new Object[this.size()];
		Node current = head;
		while (current != null) {
			a[i] = current.data;
			current = current.next;
			i++;
		}
		return a;
	}

	/**
	 * sort work only on integer
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		Object[] temp = this.toArray();
		this.head = null;
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp.length - 1; j++) {
				if ((Integer) temp[j] > (Integer) temp[j + 1]) {
					Object t = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = t;
				}
			}
			this.insert(((T) temp[i]));
		}
		this.insert((T) temp[temp.length - 1]);
	}

	public void remove(T data) {
		Node current = head;
		if (head.data == data) {
			head = head.next;
			head.pre = null;
			return;
		}
		while (current != null) {
			if (current.data == data) {
				if (current.next != null) {
					current.pre.next = current.next;
					current.next.pre = current.pre;
					current.pre = null;
					current.next = null;
				} else {
					current.pre.next = null;
				}

			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		DoublyLinkList<String> list = new DoublyLinkList<String>();
		list.insert("sa");
		list.insert("saff");
		list.insert("sadd");
		/*
		 * list.insert(9); list.insert(10); list.addFirst(5); list.insertAt(3, 6);
		 * list.insertAt(4, 8); list.insertAt(5, 7);
		 */
		list.traverse();
		list.sort();
		list.traverse();

	}
}
