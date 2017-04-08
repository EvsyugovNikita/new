package form;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import form.panel.APanel;

public class User_Panel extends APanel{
	
	public User_Panel() {
		CalculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Calc();
				
			}
		});
	}

	@Override
	public void Calc() {
		area = Integer.valueOf(textField_Area.getText());
		hot_water = Double.valueOf(textField_HotWater.getText());
		cold_water = Double.valueOf(textField_ColdWater.getText());
		electrycity =  Double.valueOf(textField_Electricity.getText());
		gas =  Double.valueOf(textField_Gas.getText());
		
		if (ApartmentRadioButton.isSelected()){
			totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_FLAT + electrycity*TARIF_ELECTRYCITY; 
			totals = Math.rint(100.0*totals)/100.0;
		}else if (HouseRadioButton.isSelected()){
			totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_HOUS + electrycity*TARIF_ELECTRYCITY;  
			totals = Math.rint(100.0*totals)/100.0;
		}
		textField_Total.setText(String.valueOf(totals));
		
	}
}
