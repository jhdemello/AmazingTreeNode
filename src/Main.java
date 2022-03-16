import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
	static AmazingTreeNode<Atom> atoms = new AmazingTreeNode<>();

	public static void main(String args[])
		throws CloneNotSupportedException
	{
	    List<Atom> atomList = new ArrayList<>();
		atomList.add(new Atom("John Galt", "John Galt"));
		atomList.add(new Atom("Ragnar Danneskjold", "John Galt"));
		atomList.add(new Atom("Dagny Taggart", "John Galt"));
		atomList.add(new Atom("Francisco d\'Anconia", "John Galt"));
		atomList.add(new Atom("Hank Reardon", "Ragnar Danneskjold"));
		atomList.add(new Atom("Eddie Willers", "Ragnar Danneskjold"));
		atomList.add(new Atom("Ken Dannager", "Ragnar Danneskjold"));
		atomList.add(new Atom("James Taggart", "Dagny Taggart"));
		atomList.add(new Atom("Lillie Reardon", "Francisco d\'Anconia"));
		atomList.add(new Atom("Robert Stadler", "Francisco d\'Anconia"));
		atomList.add(new Atom("Cherryl Brooks", "Francisco d\'Anconia"));

		System.out.print("\n=======================================================");
		System.out.println("======================================================");
		System.out.println("== Building tree from list");
		System.out.println("== ");
		IntStream.range(0, atomList.size()).forEachOrdered(i -> {
			atomList.get(i).printAtom();
			String strParent = atomList.get(i).mgr;
			String strEmployee = atomList.get(i).emp;
			if (strEmployee.equalsIgnoreCase(strParent)) {
				atoms = new AmazingTreeNode<Atom>(strParent);
			}
			else {
				AmazingTreeNode<Atom> atom = atoms.get(strParent);
				atom.insert(strEmployee);
			}
		});
		System.out.println("== ");

		atoms.printTree();

		// MOVE TESTING
		String JG = "John Galt";
		String DT = "Dagny Taggart";
		String JT = "James Taggart";
		String RD = "Ragnar Danneskjold";
		String KD = "Ken Dannager";
		String RS = "Robert Stadler";
		String FD = "Francisco d\'Anconia";

		// MOVE: Promote James Taggart to VP
		atoms.move(JT, DT, JG);
		atoms.printTree();

		// MOVE: Demote Ragnar from VP to Office Admin (promoting all of Ragnar's direct
		// reports to VP!?)
		atoms.move(RD, JG, DT);
		atoms.printTree();

		// MOVE: Build up Dagny's team a bit. Move Ken from John to Dagny
		atoms.move(KD, JG, DT);
		atoms.printTree();

		// MOVE: Move Jim to Ken (this should add a 4th level to the tree)
		atoms.move(RS, FD, KD);
		atoms.printTree();

		// Dagny found a new opportunity, we've found an AMAZING new candidate with a bit more
		// moxy.
		AmazingTreeNode<Atom> atom = atoms.get(DT);
		atom.printTree();
		atom.get(DT).id = "Bugs Bunny";
		atoms.printTree();
	}
}
