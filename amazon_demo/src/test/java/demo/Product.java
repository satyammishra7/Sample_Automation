package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product extends Test {

	public static void productsPrint() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			System.out.println("Loaded Amazon successfully");

			// Search for "lg soundbar"
			WebElement searchElement = driver.findElement(searchText);
			searchElement.sendKeys("lg soundbar");

			System.out.println("Searching text......");
			searchElement.submit();

			System.out.println("Searched lg soundbar");

			// Waiting for search results
			wait.until(ExpectedConditions.visibilityOfElementLocated(waitForPage));

			// Store product in map
			Map<String, Integer> products = new HashMap<>();

			// Finding the product elements
			List<WebElement> items = driver.findElements(itemsInPage);

			System.out.println("\nSearching for Items....\nItems Found = " + items.size() + "\n\nFetching all the products........\n");

			int counter = 1;

			for (WebElement item : items) {

				String productName = "";
				int productPrice = 0;

				try {

					System.out.print(counter++ + ") ");

					// Getting product name
					WebElement titleElement = item.findElement(title);
					productName = titleElement.getText();

					System.out.println("Product Name = " + productName);

					// Getting price
					WebElement priceElement = item.findElement(price);

					String priceText = priceElement.getText().replace(",", "");
					productPrice = Integer.parseInt(priceText);

					System.out.println("    Price = " + productPrice);

					// Add to map
					products.put(productName, productPrice);

				} catch (Exception e) {

					// Handled exceptions (e.g., price not found) and continue
					products.put(productName, productPrice);
					System.out.println("    Price Not Found, So assuming price = 0");
					continue;

				}
			}

			// Sorting products by price
			List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(products.entrySet());
			sortedProducts.sort(Map.Entry.comparingByValue());

			System.out.println("\nOutput\n\nSorted Products\n");

			for (Map.Entry<String, Integer> entry : sortedProducts) {
				String productName1 = entry.getKey();
				int productPrice1 = entry.getValue();

				// Printed sorted products
				System.out.println(productPrice1 + " " + productName1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
