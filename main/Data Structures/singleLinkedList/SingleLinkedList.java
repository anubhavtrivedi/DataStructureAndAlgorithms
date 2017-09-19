package singleLinkedList;

public class SingleLinkedList {
	static Node root = null;

	public static void insert(int x) {
		if (root == null) {
			root = new Node(x);
			return;
		}
		Node temp = root;
		while (true) {
			if (temp.next == null) {
				temp.next = new Node(x);
				return;
			} else {
				temp = temp.next;
			}
		}
	}

	public static void delete(int x) {
		if (root.data == x) {
			root = root.next;
			return;
		}
		Node child, prnt = root;
		while (prnt.next != null) {
			child = prnt.next;
			if (child.data == x) {
				System.out.println("deleting : " + child.data);
				prnt.next = child.next;
			} else {
				prnt = child;
			}
		}
	}

	public static Node search(int x) {
		Node temp = root;
		while (true) {
			if (temp.data == x)
				return temp;
			if (temp.next == null) {
				System.out.println("not found");
				return null;
			} else {
				temp = temp.next;
			}
		}
	}

	public static void treverse() {

		Node temp = root;
		while (true) {
			System.out.print(temp.data + "  ");
			if (temp.next == null) {
				System.out.println();
				return;
			} else
				temp = temp.next;
		}
	}

}