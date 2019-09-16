package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) throw new QueueOverflowException();
		if(isEmpty()){
			tail = 0;
			head = -1;
		}
		array[++head] = element;
		elements++;
		if(head == array.length) head = -1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) throw new QueueUnderflowException();
		T tmp = array[tail];
		array[tail++] = null;
		elements--;
		if(tail == array.length) tail = 0;
		return tmp;
	}

	@Override
	public T head() {
		if(elements != 0) return array[tail];
		return null;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
