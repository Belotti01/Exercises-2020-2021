public class StackNode {
	private int value;
	private StackNode nextNode;

	public StackNode(int value) {
		this.value = value;
	}

	public StackNode(StackNode next, int value) {
		setValue(value);
		setNextNode(next);
	}

	public int getValue() { return value; }
	public void setValue(int value) {
		this.value = value;
	}

	public StackNode getNextNode() { return nextNode; }
	public void setNextNode(StackNode node) {
		this.nextNode = node;
	}
}
