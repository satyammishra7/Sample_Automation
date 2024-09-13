package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	protected static By searchText = By.id("twotabsearchtextbox");
	protected static By waitForPage = By.cssSelector(".s-main-slot");
	protected static By itemsInPage = By.xpath("//div[contains(@class,'puis-list-col-right')]/div[@class='puisg-col-inner'][1]");
	protected static By title = By.cssSelector("h2 a span");
	protected static By price = By.cssSelector(".a-price-whole"); 
	

}
