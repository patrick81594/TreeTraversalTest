import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Stack;

public class Testt {

	private JFrame frame;
	static JTextField inputTxt;
	static Object stackArray[];
	static String input;
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
		statusLabel.setBounds(194, 200, 238, 50);
		frame.getContentPane().add(statusLabel);
		

		
		inputTxt = new JTextField();
		inputTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				inputTxt.setText("");
			}
		});
		inputTxt.setText("Enter an Expression");
		inputTxt.setBounds(10, 196, 159, 20);
		frame.getContentPane().add(inputTxt);
		inputTxt.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(194, 11, 238, 178);
		frame.getContentPane().add(panel);
		
		JLabel preOutLabel = new JLabel("");
		preOutLabel.setBounds(72, 30, 97, 23);
		frame.getContentPane().add(preOutLabel);
		
		JLabel InOutLabel = new JLabel("");
		InOutLabel.setBounds(72, 90, 97, 23);
		frame.getContentPane().add(InOutLabel);
		
		JLabel postOutLabel = new JLabel("");
		postOutLabel.setBounds(72, 145, 97, 23);
		frame.getContentPane().add(postOutLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = Work.takeInput();

				statusLabel.setText("Status: " + checkString.treatString(input));
				stackArray = Work.Order(input);
				treeCreation.Node root = tc.constructTree(stackArray, Work.countOpp(input));
				InOutLabel.setText(treeCreation.inorder(root));
		        System.out.println();
				preOutLabel.setText(treeCreation.preOrder(root));
			}
		});
		btnNewButton.setBounds(45, 227, 89, 23);
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

	}
}
