package udemy.dsa.linkedlist;

/**
 * Class to model a Singly Linked List.
 * 
 * @author Kazi Arham
 *
 */
public class SinglyLinkedList {
	private ListNode head;
	
	/**
	 * Inner class to model a list node and this represents a Singly Linked List.
	 * 
	 * @author Kazi Arham
	 *
	 */
	private static class ListNode {
		private int data;	// Generic Type - data
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
	 * Prints the elements of a Singly Linked List.
	 */
	public void display() {
		ListNode current = head;
		
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		
		System.out.print("null");
	}
	
	/**
	 * Finds the length of a Singly Linked List.
	 * 
	 * Returns the number of nodes in the Singly Linked List.
	 * 
	 * @return count
	 */
	public int length() {
		// If the head node is null, return 0
		if (head == null) {
			return 0;
		}
				
		int count = 0;
		ListNode current = head;
		
		/*
		 * Loop to check if current is not null.
		 * If condition is true, then increment count by 1 and point current to its next value
		 */
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	/**
	 * Inserts a node at the beginning of a Singly Linked List.
	 * 
	 * @param value The node value
	 */
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	/**
	 * Inserts a node at the end of a Singly Linked List.
	 * 
	 * @param value The node value
	 */
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		// If the head node is null, point head to new node and return the method
		if (head == null) {
			head = newNode;
			return;
		}
		
		ListNode current = head;
		
		/*
		 * Loop to check if current's next value is not null.
		 * If condition is true, point current to its next value.
		 */
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	/**
	 * Searches an element in a Singly Linked List.
	 * 
	 * Returns true if the search key is found and returns false if the search key is not found.
	 * 
	 * @param head The head node
	 * @param searchKey The key we are searching
	 * @return false
	 */
	public boolean find(ListNode head, int searchKey) {
		// If the head node is null, return false
		if (head == null) {
			return false;
		}
				
		ListNode current = head;
		
		/*
		 * Loop to check if current's next value is not null.
		 * If condition is true, do an if statement to check if current data is the search key. 
		 * If that condition is true, return true.
		 * Point current to its next value.
		 */
		while (current != null) {
			if (current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}
	
	/**
	 * Reverses a Singly Linked List.
	 * 
	 * Returns the previous node in the Singly Linked List.
	 * 
	 * @param head The head node
	 * @return previous
	 */
	public ListNode reverse(ListNode head) {
		// If the head node is null, return head node
		if (head == null) {
			return head;
		}
				
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		/*
		 * Loop to check if current's next value is not null.
		 * If the condition is true, point next node to current's next value.
		 * Then point current's next to previous node.
		 * Then point previous node to current node.
		 * Then current node to next node.
		 */
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
	
	/**
	 * Finds the middle node in a Singly Linked List.
	 * 
	 * Returns the slow pointer in the Singly Linked List.
	 * 
	 * @return slowPtr
	 */
	public ListNode getMiddleNode() {
		// If the head node is null, return null
		if (head == null) {
			return null;
		}
				
		ListNode slowPtr = head;
		ListNode fastPtr = head;
				
		/*
		 * Loop to check if fast pointer and fast pointer's next value are not null.
		 * If both conditions are true, point slow pointer to its next value and point fast pointer to its next value twice.
		 */
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
				
		return slowPtr;
	}
	
	/**
	 * Finds the nth node from the end in a Singly Linked List.
	 * 
	 * Returns the main pointer in the Singly Linked List.
	 * 
	 * @param n The nth value
	 * @return mainPtr
	 */
	public ListNode getNthNodeFromEnd(int n) {
		// If the head node is null, return null
		if (head == null) {
			return null;
		}
				
		// If nth value is less than or equal to 0, throw an exception
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
				
		ListNode mainPtr = head;
		ListNode refPtr = head;
				
		int count = 0;
				
		/*
		 * Loop to check if count is less than the nth value.
		 * If the condition is true, then do a conditional statement to check if reference pointer is null.
		 * If that condition is true, throw an exception.
		 * Then point reference pointer to its next value.
		 * Increment count by 1.
		 */
		while (count < n) {
			if (refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}
				
		/*
		 * Loop to check if reference pointer is not null.
		 * If the condition is true, point reference pointer to its next value.
		 * Then point main pointer to its next value.
		 */
		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
				
		return mainPtr;
	}
	
	/**
	 * Inserts a node in a sorted Singly Linked List.
	 * 
	 * Returns the head node in the Singly Linked List.
	 * 
	 * @param value The node value
	 * @return head
	 */
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		
		// If the head node is null, return new node
		if (head == null) {
			return newNode;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		/*
		 * Loop to check if current node is not null and current data is less than new node data.
		 * If the condition is true, point temp to current node.
		 * Then point current to its next value.
		 */
		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	
	/**
	 * Removes a given key from Singly Linked List.
	 * 
	 * @param key The node we are about to delete
	 */
	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;
		
		// If current is not null and current data is the key, point head to current's next value and return the method
		if (current != null && current.data == key) {
			head = current.next;
			return;
		}
		
		/*
		 * Loop to check if current is not null and current data is not the key.
		 * If the condition is true, point temp to current and point current to its next value.
		 */
		while (current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		
		// If current is null, return the value
		if (current == null) {
			return;
		}
		
		temp.next = current.next;
	}
	
	/**
	 * Detects a loop in a Singly Linked List.
	 * 
	 * Returns true if a loop is detected.
	 * Otherwise return false if no loop is detected.
	 * 
	 * @return false
	 */
	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		/*
		 * Loop to check if fast pointer and fast pointer's next value are not null.
		 * If the condition is true, then point fast pointer to its next value and point slow pointer to its next value.
		 * Do an conditional statement to check if slow pointer and fast pointer are the same.
		 * If that condition is true, return true.
		 */
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Creates a loop in a Singly Linked List.
	 */
	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}
	
	/**
	 * The main method of this application.
	 * 
	 * NOTE: This method can be edited if you want to call any of the methods above.
	 * 
	 * @param args The number of arguments
	 */
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createALoopInLinkedList();
		System.out.println(sll.containsLoop());
	}

}
