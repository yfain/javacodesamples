// A generic Box. When use, specify the type of items to be stored there
public class Box<T> {

	private T t;
	
	public void add (T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
}
