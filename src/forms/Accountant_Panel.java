package forms;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import form.panel.Main_Panel;

public class Accountant_Panel extends Main_Panel{
	
	public int accountant_labels_number = 4;
	public JLabel[] accountant_labels = new JLabel[accountant_labels_number];
	public String accountant_labels_text[]={"House cleaning","House lightning","Street cleaning",
			"House repairing"};
	public int accountant_labels_size[]={300, 67, 100, 20,  300, 92, 100, 20,  300, 117, 100, 20,  300, 142, 100, 20};	
	
public Accountant_Panel(){
	getContentPane().add(panel, "Accountant");
	textfields_add(accountant_textfields_number, accountant_textfields_name, accountant_textfields_size, panel);
	labels_add(accountant_labels_number, accountant_labels_text, accountant_labels_size, panel);
	buttons[1].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calc();
		}
	});
	buttons[0].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout) getContentPane().getLayout();
			Authorization_Panel af = new Authorization_Panel();
			getContentPane().add(af, "Auth");
			cl.show(getContentPane(), "Auth");
		}
	});
}

@Override
	public void Calc() 
	{
	area = Double.valueOf(accountant_textfields[0].getText());
	hot_water = Double.valueOf(accountant_textfields[1].getText());
	cold_water = Double.valueOf(accountant_textfields[2].getText());
	electricity =  Double.valueOf(accountant_textfields[3].getText());
	gas =  Double.valueOf(accountant_textfields[4].getText());
	house_cleaning = Double.valueOf(accountant_textfields[6].getText());
	house_lightning =Double.valueOf(accountant_textfields[7].getText());
	street_cleaning = Double.valueOf(accountant_textfields[8].getText());
	house_repairing = Double.valueOf(accountant_textfields[9].getText());
	
	if (radiobuttons[0].isSelected()){
		totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
    			gas*TARIF_GAS_FLAT + electricity*TARIF_ELECTRICITY + house_cleaning + house_lightning +
    			street_cleaning + house_repairing; 
		totals = Math.rint(100.0*totals)/100.0;
	}else if (radiobuttons[1].isSelected()){
		totals = hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
    			gas*TARIF_GAS_HOUSE + electricity*TARIF_ELECTRICITY + house_cleaning + house_lightning +
    			street_cleaning + house_repairing; 
		totals = Math.rint(100.0*totals)/100.0;
	}
	accountant_textfields[5].setText(String.valueOf(totals));	
	}

@Override
public void textfields_add (int accountant_textfields_number,String accountant_textfields_name[],int accountant_textfields_size[],JPanel panel){
	for (int i=0; i<accountant_textfields_number; i++){
		accountant_textfields[i]=new JTextField();
		accountant_textfields[i].setText("0");
		accountant_textfields[i].setName(accountant_textfields_name[i]);
		accountant_textfields[i].setBounds(accountant_textfields_size[i*4],accountant_textfields_size[i*4+1],
				accountant_textfields_size[i*4+2],accountant_textfields_size[i*4+3]);
		panel.add(accountant_textfields[i]);			
	}
}
}
	


