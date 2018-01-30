import java.util.Scanner;


public class home {
static String input;
	public static void main(String[] args) {
		Work.TreeConstruct tc = new Work.TreeConstruct();
		input = Work.takeInput();
		input = Work.Order(input);
		char[] inCharArray = input.toCharArray();
		Work.TreeConstruct.Node root = tc.constructTree(inCharArray);
	}

}
