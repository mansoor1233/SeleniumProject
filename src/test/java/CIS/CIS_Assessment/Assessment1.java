package CIS.CIS_Assessment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment1 {

	WebDriver driver = null;
	pf ass;
	File file;
	Properties p;

	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ass = new pf(driver);
		driver.manage().window().maximize();
		file = new File(
				"C:\\Users\\Tammina User\\eclipse-workspace\\Prop\\Aug16\\24AUG\\CIS_Assessment\\Config\\Data.properties");
		FileInputStream fis = new FileInputStream(file);
		p = new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		ass.loginPf(p.getProperty("username"), p.getProperty("password"));
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void ClickSelfSurvey() throws InterruptedException {
		ass = new pf(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ass.selfsurvey_btn.click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void ClickCCIAssessments() throws InterruptedException {
		ass = new pf(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		ass.cci_btn.click();
		Thread.sleep(4000);
		ass.start_btn.click();
		String numtext = ass.num_btn.getText();
		System.out.println(numtext);
		int count = Integer.parseInt(numtext);
		for (int i = 0; i <= count; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			ass.ans_btn.click();
			Thread.sleep(2000);
		}

	}

	@Test(priority = 4)
	public void clickcareerButton() {
		ass.career_btn.click();
	}

}
