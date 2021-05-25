import java.io.EOFException;
import java.util.*;

public class StrangeStack<T> extends Stack<T> {
	public T popSecondFromTop() throws CustomStackException {
		return test1();
	}

	
	//10 modi per fare la stessa roba (controllare che ci siano almeno 2 valori 
	//nello Stack) e perchè è facile capire chi copia

	private T test1() throws CustomStackException {
		if(empty())
			throw new CustomStackException(0);
		if(/*this.*/size() == 1)
			//Non è necessario specificare l'operazione che ha lanciato l'eccezione,
			//il tipo Exception contiene informazioni accessibili più specifiche 
			//per questo (vedi: StackTrace).
			throw new CustomStackException("Not enough elements in the stack for this operation.", 1);
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test2() throws CustomStackException {
		int size = size();
		if(size == 0) 
			throw new CustomStackException(0);
		if(size == 1)
			throw new CustomStackException("Not enough elements in the stack for this operation.", 1);
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test3() throws CustomStackException {
		switch(size()) {
			case 0:
				throw new CustomStackException(0);
			case 1:
				throw new CustomStackException("Not enough elements in the stack for this operation.", 1);
		}
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test4() throws CustomStackException {
		int size = size();
		if(size < 2) 
			throw new CustomStackException(size);
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test5() throws CustomStackException {
		int size = size();
		if(size < 2) 
			throw new CustomStackException("Not enough elements in the stack for this operation.", size);
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test6() throws CustomStackException {
		T top, second;
		try {
			top = pop();
			second = pop();
		}catch(EmptyStackException e) {
			throw new CustomStackException();
		}
		push(top);
		return second;
	}

	private T test7() throws CustomStackException {
		try {
			T top = pop();
			T second = pop();
			push(top);
			return second;
		}catch(EmptyStackException e) {
			throw new CustomStackException();
		}
	}

	private T test8() throws CustomStackException {
		T top, second;
		try {
			top = pop();
		}catch(EmptyStackException e) {
			throw new CustomStackException(0);
		}
		try {
			second = pop();
		}catch(EmptyStackException e) {
			throw new CustomStackException(1);
		}
		push(top);
		return second;
	}

	private T test9() throws CustomStackException {
		boolean isValid = size() > 1;
		if(!isValid)
			throw new CustomStackException(size());
		T top = pop();
		T second = pop();
		push(top);
		return second;
	}

	private T test10() throws CustomStackException {
		int size = size();
		try {
			if(size > 2)
				throw new EOFException();
			throw new CustomStackException(size);
		}catch(EOFException e) {
			T top = pop();
			T second = pop();
			push(top);
			return second;
		}
	}
}