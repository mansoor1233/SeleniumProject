package Webtable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datawebtable {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		// Login--------
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");

		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//div[@class='modal-header']//button")).click();

		// Sales----

		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

		// Total Number of Pages in the table

		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();

		System.out.println(text); // Showing 1 to 10 of 174 (18 Pages)

		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		System.out.println("Total Number of pages : " + total_pages);

		// To find out how many rows are exist in each page

		for (int p = 1; p <= total_pages; p++) {

			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));

			System.out.println("Active page:" + active_page.getText());
			active_page.click();
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;

			jse.executeScript("scroll(0, 250)");  
			
			Thread.sleep(2000);
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();

			System.out.println("Number of rows:" + rows);

			String Pageno = Integer.toString(p + 1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + Pageno + "']")).click();
			
		}

	}

}
