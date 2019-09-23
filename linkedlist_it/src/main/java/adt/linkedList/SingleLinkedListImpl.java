package adt.linkedList;

import java.lang.reflect.Array;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int tmp = 0;
		SingleLinkedListNode aux = head;
		while(!aux.isNIL()){
			tmp++;
			aux = aux.getNext();
		}
		return tmp;
	}

	@Override
	public T search(T element) {
		T ans = null;
		SingleLinkedListNode aux = head;
		while(!aux.isNIL()){
			if(aux.getData().equals(element)) ans = element;
			aux = aux.getNext();
		}
		return ans;
	}

	@Override
	public void insert(T element) {
		if(element == null) return;
		SingleLinkedListNode aux = head;
		while (!aux.isNIL()) {
			aux = aux.getNext();
		}
		aux.setData(element);
		aux.setNext(new SingleLinkedListNode());
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode aux = head;
		while(!aux.isNIL()){
		    if(aux.getNext().getData().equals(element)) {
		        aux.setNext(aux.getNext().getNext());
		        return;
            }
		    aux = aux.getNext();
        }

	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[size()];
		SingleLinkedListNode aux = head;
		int it = 0;
		while(!aux.isNIL()){
		    arr[it++] = (T) aux.getData();
		    aux = aux.getNext();
		}
        return arr;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
