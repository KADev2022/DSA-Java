package udemy.dsa.linkedlist;

import java.util.NoSuchElementException;

/**
 * Class to model a Circular Singly Linked List.
 * 
 * @author Kazi Arham
 *
 */
public class CircularSinglyLinkedList {
	private ListNode last;
	private int length;
	
	/**
	 * Inner class to model a list node and this represents a Circular Singly Linked List.
	 * 
	 * @author Kazi Arham
	 *
	 */
	private class ListNode {
		private ListNode next;
		private int data;	// Generic Type
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * Constructor: constructs an empty list.
	 */
	public CircularSinglyLinkedList() {
		last = null;
		length = 0;
	}
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return length
	 */
	public int length() {
		return length;
	}
	
	/**
	 * Returns an empty list.
	 * 
	 * @return length == 0 or head == null
	 */
	public boolean isEmpty() {
		return length == 0;	// or head == null
	}
	
	/**
	 * Creates a Circular Singly Linked List.
	 */
	public void createCircularLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
	}
	
	/**
	 * Traverses and prints a Circular Singly Linked List.
	 */
	public void display() {
		// If the last node is null, return the method
		if (last == null) {
			return;
		}
		
		ListNode first = last.next;
		
		/*
		 * Loop to check if the first node is not the last node.
		 * If the condition is true, print the first node's data.
		 * Then point first node to its next value.
		 */
		while (first != last) {
			System.out.print(first.data + " ");
			first = first.next;
		}
		
		System.out.print(first.data);
	}
	
	/**
	 * Inserts a node at the beginning of a Circular Singly Linked List.
	 * 
	 * @param data The node value
	 */
	public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		
		/*
		 * If the list is empty (last node is null), then last node will assign to temp.
		 * Otherwise point temp's next value to last node's next value.
		 */
		if (last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		
		last.next = temp;
		length++;
	}
	
	/**
	 * Inserts a node at the end of a Circular Singly Linked List.
	 * 
	 * @param data The node value
	 */
	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		
		/*
		 * If the list is empty (last node is null), then last node will assign to temp and last node's next value will assign to last.
		 * Otherwise point temp's next value to last node's next value, then last node's next value to temp and last node to temp.
		 */
		if (last == null) {
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		
		length++;
	}
	
	/**
	 * Removes the first node from a Circular Singly Linked List.
	 * 
	 * @return temp
	 */
	public ListNode removeFirst() {
		// If the list is empty, throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException("Circular Singly Linked List is already empty");
		}
		
		ListNode temp = last.next;
		
		// If the head and tail node are the same, point last to null. Otherwise point last's next value to temp's next value.
		if (last.next == last) {
			last = null;
		} else {
			last.next = temp.next;
		}
		
		temp.next = null;
		length--;
		return temp;
	}
	
	/**
	 * The main method of this application.
	 * 
	 * NOTE: This method can be edited if you want to call any of the methods above.
	 * 
	 * @param args The number of arguments
	 */
	public static void main(String[] args) {
		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
		csll.insertLast(1);
		csll.insertLast(8);
		csll.insertLast(10);
		
		csll.display();
		
		System.out.println();
		
		csll.removeFirst();
		
		csll.display();
	}

}
