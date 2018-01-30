

public class home {
static String input;
	public static void main(String[] args) {
		treeCreation tc = new treeCreation();
		input = Work.takeInput();
		input = Work.Order(input);
		char[] inCharArray = input.toCharArray();
		System.out.print(input + "checks out");
		treeCreation.Node root = tc.constructTree(inCharArray);
		treeCreation.inorder(root);
	}

}
