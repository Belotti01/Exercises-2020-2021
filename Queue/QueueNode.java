public class QueueNode<T> {
	private T value;
	private QueueNode<T> next;

	public QueueNode(T value, QueueNode<T> next) {
		setValue(value);
		setNext(next);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public QueueNode<T> getNext() {
		return next;
	}

	public void setNext(QueueNode<T> next) {
		this.next = next;
	}
}
