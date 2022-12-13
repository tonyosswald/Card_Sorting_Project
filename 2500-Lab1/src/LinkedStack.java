
public class LinkedStack<T> implements StackInterface<T> {
	//Stack interface FROM NOTES, creates the Linked List structure that contains the
	//nodes from the LLNode class
	
	protected LLNode<T> top;
	int n;
	int m;

	public LinkedStack() {
		top = null;
	}
	
	public void push(T element) {
		// (1) Create new node to hold the element.  
		// (2) Make new node point where top used to.  
		// (3) Make top point to new node

		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

	public void pop() throws StackUnderflowException {
		// (1) If stack empty, throw underflow exception.  
		// (2) Else, make top point to what the first node currently points to

		if (isEmpty()) throw new StackUnderflowException("Attempt to pop empty stack");
		else top = top.getLink();
	}

	public T top() throws StackUnderflowException {
		// (1) If stack is NOT empty, returns the object from the top of the
		// (2) stack. If stack IS empty, throws StackUnderflowException

		if (isEmpty()) throw new StackUnderflowException("Attempted top() on empty stack");
		else return top.getInfo();
	}

	public boolean isEmpty() {
		return (top == null);
	}
	
}
