package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Testik1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Documents\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/ASUS/git/new/target/index.html");
	}

}
