package form;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import form.panel.Main_Panel;

public class User_Panel extends Main_Panel{

	public User_Panel() {
		getContentPane().add(panel, "User");
		textfields_add(user_textfields_number,user_textfields_name, user_textfields_size, panel);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calc();	
			}
		});
	}
	@Override
	public void Calc() {
		area = Double.valueOf(user_textfields[0].getText());
		hot_water = Double.valueOf(user_textfields[1].getText());
		cold_water = Double.valueOf(user_textfields[2].getText());
		electricity =  Double.valueOf(user_textfields[3].getText());
		gas =  Double.valueOf(user_textfields[4].getText());
		
		if (radiobuttons[0].isSelected()){
			totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_FLAT + electricity*TARIF_ELECTRICITY; 
			totals = Math.rint(100.0*totals)/100.0;
		}else if (radiobuttons[1].isSelected()){
			totals = hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_HOUSE + electricity*TARIF_ELECTRICITY;  
			totals = Math.rint(100.0*totals)/100.0;
		}
		user_textfields[5].setText(String.valueOf(totals));
		
	}
	
}
