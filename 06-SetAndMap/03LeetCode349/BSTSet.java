import java.util.Comparator;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
	public BST<E> data;

	public BSTSet() {
		data = new BST<>();
	}

	@Override
	public int getSize() {
		return data.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public boolean contains(E e) {
		return data.contains(e);
	}
	
	@Override
	public void add(E e) {
		data.addElement(e);
	}
	
	@Override
	public void remove(E e) {
		data.removeElement(e);
	}
}
