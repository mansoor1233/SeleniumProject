package CIS.CIS_Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf {

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username_txt;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password_txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_btn;

	@FindBy(xpath = "//*[@id='navbarNavAltMarkup']/div/a[.=' Self-Surveys']")
	WebElement selfsurvey_btn;

	@FindBy(xpath = "//*[@id=\"main-body\"]//a[2]/div[2]/p")
	WebElement cci_btn;

	@FindBy(xpath = "//app-cci-jr-intro/div/div[1]/div/div[2]/div[4]/button[@aria-label='Start']")
	WebElement start_btn;

	@FindBy(xpath = "//app-cci-jr-assessment/div[@class='assessment-questions']/div[1]/div/div[1]/div[1]/div[3]/span")
	WebElement num_btn;

	@FindBy(xpath = "//app-cci-jr-assessment/div[@class='assessment-questions']/div[1]/div/div/div[4]/div/button/p")
	WebElement ans_btn;

	@FindBy(xpath = "//app-cci-jr-result/div/div[1]/div[3]/div/div[1]/a/div/span/u")
	WebElement career_btn;

	WebDriver driver = null;

	public pf(WebDriver driver) {
		this.driver = driver;
		//pf.initElements(driver,this);
		 PageFactory.initElements(driver, this);

	}

	public void loginPf(String username, String password) {
		username_txt.sendKeys(username);
		password_txt.sendKeys(password);
		submit_btn.click();
	}

}
