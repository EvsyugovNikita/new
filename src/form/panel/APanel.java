package form.panel;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.JTextField;

public abstract class APanel extends JApplet{
	public final double TARIF_HOT_WATER = 141.44;
	public final double TARIF_COLD_WATER = 22.21;
	public final double TARIF_HEATING = 37.47;
	public final double TARIF_GAS_FLAT = 6.50;
	public final double TARIF_ELECTRYCITY = 2.74;
	public final double TARIF_GAS_HOUS = 4994.02;
	
	double hot_water = 0;
	double cold_water = 0;
	double heating = 0;
	double gas_flat = 0;
	double electrycity = 0;
	double gas_hous= 0;
	
	int area = 0;
	double totals = 0;
	
	public JPanel panel;
	private JTextField Textfield_Area;
	private JTextField textField_HotWater;
	private JTextField textField_ColdWater;
	private JTextField textField_Electricity;
	private JTextField textField_Gas;
	private JTextField textField_Total;
	
	public APanel() {
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(10, 195, 89, 23);
		panel.add(ExitButton);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.setBounds(10, 173, 89, 23);
		panel.add(CalculateButton);
		
		JLabel lblType = new JLabel("Type of accommodation:");
		lblType.setBounds(10, 11, 118, 14);
		panel.add(lblType);
		
		JRadioButton ApartmentRadioButton = new JRadioButton("Apartment");
		ApartmentRadioButton.setSelected(true);
		ApartmentRadioButton.setBounds(6, 25, 109, 23);
		panel.add(ApartmentRadioButton);
		
		JRadioButton HouseRadioButton = new JRadioButton("House");
		HouseRadioButton.setBounds(6, 43, 109, 23);
		panel.add(HouseRadioButton);
		
		JLabel lblArea = new JLabel("Area =");
		lblArea.setBounds(149, 11, 39, 14);
		panel.add(lblArea);
		
		Textfield_Area = new JTextField();
		Textfield_Area.setBounds(185, 8, 86, 20);
		panel.add(Textfield_Area);
		Textfield_Area.setColumns(10);
		
		JLabel lblHotWater = new JLabel("Hot water (Cub.m)");
		lblHotWater.setBounds(10, 73, 98, 14);
		panel.add(lblHotWater);
		
		JLabel lblColdWater = new JLabel("Cold water (Cub.m)");
		lblColdWater.setBounds(10, 98, 98, 14);
		panel.add(lblColdWater);
		
		JLabel lblElectricity = new JLabel("Electricity (Cub.m)");
		lblElectricity.setBounds(10, 123, 98, 14);
		panel.add(lblElectricity);
		
		JLabel lblGas = new JLabel("Gas (Cub.m)");
		lblGas.setBounds(10, 148, 98, 14);
		panel.add(lblGas);
		
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
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(146, 177, 30, 14);
		panel.add(lblTotal);
		
		textField_Total = new JTextField();
		textField_Total.setColumns(10);
		textField_Total.setBounds(119, 196, 86, 20);
		panel.add(textField_Total);
	}	

	abstract void Calc();
}
