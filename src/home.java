

public class home {
static String input;
	public static void main(String[] args) {
		treeCreation tc = new treeCreation();
		input = Work.takeInput();
		input = Work.Order(input);
		char[] inCharArray = input.toCharArray();
		System.out.print(input + "checks out");
		treeCreation.Node root = tc.treeCreation.constructTree(inCharArray);
		System.out.print(treeCreation.inorder(root));
	}

}
