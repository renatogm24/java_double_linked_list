package com.codingdojo.doublelinkedlist;

public class DoubleLinkedList {
	public Node head;
	public Node tail;

	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// el método push agregará un nuevo nodo al final de la lista
	public void push(Node newNode) {
		// si no hay head en la lista, es decir, una lista vacía, establecemos el
		// newNode para que sea head y el tail de la lista
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}

		// primero encuentra el lastNode en la lista
		// luego, establece next al lastNode para ser el newNode
		// después, tenemos que establecer el previous del lastNode al lastNode que
		// encontramos antes
		// finalmente, establecemos el tail de la lista para que sea el nodo que hemos
		// agregadocopy
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}

	public void printValuesForward() {
		// encuentra el primer nodo, también conocido como head.
		Node current = this.head;

		// mientras exista el nodo actual...
		while (current != null) {
			// imprime su valor
			System.out.println(current.value);
			// y pasa al siguiente nodo.
			current = current.next;
		}
	}

	public void printValuesBackward() {
		// encuentra el primer nodo, también conocido como head.
		Node current = this.tail;

		// mientras exista el nodo actual...
		while (current != null) {
			// imprime su valor
			System.out.println(current.value);
			// y pasa al siguiente nodo.
			current = current.previous;
		}
	}

	public Node pop() {
		Node current = this.tail;
		Node prev = current.previous;
		prev.next = null;
		tail = prev;
		return current;
	}

	public boolean contains(int value) {
		Node current = this.head;
		while (current != null) {
			if (current.value == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public int size() {
		Node current = this.head;
		int cont = 0;
		while (current != null) {
			cont++;
			current = current.next;
		}
		return cont;
	}

	public void insertAt(Node newNode, int index) {
		Node current = this.head;
		int cont = 0;
		while (current != null) {
			if (cont == index) {
				if (current.previous == null) {
					head = newNode;
					newNode.next = current;
					newNode.previous = null;
					current.previous = newNode;
				} else {

					newNode.next = current;
					current.previous.next = newNode;
					newNode.previous = current.previous;
					current.previous = newNode;

				}
			}
			current = current.next;
			cont++;
		}
	}
	
	public void removeAt(int index) {
		Node current = this.head;
		int cont = 0;
		while (current != null) {
			if (cont == index) {
				if (current.previous == null) {
					head = current.next;
				} else if(current.next == null) {
					current.previous.next = null;
					tail = current.previous;
				} else {
					current.previous.next = current.next;
					current.next.previous = current.previous;
				}
			}
			current = current.next;
			cont++;
		}
	}
	
	public boolean isPalindrome() {
		
		Node start = this.head;
		Node end = this.tail;
		
		while(start != end) {
			if (start.value == end.value) {
				start = start.next;
				end = end.previous;
			}else {
				return false;
			}
		}
		
		return true;
	}
}
