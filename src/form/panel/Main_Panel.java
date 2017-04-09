package form.panel;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JTextField;

public abstract class Main_Panel extends JApplet{
	
	
	public final double TARIF_HOT_WATER = 141.44;
	public final double TARIF_COLD_WATER = 22.21;
	public final double TARIF_HEATING = 37.47;
	public final double TARIF_GAS_FLAT = 6.50;
	public final double TARIF_ELECTRICITY = 2.74;
	public final double TARIF_GAS_HOUSE = 4994.02;
	
	public double hot_water = 0;
	public double cold_water = 0;
	public double gas = 0;
	public double electricity = 0;
	public double house_cleaning = 0;
	public double house_lightning = 0;
	public double street_cleaning = 0;
	public double house_repairing = 0;
	
	public double area = 0;
	public double totals = 0;
	
	protected JPanel panel;
	
	public int buttons_number = 2;
	public JButton[] buttons = new JButton[buttons_number];
	public String buttons_name[] = {"ExitButton", "CalculateButton"};
	public String buttons_text[] = {"Exit","Calculate"};
	public int buttons_size[]={10, 195, 89, 23,10, 173, 89, 23};
	
	public int radiobuttons_number = 2;
	public JRadioButton[] radiobuttons = new JRadioButton[radiobuttons_number];
	public String radiobuttons_name[]={"ApartmentRadioButton","HouseRadioButton"};
	public String radiobuttons_text[]={"Flat", "House"};
	public int radiobuttons_size[]={6, 25, 60, 23,  6, 43, 60, 23};
	
	public int user_textfields_number=6;
	public JTextField[] user_textfields = new JTextField[user_textfields_number];
	public String user_textfields_name[]={"textField_Area","textField_HotWater","textField_ColdWater","textField_Electricity",
			"textField_Gas","textField_Total"};
	public int user_textfields_size[]={155, 25, 86, 20,  168, 67, 86, 20,  168, 92, 86, 20,  168, 117, 86, 20,  
			168, 142, 86, 20,  119, 196, 86, 20};	
	
	public int accountant_textfields_number = 10;
	public JTextField[] accountant_textfields = new JTextField[accountant_textfields_number];
	public String accountant_textfields_name[]={"textField_Area","textField_HotWater","textField_ColdWater","textField_Electricity",
			"textField_Gas","textField_Total","Textfield_Cleaning","Textfield_lightning","Textfield_street_cleaning",
			"Textfield_repairing"};
	public int accountant_textfields_size[]={155, 25, 86, 20,  168, 67, 86, 20,  168, 92, 86, 20,  168, 117, 86, 20,  
			168, 142, 86, 20,  119, 196, 86, 20,
			400, 67, 86, 20, 400, 92, 86, 20,  400, 117, 86, 20,  400, 142, 86, 20};
	
	public int labels_number=7;
	public JLabel[] labels = new JLabel[labels_number];
	public String labels_text[]={"Type of accommodation:",  "Total:", "Flat area=","Hot water (Cub.m)", "Cold water (Cub.m)",
			"Electricity (Kw-hr)", "Gas (Cub.m/1000 Cub.m.)"};
	public int labels_size[]={10, 11, 150, 14,  146, 177, 50, 14,  95, 25, 109, 23,  10, 73, 105, 14,  10, 98, 105, 14,
			10, 123, 105, 14,  10, 148, 150, 14};
	
	public int accountant_labels_number = 4;
	public JLabel[] accountant_labels = new JLabel[accountant_labels_number];
	public String accountant_labels_text[]={"House cleaning","House lightning","Street cleaning",
			"House repairing"};
	public int accountant_labels_size[]={300, 67, 100, 20,  300, 92, 100, 20,  300, 117, 100, 20,  300, 142, 100, 20};
	
	public Main_Panel() {
		getContentPane().setLayout(new CardLayout());
		panel = new JPanel();
		panel.setLayout(null);
		
		buttons_add(buttons_name, buttons_text, buttons_size, panel);
		labels_add(labels_number, labels_text, labels_size, panel);
		radiobuttons_add(radiobuttons_name, radiobuttons_text, radiobuttons_size, panel);
		radiobuttons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (radiobuttons[0].isSelected()) {
					radiobuttons[1].setSelected(false);
				}
			}
		});
		radiobuttons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (radiobuttons[1].isSelected()) {
					radiobuttons[0].setSelected(false);
				}
			}
		});
	}
	public void radiobuttons_add (String radiobuttons_name[],String radiobuttons_text[], int radiobuttons_size[],JPanel panel){
		for (int i=0; i<radiobuttons_number; i++){
			radiobuttons[i]=new JRadioButton();
			radiobuttons[i].setText(radiobuttons_text[i]);
			radiobuttons[i].setName(radiobuttons_name[i]);
			radiobuttons[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			radiobuttons[i].setBounds(radiobuttons_size[i*4],radiobuttons_size[i*4+1],radiobuttons_size[i*4+2],radiobuttons_size[i*4+3]);
			panel.add(radiobuttons[i]);			
		}
	}
	public void textfields_add (int user_textfields_number,String user_textfields_name[],int user_textfields_size[],JPanel panel){
		for (int i=0; i<user_textfields_number; i++){
			user_textfields[i]=new JTextField();
			user_textfields[i].setText("0");
			user_textfields[i].setName(user_textfields_name[i]);
			user_textfields[i].setBounds(user_textfields_size[i*4],user_textfields_size[i*4+1],user_textfields_size[i*4+2],user_textfields_size[i*4+3]);
			panel.add(user_textfields[i]);			
		}
	}
	
	public void labels_add (int labels_number, String labels_text[],int labels_size[],JPanel panel){
		for (int i=0; i<labels_number; i++){
			labels[i]=new JLabel();
			labels[i].setText(labels_text[i]);
			labels[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			labels[i].setBounds(labels_size[i*4],labels_size[i*4+1],labels_size[i*4+2],labels_size[i*4+3]);
			panel.add(labels[i]);	
		}
	}
	public void buttons_add (String buttons_name[],String buttons_text[],int buttons_size[],JPanel panel){
		for (int i=0; i<buttons_number; i++){
			buttons[i]=new JButton();
			buttons[i].setName(buttons_name[i]);
			buttons[i].setText(buttons_text[i]);
			buttons[i].setBounds(buttons_size[i*4], buttons_size[i*4+1], buttons_size[i*4+2], buttons_size[i*4+3]);
			buttons[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			panel.add(buttons[i]);
		}
	}
	abstract public void Calc();
}
