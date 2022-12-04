package udemy.dsa.linkedlist;

import java.util.NoSuchElementException;

/**
 * Class to model a Doubly Linked List.
 * 
 * @author Kazi Arham
 *
 */
public class DoublyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length;
	
	/**
	 * Inner class to model a list node and this represents a Doubly Linked List.
	 * 
	 * @author Kazi Arham
	 *
	 */
	private class ListNode {
		private int data;	// Generic Type
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * Constructor: constructs an empty list.
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	/**
	 * Returns an empty list.
	 * 
	 * @return length == 0 or head == null
	 */
	public boolean isEmpty() {
		return length == 0; // or head == null
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
	 * Prints the elements in a Doubly Linked List in a forward direction.
	 */
	public void displayForward() {
		// If the head node is null, then return the method
		if (head == null) {
			return;
		}
		
		ListNode temp = head;
		
		/*
		 * Loop to check if temp node is not null.
		 * If the condition is true, print the temp data and point temp to its next value
		 */
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	/**
	 * Prints the elements in a Doubly Linked List in a backward direction.
	 */
	public void displayBackward() {
		// If the tail node is null, then return the method
		if (tail == null) {
			return;
		}
		
		ListNode temp = tail;
		
		/*
		 * Loop to check if temp node is not null.
		 * If the condition is true, print the temp data and point temp to its previous value.
		 */
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}
	
	/**
	 * Inserts the node at the beginning of a Doubly Linked List.
	 * 
	 * @param value The node value
	 */
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		
		// If the list is empty, point tail to new node. Otherwise point head node's previous value to new node
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	/**
	 * Inserts the node at the end of a Doubly Linked List.
	 * 
	 * @param value The node value
	 */
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		// If the list is empty, point head to new node. Otherwise point tail node's next value to new node and new node's previous value to tail.
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		
		tail = newNode;
		length++;
	}
	
	/**
	 * Deletes the first node in a Doubly Linked List.
	 * 
	 * Returns the temporary node after the first node is deleted.
	 * 
	 * @return temp
	 */
	public ListNode deleteFirst() {
		// If the list is empty, throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		ListNode temp = head;
		
		// If the head and tail node are the same, point tail to null. Otherwise point head's next previous value to null.
		if (head == tail) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	/**
	 * Deletes the last node in a Doubly Linked List.
	 * 
	 * Returns the temporary node after the last node is deleted.
	 * 
	 * @return temp
	 */
	public ListNode deleteLast() {
		// If the list is empty, throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		ListNode temp = tail;
		
		// If the head and tail node are the same, point head to null. Otherwise point tail's previous next value to null.
		if (head == tail) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		
		tail = tail.previous;
		temp.previous = null;
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
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.insertLast(1);
		dll.insertLast(10);
		dll.insertLast(15);
		dll.displayForward();
		
		dll.deleteLast();
		dll.displayForward();
	}
}
