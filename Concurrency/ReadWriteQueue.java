package myconcurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteQueue<E>{
	
	private final int capacity = 1000;
	int size;
	Node<E> head;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	
	static class Node<E> {
		E item;
		Node<E> next;
		Node(E x) {
			item = x;
		}
		Node(){
		}
	}
	
	public ReadWriteQueue(int s){
		size = s;
		head = new Node<>();
	}
	
	public void push(E x) throws InterruptedException{
		lock.lock();
		try {
			while(size == capacity) {
				notFull.await();
			}
			Node<E> tmp = new Node<E>(x);
			Node<E> p = head;
			while(p.next != null) {
				p = p.next;
			}
			p.next = tmp;
			size++;
			notEmpty.signal();
		}finally {
			lock.unlock();
		}
	}
	
	public E pop() throws InterruptedException{
		lock.lock();
		try {
			while(size == 0 || head == null) {
				notEmpty.await();
			}
			Node<E> p = head;
			head = head.next;
			p.next = null;
			size--;
			notFull.signal();
			return p.item;
		} finally {
			lock.unlock();
		}
	}
	
	public int getSize() {
		return size;
	}
}
