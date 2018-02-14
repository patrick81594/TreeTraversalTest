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
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("unused")
public class Testt {

	public static double result = 0;
	private JFrame frame;
	static JTextField inputTxt;
	static Object stackArray[];
	static String input;
	public static JTextArea textArea = new JTextArea();
	treeCreation tc = new treeCreation();
	static JTextArea statusLabel = new JTextArea("Status: ");
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
		frame.setBounds(100, 100, 429, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[61px][1px][97px][238px,grow]", "[33px][9px][6px][31px][23px][6px][26px][23px][21px][30px][grow][6px][23px]"));
		statusLabel.setEditable(false);
		frame.getContentPane().add(statusLabel, "cell 3 9,grow");
		

		
		inputTxt = new JTextField();
		inputTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				inputTxt.setText("");
			}
		});
		inputTxt.setText("Enter an Expression");
		frame.getContentPane().add(inputTxt, "cell 0 9 3 1,growx,aligny center");
		inputTxt.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 3 0 1 9,grow");
		panel.setLayout(null);
		textArea.setEditable(false);
		
		
		textArea.setBounds(0, 0, 235, 179);
		panel.add(textArea);
		
		JLabel preOutLabel = new JLabel("");
		frame.getContentPane().add(preOutLabel, "cell 2 0,grow");
		
		JLabel InOutLabel = new JLabel("");
		frame.getContentPane().add(InOutLabel, "cell 2 4,grow");
		
		JLabel postOutLabel = new JLabel("");
		frame.getContentPane().add(postOutLabel, "cell 2 7,grow");

		JTextArea resultLabel = new JTextArea("Result: " + result);
		resultLabel.setEditable(false);
		frame.getContentPane().add(resultLabel, "cell 3 12,growx,aligny center");
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				treeCreation.clearSB();
				input = Work.takeInput();
				statusLabel.setText("Status: " + checkString.treatString(input));
				String[] pieces = input.split("\\s+");				
				Object[] toTree = postFix.toPostfix(pieces);
				treeCreation.Node root = treeCreation.constructTree(toTree);
				
				InOutLabel.setText(treeCreation.printInorder(root));
		        System.out.println();
				preOutLabel.setText(treeCreation.printPreorder(root));
				postOutLabel.setText(treeCreation.printPostorder(root));
				treeCreation.PrintTree(root, 0);
				Work.calculation(root);
				resultLabel.setText("Result: " + result);




			}
		});
		frame.getContentPane().add(btnNewButton, "cell 0 12 3 1,alignx center,aligny top");
		
		JLabel prefixLabel = new JLabel("Prefix:");
		frame.getContentPane().add(prefixLabel, "cell 0 0,alignx center,aligny bottom");
		
		JLabel InfixLabel = new JLabel("Infix:");
		frame.getContentPane().add(InfixLabel, "cell 0 4,alignx center,growy");
		
		JLabel postfixLabel = new JLabel("Postfix: ");
		frame.getContentPane().add(postfixLabel, "cell 0 7,alignx right,growy");
		
		JSeparator separator_1 = new JSeparator();
		frame.getContentPane().add(separator_1, "cell 2 5,grow");
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, "cell 2 2,grow");
		
		JSeparator separator_2 = new JSeparator();
		frame.getContentPane().add(separator_2, "cell 2 8,growx,aligny top");
		



	

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
