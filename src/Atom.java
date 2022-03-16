// An object reference of this class is
// contained by AmazingTreeNode<T>
class Atom {
    String emp;
    String mgr;

    Atom (String e, String m) {
	emp = e;
	mgr = m;
    }
    
    public void printAtom() {
 	System.out.println("== MGR " + mgr + " / EMP " + emp);
    }
}
