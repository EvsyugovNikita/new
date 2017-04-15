/**
 * Указываем, в каком пакете находится тест.
 */
package forms;
/**
 * Импортируем класс для проверки тестовой логики, 
 * проверки результатов расчета
 */
import static org.junit.Assert.*;
/**
 * Импортируем класс для тестирования
 */
import org.junit.*;
/**
 * Создаем класс для тестирования расчета квартплаты
 * для бухгалтера ЖКХ.
 */
public class Testing_Accountant_Paid {
	/**
	 * Инициализируем экземпляр класса бухгалтера
	 */
	public Accountant_Panel accountant_panel;
	/**
	 * Аннотация, указывающая на метод, который будет выполняться перед каждым
	 * запуском теста
	 */
	@Before
	/**
	 * Создаем метод, который будет выполняться перед каждым запуском теста;
	 * в нем устанавливаем входные параметры для тестирования.
	 */
	public void testinit() {
		/**
		 * Создаем новый экземпляр класса бухгалтера  
		 */
		accountant_panel = new Accountant_Panel();
		/**
		 * Присваиваем радиокнопке с индексом = [0] значение "истина" 
		 * (выбираем тип жилья: квартира)
		 */
		accountant_panel.radiobuttons[0].setSelected(true);
		/**
		 * Присваиваем текстовому полю с индексом = [0] значение 43.7 
		 * (площадь квартиры в кв.м.)
		 */
		accountant_panel.accountant_textfields[0].setText("43.7");
		/**
		 * Присваиваем текстовому полю с индексом = [1] значение 5 
		 * (расход горячей воды в куб.м.)
		 */
		accountant_panel.accountant_textfields[1].setText("5");
		/**
		 * Присваиваем текстовому полю с индексом = [2] значение 5 
		 * (расход холодной воды в куб.м.)
		 */
		accountant_panel.accountant_textfields[2].setText("5");
		/**
		 * Присваиваем текстовому полю с индексом = [3] значение 110 
		 * (расход электроэнергии в квт/ч)
		 */
		accountant_panel.accountant_textfields[3].setText("110");
		/**
		 * Присваиваем текстовому полю с индексом = [4] значение 8.5 
		 * (расход газа в куб.м.)
		 */
		accountant_panel.accountant_textfields[4].setText("8.5");
		/**
		 * Присваиваем текстовому полю с индексом = [6] значение 10 
		 * (уборка в подъезде в руб.)
		 */
		accountant_panel.accountant_textfields[6].setText("10");
		/**
		 * Присваиваем текстовому полю с индексом = [7] значение 10 
		 * (освещение в подъезде в руб.)
		 */
		accountant_panel.accountant_textfields[7].setText("10");
		/**
		 * Присваиваем текстовому полю с индексом = [8] значение 10 
		 * (уборка улиц в руб.)
		 */
		accountant_panel.accountant_textfields[8].setText("10");
		/**
		 * Присваиваем текстовому полю с индексом = [9] значение 10 
		 * (взнос за капитальный ремонт в руб.)
		 */
		accountant_panel.accountant_textfields[9].setText("10");
	}
	/**
	 * Аннотация, указывающая на то, что за ней следует тестируемый метод.
	 */
	@Test
	/**
	 * Объявляем метод, который будем тестировать, а именно
	 * расчет квартплаты для бухгалтера ЖКХ.
	 */
	public void test() {
		/**
		 * Производим расчет квартплаты для бухгалтера, путем нажатия
		 * на кнопку с индексом [1]
		 */
		accountant_panel.buttons[1].doClick();
		/**
		 * Присваиваем переменной значение верного результата расчета
		 * квартплаты для бухгалтера
		 */
		Double summary_expected = 2852.34;
		/**
		 * Присваиваем переменной значение текстового поля с индексом [5]
		 * (реально получившийся результат в ходе прохождения теста)
		 */
		Double summary_actual = Double.valueOf(accountant_panel.accountant_textfields[5].getText());
		/**
		 * Сравниваем значения верного (ожидаемого) результата 
		 * и реально получившегося результата;
		 * если результаты равны, тест проходит успешно.
		 */
		assertEquals(summary_expected,summary_actual);
	}
	/**
	 * Аннотация, указывающая на метод, который будет выполняться после каждого
	 * выполнения теста.
	 */
	@After
	/**
	 * Создаем метод, который будет выполняться после каждого выполнения теста
	 */
	public void teststop(){
		/**
		 * Делаем переменную, где раньше находился экзепляр класса бухгалтера,
		 * пустой и неинициализированной.
		 */
		accountant_panel = null;
	}
}