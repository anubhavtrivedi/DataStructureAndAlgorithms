package singleLinkedList;

public class Test {
	public static void main(String[] args) {
		SingleLinkedList.insert(1);
		SingleLinkedList.insert(2);
		SingleLinkedList.insert(3);
		SingleLinkedList.insert(4);
		SingleLinkedList.insert(5);
		SingleLinkedList.insert(6);
		System.out.println("firstPass ");
		SingleLinkedList.treverse();
		SingleLinkedList.delete(6);
		SingleLinkedList.delete(3);
		System.out.println("SecondPass");
		SingleLinkedList.treverse();

	}
}