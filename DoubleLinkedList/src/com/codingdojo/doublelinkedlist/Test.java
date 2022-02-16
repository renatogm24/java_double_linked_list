package com.codingdojo.doublelinkedlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList dll = new DoubleLinkedList();
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(50);
		Node n4 = new Node(60);
		Node n5 = new Node(80);
		Node n6 = new Node(100);

		dll.push(n1);
		dll.push(n2);
		dll.push(n3);
		dll.push(n4);
		dll.push(n5);
		dll.push(n6);

		dll.printValuesForward();

		Node eliminado = dll.pop();
		System.out.println("Nodo eliminado: " + eliminado.value);

		dll.printValuesForward();

		System.out.println(dll.contains(80));
		System.out.println(dll.contains(90));

		System.out.println(dll.size());
		
		System.out.println("---------------");
		
		dll.insertAt(new Node(1000), 2);
		dll.printValuesForward();
		
		System.out.println("---------------");

		dll.removeAt(5);
		dll.printValuesForward();
		
		System.out.println("---------------");
		
		dll.removeAt(3);
		dll.removeAt(3);
		dll.push(new Node(20));
		dll.push(new Node(10));
		dll.printValuesForward();
		
		System.out.println("---------------");
		
		System.out.println(dll.isPalindrome());
	}

}
