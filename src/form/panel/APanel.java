package form.panel;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JTextField;

public abstract class APanel extends JApplet{
	public final double TARIF_HOT_WATER = 141.44;
	public final double TARIF_COLD_WATER = 22.21;
	public final double TARIF_HEATING = 37.47;
	public final double TARIF_GAS_FLAT = 6.50;
	public final double TARIF_ELECTRYCITY = 2.74;
	public final double TARIF_GAS_HOUS = 4994.02;
	
	public double hot_water = 0;
	public double cold_water = 0;
	public double gas = 0;
	public double electrycity = 0;
	
	public int area = 0;
	public double totals = 0;
	
	private JPanel panel;
	public JTextField textField_Area;
	public JTextField textField_HotWater;
	public JTextField textField_ColdWater;
	public JTextField textField_Electricity;
	public JTextField textField_Gas;
	public JTextField textField_Total;
	public JRadioButton ApartmentRadioButton;
	public JRadioButton HouseRadioButton;
	public JButton ExitButton;
	public JButton CalculateButton;
	
	public APanel() {
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		
		ExitButton = new JButton("Exit");
		ExitButton.setBounds(10, 195, 89, 23);
		panel.add(ExitButton);
		
		CalculateButton = new JButton("Calculate");
		CalculateButton.setBounds(10, 173, 89, 23);
		panel.add(CalculateButton);
		
		JLabel lblType = new JLabel("Type of accommodation:");
		lblType.setBounds(10, 11, 129, 14);
		panel.add(lblType);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(146, 177, 42, 14);
		panel.add(lblTotal);
		
		ApartmentRadioButton = new JRadioButton("Apartment\r\n");
		ApartmentRadioButton.setSelected(true);
		ApartmentRadioButton.setBounds(6, 25, 109, 23);
		panel.add(ApartmentRadioButton);
		
		HouseRadioButton = new JRadioButton("House");
		HouseRadioButton.setBounds(6, 43, 109, 23);
		panel.add(HouseRadioButton);
		
		JLabel lblArea = new JLabel("Area =");
		lblArea.setBounds(149, 11, 39, 14);
		panel.add(lblArea);
		
		JLabel lblHotWater = new JLabel("Hot water (Cub.m)");
		lblHotWater.setBounds(10, 73, 105, 14);
		panel.add(lblHotWater);
		
		JLabel lblColdWater = new JLabel("Cold water (Cub.m)");
		lblColdWater.setBounds(10, 98, 105, 14);
		panel.add(lblColdWater);
		
		JLabel lblElectricity = new JLabel("Electricity (Cub.m)");
		lblElectricity.setBounds(10, 123, 105, 14);
		panel.add(lblElectricity);
		
		JLabel lblGas = new JLabel("Gas (Cub.m)");
		lblGas.setBounds(10, 148, 105, 14);
		panel.add(lblGas);
		
		textField_Area = new JTextField();
		textField_Area.setBounds(185, 8, 86, 20);
		panel.add(textField_Area);
		textField_Area.setColumns(10);
		
		textField_HotWater = new JTextField();
		textField_HotWater.setBounds(118, 67, 86, 20);
		panel.add(textField_HotWater);
		textField_HotWater.setColumns(10);
		
		textField_ColdWater = new JTextField();
		textField_ColdWater.setColumns(10);
		textField_ColdWater.setBounds(118, 92, 86, 20);
		panel.add(textField_ColdWater);
		
		textField_Electricity = new JTextField();
		textField_Electricity.setColumns(10);
		textField_Electricity.setBounds(118, 117, 86, 20);
		panel.add(textField_Electricity);
		
		textField_Gas = new JTextField();
		textField_Gas.setColumns(10);
		textField_Gas.setBounds(118, 142, 86, 20);
		panel.add(textField_Gas);
		
		textField_Total = new JTextField();
		textField_Total.setColumns(10);
		textField_Total.setBounds(119, 196, 86, 20);
		panel.add(textField_Total);
	}	

	abstract public void Calc();
}
