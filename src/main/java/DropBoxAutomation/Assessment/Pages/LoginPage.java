package DropBoxAutomation.Assessment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
* This class is for operations that user performs in Login Page of Application
* @version 1.0
* @author Sravan
*/

public class LoginPage {
	
	 
	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(css="input[id^='login_email']")

    WebElement emailid;

    

    @FindBy(css="input[id^='login_password']")

    WebElement password;

    

    @FindBy(xpath="//div[contains(@class,'signin-text')]")

    WebElement signin;

      

    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    //Set Emaild id in Email Textbox

    public void setEmailid(String strEmailId){

    	emailid.sendKeys(strEmailId);    

    }  

    //Set password in password textbox

    public void setPassword(String strPassword){

    password.sendKeys(strPassword);

    }

    //Click on login button

    public void clickSignin(){

    	signin.click();

    }
	
	
	
}
	