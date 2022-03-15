import java.util.ArrayList;

public class Main {
	public static void main(String args[])
		throws CloneNotSupportedException
	{
		AmazingTreeNode<Integer> t1 = new AmazingTreeNode<>();
		t1.a = 10;
		t1.b = 20;

		Node<Integer> node1 = new Node<>();
		node1.x = 30;
		node1.y = 40;
		t1.c.add(node1);

		System.out.print("[T1.printTree()(T1 init):: ");
		t1.printTree();

		AmazingTreeNode<Integer> t3 = (AmazingTreeNode<Integer>)t1.clone();
		System.out.print("[T1.printTree()(T3.clone(T1)):: ");
		t1.printTree();

		t3.a = 100;

		System.out.print("[T1.printTree()(T3.a = 100)]:: ");
		t1.printTree();

		System.out.print("[T3.printTree()(T3.a = 100)]:: ");
		t3.printTree();

		node1.x = 300;
		node1.y = 400;

		System.out.println("(node1.x = 300, node1.y = 400) ----- ");
		System.out.print("[T1.printTree()]:: ");
		t1.printTree();
		System.out.print("[T3.printTree()](SANS node1):: ");
		t3.printTree();

		t3.c.add(node1);
		System.out.print("[T3.printTree()](ADDED node1):: ");
		t3.printTree();

		System.out.println("NEW NODE1(node1.x = 3000, node1.y = 4000) ----- ");
		node1 = new Node<>();
		node1.x = 3000;
		node1.y = 4000;

		System.out.print("[T1.printTree()](pre-Add):: ");
		t1.printTree();
		System.out.print("[T3.printTree()](pre-Add):: ");
		t3.printTree();

		t3.c.add(node1);

		System.out.print("[T1.printTree()](post-Add):: ");
		t1.printTree();
		System.out.print("[T3.printTree()](post-Add):: ");
		t3.printTree();

		AmazingTreeNode<Integer> t4 = new AmazingTreeNode<>();
		System.out.print("[T4.printTree()](T4 <- T3):: ");
		t4 = (AmazingTreeNode<Integer>)t3.copy(t3);
		t4.printTree();

		System.out.print("[T4.printTree()](post copy)T4 <- T3):: ");
		t3.c.get(0).x = 5555555;
		t4.printTree();
	}
}
