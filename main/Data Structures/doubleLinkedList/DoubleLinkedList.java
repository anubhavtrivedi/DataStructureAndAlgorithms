package doubleLinkedList;

public class DoubleLinkedList {
	static Node root = null;

	public static void insert(int x) {
		if (root == null) {
			root = new Node(x);
			return;
		}
		Node temp = root;
		while (true) {
			if (temp.sucessor == null) {
				temp.sucessor = new Node(x);
				temp.sucessor.predecessor = temp;
				return;
			} else {
				temp = temp.sucessor;
			}
		}
	}

	public static void delete(int x) {
		if (root.data == x) {
			root = root.sucessor;
			return;
		}
		Node child, prnt = root;
		while (prnt.sucessor != null) {
			child = prnt.sucessor;
			if (child.data == x) {
				System.out.println("deleting : " + child.data);
				if (child.sucessor != null) {
					prnt.sucessor = child.sucessor;
					child.sucessor.predecessor = prnt;
				} else {
					prnt.sucessor = null;
				}
				return;
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
			if (temp.sucessor == null) {
				System.out.println("not found");
				return null;
			} else {
				temp = temp.sucessor;
			}
		}
	}

	public static void treverse() {

		Node temp = root;
		while (true) {
			System.out.print(temp.data + "  ");
			if (temp.sucessor == null)
				return;
			else
				temp = temp.sucessor;
		}
	}

}
