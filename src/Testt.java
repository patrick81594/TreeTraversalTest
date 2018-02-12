import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.GridLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Stack;
import javax.swing.JTextArea;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JTree;

@SuppressWarnings("unused")
public class Testt {

	public static double result = 0;
	private JFrame frame;
	static JTextField inputTxt;
	static Object stackArray[];
	static String input;
	static JTextPane textPane = new JTextPane();
	static JTextArea textArea = new JTextArea();
	treeCreation tc = new treeCreation();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testt window = new Testt();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Testt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 458, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel statusLabel = new JLabel("Status: ");

		statusLabel.setBounds(194, 191, 238, 30);
		frame.getContentPane().add(statusLabel);
		

		
		inputTxt = new JTextField();
		inputTxt.setBounds(10, 196, 159, 20);
		inputTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				inputTxt.setText("");
			}
		});
		inputTxt.setText("Enter an Expression");
		frame.getContentPane().add(inputTxt);
		inputTxt.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(194, 11, 238, 178);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		textArea.setBounds(10, 5, 218, 162);
		panel.add(textArea);
		
		JTree tree = new JTree();
		tree.setBounds(10, 5, 218, 162);
		panel.add(tree);
		
		JLabel preOutLabel = new JLabel("");
		preOutLabel.setBounds(72, 30, 97, 23);
		frame.getContentPane().add(preOutLabel);
		
		JLabel InOutLabel = new JLabel("");
		InOutLabel.setBounds(72, 90, 97, 23);
		frame.getContentPane().add(InOutLabel);
		
		JLabel postOutLabel = new JLabel("");
		postOutLabel.setBounds(72, 145, 97, 23);
		frame.getContentPane().add(postOutLabel);
		
		JLabel resultLabel = new JLabel("Result: " + result);
		resultLabel.setBounds(194, 215, 238, 30);
		frame.getContentPane().add(resultLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(45, 227, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				treeCreation.clearSB();
				input = Work.takeInput();
				String[] pieces = input.split("\\s+");				
				Object[] toTree = postFix.toPostfix(pieces);
				treeCreation.Node root = treeCreation.constructTree(toTree);
				statusLabel.setText("Status: " + checkString.treatString(input));
				InOutLabel.setText(treeCreation.printInorder(root));
		        System.out.println();
				preOutLabel.setText(treeCreation.printPreorder(root));
				postOutLabel.setText(treeCreation.printPostorder(root));
				treeCreation.PrintTree(root, 0);
				Work.calculation(root);
				resultLabel.setText("Result: " + result);




			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel prefixLabel = new JLabel("Prefix:");
		prefixLabel.setBounds(31, 30, 40, 23);
		frame.getContentPane().add(prefixLabel);
		
		JLabel InfixLabel = new JLabel("Infix:");
		InfixLabel.setBounds(31, 90, 32, 23);
		frame.getContentPane().add(InfixLabel);
		
		JLabel postfixLabel = new JLabel("Postfix: ");
		postfixLabel.setBounds(31, 145, 40, 23);
		frame.getContentPane().add(postfixLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(72, 113, 97, 6);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(72, 53, 97, 6);
		frame.getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(72, 168, 97, 6);
		frame.getContentPane().add(separator_2);
		


		textPane.setBounds(255, 184, 6, 20);

		frame.getContentPane().add(textPane);


	

	}

	protected String reverse(String printInorder) {
		
		StringBuilder sb = new StringBuilder();
		String in = printInorder;
		System.out.println("before: " + in);
		char revArr[] = in.toCharArray();
		int length = revArr.length;
		System.out.println("length" + revArr.length);
		for(int i = (length-1); i >= 0 ; i--){
			sb.append(revArr[i]);
		}
		in = sb.toString();
		System.out.println("after: " + in);
		return in;
	}
}
