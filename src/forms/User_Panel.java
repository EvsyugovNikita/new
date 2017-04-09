package forms;

/**
 * Импортируем библиотеки, необходимые для функционирования класса.
 */

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Импортируем методы других классов, необходимые для функционирования класса.
 */

import form.panel.Main_Panel;
import forms.Authorization_Panel;

/**
 * Создаем класс-потомок, который будет выполнять расчет для жителя;
 * он наследуется от класса-родителя, в котором содержится общий для двух калькуляторов функционал.
 */
public class User_Panel extends Main_Panel{

	/**
	 * Создаем конструктор класса, то есть описание созданных на основе него объектов.
	 */
	public User_Panel() {
		getContentPane().add(panel, "User");
		/**
		 * Добавляем текстовые поля для ввода жителем показателей счетчиков коммунальных услуг;
		 * используем для этого переопределенный в данном классе метод класса-родителя.
		 */
		textfields_add(user_textfields_number,user_textfields_name, user_textfields_size, panel);
		/**
		 * Обрабатываем нажатие на кнопку расчета;
		 * обращаемся к кнопке по индексу и переопределяем метод обработки нажатия на данную кнопку;
		 * вызываем метод расчета квартплаты для жителя.
		 */
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calc();	
			}
		});
		/**
		 * Обрабатываем нажатие на кнопку выхода;
		 * обращаемся к кнопке по индексу и переопределяем метод обработки нажатия на данную кнопку;
		 * открываем стартовую панель авторизации.
		 */
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
	/**
	 * Переопределяем абстрактный метод класса-родителя, то есть создаем конкретный метод
	 * расчета квартплаты для жителя.
	 */
	@Override
	public void Calc() {
		/**
		 * Заносим введенные показатели счетчиков коммунальных услуг в соответсвующие переменные.
		 */
		area = Double.valueOf(user_textfields[0].getText());
		hot_water = Double.valueOf(user_textfields[1].getText());
		cold_water = Double.valueOf(user_textfields[2].getText());
		electricity =  Double.valueOf(user_textfields[3].getText());
		gas =  Double.valueOf(user_textfields[4].getText());
		
		/**
		 * Расчет коммунальных услуг для жителя производится в зависимости от выбранного типа жилья и 
		 * в соответствии с установленными тарифами.
		 */
		if (radiobuttons[0].isSelected()){
			totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_FLAT + electricity*TARIF_ELECTRICITY; 
			/**
			 * Округляем стоимость коммунальных услуг до сотых (до копеек).
			 */
			totals = Math.rint(100.0*totals)/100.0;
		}else if (radiobuttons[1].isSelected()){
			totals = hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_HOUSE + electricity*TARIF_ELECTRICITY;  
			totals = Math.rint(100.0*totals)/100.0;
		}
		/**
		 * Выводим стоимость коммунальных услуг в отдельное текстовое поле.
		 */
		user_textfields[5].setText(String.valueOf(totals));
		
	}
	
}
