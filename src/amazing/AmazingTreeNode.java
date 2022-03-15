package src.amazing;

import java.lang.Cloneable;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Simple domain object representing a list of employees. Mostly here to be used for the
 * 'employees' {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Jason deMello
 */
public class AmazingTreeNode<T> implements Cloneable {

	// This variable is checked before printing debug statements.
	//
	// TRUE => Print debug statements
	// FALSE => Do not print debug statements
	private static Boolean debug = true;

	// The height level of the current node in the tree.
        int height = new int(0);

	// String representation of the node to insert into the tree. This string is given at
	// insertion and is assumed to be unique from other nodes' names.
        String id = new Sring("");

	// This node's root, at level 0, for all nodes in the tree.
        AmazingTreeNode<T> root = new AmazingTreeNode<>();

	// The parent of this node.
        AmazingTreeNode<T> parent = new AmazingTreeNode<>();

	// This node's list of children.
	LinkedList<AmazingTreeNode<T>> children = new LinkedList<>();

    	/**
	 * Copy constructor. INPUT: Source Node
	 * @param src The source node from which to copy primitive types.
	 *
	 * ASSUMPTION: It is assumed that <code>src</code> is already allocated and filled in, and that there
	 *             is no need or expectation of copying the complex types from <code>src</code> to
	 *             <code>this</code>.
	 */
	<T> AmazingTreeNode(AmazingTreeNode<T> src) {
	    this.height = src.height;
	    this.id = src.id;
	}

        /*
	 * This method returns a shallow copy of this AmazingTreeNode instance. (The elements themselves
	 * are not copied.)
	 */
        @Override
        protected Object clone() throws CloneNotSupportedException {
	    // Perform the shallow copy.
	    AmazingTreeNode<T> dst = (AmazingTreeNode<T>)super.clone();

	    // Prep for use by creating new objects within the destination clone.
	    dst.root = new AmazingTreeNode<>();
	    dst.parent = new AmazingTreeNode<>();
	    dst.children = new LinkedList<>();
	    
	    return dst;
	}

        /*
	 * This method returns a deep copy of this AmazingTreeNode instance. (The elements themselves
	 * are copied.)
	 *
	 * @param src The node from which the deep copy is performed.
	 */
        protected Object copy(AmazingTreeNode<T> src) throws CloneNotSupportedException {
	    // Perform the shallow copy.
	    AmazingTreeNode<T> dst = (AmazingTreeNode<T>)this.clone();

	    // Prep for use by creating new objects within the destination clone.
	    dst.root = new AmazingTreeNode<>();
	    dst.parent = new AmazingTreeNode<>();
	    dst.children = new LinkedList<>();
	    
	    return dst;
	}
}
