import java.util.NoSuchElementException;

/*
Non ho seguito le docs di Java (https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
Motivo: Gli standard non sono un'opinione:
	[OVUNQUE]			[JAVA]
	enqueue 	=> 	"add()" o "offer()"
	dequeue 	=> 	"remove()" o "poll()"
*/

public class DynQueue<T> {
	private QueueNode<T> tail;
	private int size;

	public DynQueue() {
		size = 0;
	}

	public void enqueue(T value) {
		tail = new QueueNode<T>(value, tail);
		size++;
	}

	public T dequeue() throws NoSuchElementException {
		T value = peek();
		tail = tail.getNext();
		size--;
		return value;
	}

	public T peek() throws NoSuchElementException {
		if(tail == null)
			throw new NoSuchElementException("DynQueue is empty.");
		return tail.getValue();
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		//Format: [V1, V2, ..Vn]
		var str = new StringBuilder();

		str.append('[');
		QueueNode<T> node = tail;
		while(node != null) {
			str.append(node.getValue());
			str.append(", ");
			node = node.getNext();
		}
		str.append("\b\b]");

		return str.toString();
	}
}