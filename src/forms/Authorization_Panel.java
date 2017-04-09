package forms;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import forms.Accountant_Panel;
import forms.User_Panel;

public class Authorization_Panel extends JApplet{
	private User_Panel uf;
	private Accountant_Panel af;
	private JPasswordField pass;
	private JTextField JTextField_Login;
	private JPanel panel;
	
	public int auth_labels_number = 4;
	public JLabel[] auth_labels = new JLabel[auth_labels_number];
	public String auth_labels_text[]={"Authorization","Login","Password",""};
	public int auth_labels_size[]={170, 39, 230, 42,  111, 113, 55, 24,  111, 151, 55, 24, 111, 240, 223, 24};	
	
	public Authorization_Panel(){
		getContentPane().setLayout(new CardLayout());
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, "Auth");
		
		auth_labels_add(auth_labels_number, auth_labels_text, auth_labels_size, panel);
		
		JTextField_Login = new JTextField();
		JTextField_Login.setColumns(10);
		JTextField_Login.setBounds(180, 113, 94, 20);
		panel.add(JTextField_Login);
		
		pass = new JPasswordField();
		pass.setBounds(180, 151, 94, 20);
		panel.add(pass);

		JButton JButton_Enter = new JButton("Enter");
		JButton_Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				if(auth(JTextField_Login.getText(), pass.getText()) == 1){
					uf = new User_Panel();
					getContentPane().add(uf, "User");
					cl.show(getContentPane(), "User");
				}else if(auth(JTextField_Login.getText(), pass.getText()) == 2){
					af = new Accountant_Panel();
					getContentPane().add(af, "Accountant");
					cl.show(getContentPane(), "Accountant");
				}else if(auth(JTextField_Login.getText(), pass.getText()) == 0){
					auth_labels[3].setText("Wrong login or password!");
				}
			}
		});
		JButton_Enter.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		JButton_Enter.setBounds(180, 198, 94, 31);
		panel.add(JButton_Enter);
	}
	private int access;
	public int auth(String login, String pass){
		if(login.equals("Person") && pass.equals("123")){
			access = 1;
			return access;
		}else if(login.equals("Admin") && pass.equals("123")){
			access = 2;
			return access;
		}else{
		access = 0;
		}
		return access;
	}
	
	public void auth_labels_add (int auth_labels_number, String auth_labels_text[],int auth_labels_size[],JPanel panel){
		for (int i=0; i<auth_labels_number; i++){
			auth_labels[i]=new JLabel();
			auth_labels[i].setText(auth_labels_text[i]);
			auth_labels[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			auth_labels[i].setBounds(auth_labels_size[i*4],auth_labels_size[i*4+1],auth_labels_size[i*4+2],auth_labels_size[i*4+3]);
			panel.add(auth_labels[i]);	
		}
	}

}
