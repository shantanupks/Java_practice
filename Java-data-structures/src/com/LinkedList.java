package com;

import java.io.IOException;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

	private Node head = null;
	public static int len1 = 0;

	public void add(E e) {
		Node newNode = new Node(e);
		Node node;

		if (head == null) {
			head = newNode;
			head.setNext(null);
		} else {
			node = head;

			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(newNode);
			newNode.setNext(null);
		}
		System.out.println("Node added");
		len1++;
	}

	public int size() {
		return len1;
	}

	public boolean add(int idx, E e) throws IOException {
		if (idx == len1) {
			add(e);
			return true;
		}

		if (idx < len1) {
			Node newNode = new Node(e);
			Node p = head;
			Node q = p;
			int count = 0;

			if (idx == 0) {
				head = newNode;
				head.setNext(p.getNext());
			} else {
				while (count != idx) {
					q = p;
					p = p.getNext();
					count++;
				}
				q.setNext(newNode);
				newNode.setNext(p);
			}
			System.out.println("Node added");
			len1++;
			return true;
		} else {
			throw new IOException("error.......");
		}

	}

	public boolean set(int idx, E e) throws IOException {
		int count = 0;
		Node newNode = new Node(e);
		Node p = head;
		Node q;
		if (idx < len1) {

			while (count != idx) {
				p = p.getNext();
				count++;
			}
			p.setData(e);
			System.out.println("Node changed");
			return true;
		} else {
			throw new IOException("error....");
		}

	}

	public E get(int idx) {
		int count = 0;
		Node p = head;
		while (count != idx) {
			p = p.getNext();
			count++;
		}
		return p.getData();

	}

	public void reverse() {
		Node current = head;
		Node prev = null;
		Node nextN = current;
		int count = 0;

		while (count != len1) {
			nextN = current.getNext();
			current.next = prev;
			prev = current;
			current = nextN;
			count++;
		}
		head = prev;
		System.out.println("Reversed");

	}

	public void removeEle(E e) {
		boolean flag = true;
		Node p = head;
		Node q = p;

		while (p.getData()!=e) {
			q = p;
			p = p.getNext();
		}
		if (p == null) {
			System.out.println("element does not exist");
		}else {
			if(p==head) {
				head = p.getNext();
				System.out.println("element deleted");

			}
			q.next = p.getNext();
		}

	}

	public void removeInd(int idx) {

		Node p = head;
		Node q = p;
		int count = 0;
		try {
			if(idx == 0) {
				head = p.getNext();
			}
			if (idx < len1) {
				while (count != idx) {
					q = p;
					p = p.getNext();
					count++;
				}
				q.next = p.getNext();
				System.out.println("element deleted");
			} else {
				throw new IOException("error......");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// way-1 : Named Local Inner class

	// way-2 : Anonymous class

	public Iterator<E> iterator() {

		class IteratorImpl implements Iterator<E> {
			Node temp = head;

			@Override
			public boolean hasNext() {
				if (temp != null)
					return true;
				else
					return false;
			}

			@Override
			public E next() {
				E e = temp.getData();
				temp = temp.getNext();
				return e;
			}

		}
		return new IteratorImpl();

//		
//		return new Iterator<E>() {
//			Node temp = head;
//			@Override
//			public boolean hasNext() {
//				// TODO Auto-generated method stub
//				if(temp!=null)
//					return true;
//				else
//					return false;
//			}
//			
//			@Override
//			public E next() {
//				// TODO Auto-generated method stub
//				E e = temp.getData();
//				temp = temp.getNext();
//				return e;
//			}
//		};

	}

	private class Node {
		private E data;
		private Node next;

		public Node(E data) {
			this.data = data;
		}

		public Node(E data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
