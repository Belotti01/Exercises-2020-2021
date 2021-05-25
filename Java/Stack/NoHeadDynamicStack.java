public class NoHeadDynamicStack {	//Aka "Aborto"
	private int value;
	private NoHeadDynamicStack next;
	private int size;

	private NoHeadDynamicStack(NoHeadDynamicStack stack) {
		this.value = stack.value;
		this.next = stack.next;
		if(next == null) size = 0;
		else size = next.size + 1;
	}

	public NoHeadDynamicStack(int value) {
		this.value = value;
	}

	public void push(int value) {
		next = new NoHeadDynamicStack(this);
		this.value = value;
		size++;
	}

	public int pop() {
		int ret = value;
		if(next != null) {
			this.value = next.value;
			this.size = next.getSize();
			if(next.next != null) {
				next.pop();	// :^)
			}
		}
		return ret;
	}

	public int getSize() {
		return size;
	}
}