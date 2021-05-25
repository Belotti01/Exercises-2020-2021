import java.util.EmptyStackException;

public class StaticStack {
	private int[] stack;
	private int pointer;

	private StaticStack(int size) {
		stack = new int[size];
		pointer = 0;
	}

	public StaticStack(int size, int value) {
		this(size);
		stack[pointer] = value;
	}

	public void push(int value) {
		stack[++pointer] = value;
	}

	public int pop() throws EmptyStackException {
		if(pointer == -1) throw new EmptyStackException();
		return stack[pointer--];
	}

	public int size() {
		return pointer + 1;
	}
}
