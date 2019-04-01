package com.qiutongs.datastructure.list;

public class SingleLinkedList<I> implements List<I> {

	static class Node<I> {
		private Node<I> next;
		private I item;

		public Node(I item) {
			this.next = null;
			this.item = item;
		}

		@Override
		public String toString() {
			return item.toString();
		}
	}

	private Node<I> head;
	private Node<I> tail;

	public SingleLinkedList() {
		head = tail = null;
	}

	@Override
	public void append(I item) {
		Node<I> n = new Node<>(item);

		if (tail == null) {
			head = tail = n;
			n.next = null;
		} else {
			tail.next = n;
			n.next = null;
			tail = n;
		}
	}

	@Override
	public void insertHead(I item) {
		// TODO Auto-generated method stub
	}

	@Override
	public I search(I item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I removeTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node<I> curNode = head;

		while (curNode != null) {
			sb.append(curNode + " -> ");
			curNode = curNode.next;
		}

		sb.append("null");

		return sb.toString();
	}

	public void reverse() {
		Node<I> curNode = head, preNode = null;

		while (curNode != null) {
			Node<I> tmpNext = curNode.next;
			curNode.next = preNode;
			
			preNode = curNode;
			curNode = tmpNext;
		}
		
		head = preNode;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		
		list.append(1);
		list.append(2);
		list.append(3);
		
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
	}

}
