package doubleLinkedList;

public class Test {
	public static void main(String[] args) {
		DoubleLinkedList.insert(1);
		DoubleLinkedList.insert(2);
		DoubleLinkedList.insert(3);
		DoubleLinkedList.insert(4);
		DoubleLinkedList.insert(5);
		DoubleLinkedList.insert(6);
		System.out.println("First Pass ");
		DoubleLinkedList.treverse();

		DoubleLinkedList.delete(6);
		DoubleLinkedList.delete(3);
		System.out.println("Second Pass ");
		DoubleLinkedList.treverse();
	}
}