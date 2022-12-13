
public interface StackInterface<T> {
	//FROM NOTES interface for Linked Stack
	void pop() throws StackUnderflowException;
	T top() throws StackUnderflowException;
	boolean isEmpty();
	void push(T element);

}
