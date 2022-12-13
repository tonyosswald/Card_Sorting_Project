
public class LLNode<T> {
	//LLNode class FROM NOTES, it creates nodes, with getters and setters for modifying
	
	protected T info;
	protected LLNode link;

	public LLNode(T info) {
		this.info = info;
		link = null;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}
	
	public void setLink(LLNode<T> link) {
		this.link = link;
	}

	public LLNode<T> getLink() {
		return link;
	}
}
