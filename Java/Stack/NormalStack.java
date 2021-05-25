import java.util.EmptyStackException;

// Based on: https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
// (Without stuff inherited from java.util.Vector)

public class NormalStack {
	private StackNode topNode;

	public NormalStack() {
		this.topNode = null;
	}

	public void push(int value) {
		this.topNode = new StackNode(topNode, value);
	}

	public int pop() throws EmptyStackException {
		if(topNode == null) {
			throw new EmptyStackException();
		}
		int value = topNode.getValue();
		topNode = topNode.getNextNode();
		return value;
	}

	public int peek() throws EmptyStackException {
		if(topNode == null) {
			throw new EmptyStackException();
		}
		return topNode.getValue();
	}
	
	public boolean empty() {
		return topNode == null;
	}

	public int search(int value) {
		StackNode node = topNode;
		for(int pos = 1; node != null; pos++) {
			if(node.getValue() == value) {
				return pos;
			}else {
				node = node.getNextNode();
			}
		}
		return -1;
	}

	public String toString() {
		if(empty()) return "[ ]";
		StringBuilder str = new StringBuilder("[ ");
		StackNode node = topNode;
		while(node != null) {
			str.append(node.getValue());
			str.append(", ");
			node = node.getNextNode();
		}
		str.append("\b\b ]");
		return str.toString();
	}

	public int size() {
		StackNode node = topNode;
		int size = 0;
		while(node != null) {
			size++;
			node = node.getNextNode();
		}
		return size;
	}

	public int popOneToLast() throws Exception {
		int size = size();
		if(size < 2) throw new Exception("Not enough values in the requested stack.");
		if(size == 2) return pop();
		int i;
		StackNode[] lastNodes = new StackNode[3];
		StackNode node = topNode;
		//Skip all the unrelevant nodes
		for(i = 0; i < size - 3; i++) {
			node = node.getNextNode();
		}
		//Store last 3 nodes's pointers
		for(/*Still more readable than a while with increment.*/; i < size; i++) {
			int arrayIndex = size - i - 1;
			lastNodes[arrayIndex] = node;
			node = node.getNextNode();
		}
		//Replace pointer to the popped value w/ the last's
		lastNodes[2].setNextNode(lastNodes[0]);

		return lastNodes[1].getValue();
	}
}