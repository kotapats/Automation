package DropBoxAutomation.Assessment.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DropBoxAutomation.Assessment.Pages.HomePage;
import DropBoxAutomation.Assessment.Pages.LoginPage;


/**
* The class creates the test cases for Login Page of the application
* @version 1.0
* @author Sravan
*/
public class LoginPageTestCases {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	
	//before test method to launch the application in web browser
	@BeforeTest
	public void LaunchDropbox() {	
	
	driver=Driver.DriverSetup();
   	driver.get("https://www.dropbox.com/login");
		
	}
	
	//Test Case for Login
	@Test(priority=1)
	@Parameters({ "emailid", "password" })
	public void loginTest(String emailId,String password) {
		
		
	loginPage=new LoginPage(driver);
	homePage=new HomePage(driver);
	loginPage.setEmailid(emailId);
	loginPage.setPassword(password);
	loginPage.clickSignin();
	homePage.assertLogin();
	
		
	}
	
	

}
