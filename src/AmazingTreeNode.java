import java.util.LinkedList;
import java.util.stream.IntStream;

// An object reference of this class is
// contained by AmazingTreeNode<T>
class Node<T> {
	int x, y;
	public void printNode() {
	    System.out.print(x + " / " + y);
	}
}

// Contains a reference of Node and implements
// clone with deep copy.
public class AmazingTreeNode<T> implements Cloneable {
	int a, b;

	LinkedList<Node<T>> c = new LinkedList<>();

	public void printTree() {
	    System.out.print(a + " / " + b);
	    IntStream.range(0, c.size()).forEachOrdered(i -> {
		    System.out.print(" / ");
		    c.get(i).printNode();
		});
	    System.out.println();
	}
	
	public Object clone() throws CloneNotSupportedException {
		// Assign the shallow copy to new reference variable t
		AmazingTreeNode<T> t = (AmazingTreeNode<T>)super.clone();
		t.c = new LinkedList<>();

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}

        /*
	 * This method returns a deep copy of this AmazingTreeNode instance. (The elements themselves
	 * are copied.)
	 *
	 * @param src The node from which the deep copy is performed.
	 * @param dst The node into which the deep copy goes.
	 */
         public Object copy(AmazingTreeNode<T> src) throws CloneNotSupportedException {
	    AmazingTreeNode<T> dst = (AmazingTreeNode<T>)src.clone();
	    IntStream.range(0, src.c.size()).forEachOrdered(i -> {
		    dst.c.add(src.c.get(i));
		});
	    return dst;
	}
}
