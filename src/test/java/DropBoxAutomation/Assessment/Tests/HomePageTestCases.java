package DropBoxAutomation.Assessment.Tests;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DropBoxAutomation.Assessment.Pages.HomePage;
import DropBoxAutomation.Assessment.Pages.LoginPage;


/**
* This class creates the test cases for Home Page of the application
* @version 1.0
* @author Sravan
*/
public class HomePageTestCases {
	
	LoginPage loginPage;
	HomePage homePage;
	WebDriver driver;
	
	
	//Test method for Creating the folder in Application test case
	@Test(priority=2)
	@Parameters({ "folderName" })
	public void createFolderTest(String folderName)  {	
	
		driver=Driver.DriverSetup();
		homePage=new HomePage(driver);
		homePage.clickFiles();
		homePage.createNewFolder(folderName);
	
	}
	
	
	//Test method for uploading the files test case
	@Test(priority=3)
	@Parameters({ "fileName" })
	public void uploadFileTest(String fileName)  {	
	
		driver=Driver.DriverSetup();
		homePage=new HomePage(driver);
		homePage.clickMyFiles();
		homePage.uploadFile(fileName);
	
	}
	
	
	//Test method with least priority for logout test case
	@Test(priority=99)
	public void logout() {	
	
		driver=Driver.DriverSetup();
		homePage=new HomePage(driver);
		homePage.clickAccountPhoto();
		homePage.clickSignOut();
	
	}
	

}
