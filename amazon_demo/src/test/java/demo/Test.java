package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test extends Input{

	public static void main(String[] args) {
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			// Open Amazon.in
            driver.get("https://www.amazon.in");
            
            System.out.println("Link Launched >>>> Loading....");
            
            //Calling method
            Product.productsPrint();
			
		} catch (Exception e) {
			
			System.err.println("Code Caught Exception");
			e.printStackTrace();
			
		} finally {
			
			driver.quit();
			System.out.println("\nCompleted Successfully");
		}

	}

}
