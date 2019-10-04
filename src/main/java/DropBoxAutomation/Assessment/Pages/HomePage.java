package DropBoxAutomation.Assessment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
* This class is for operations that user performs in Home Page of Application
* @version 1.1
* @author Sravan
*/


public class HomePage {
	
	private WebDriver driver;
	
	/**

     * All WebElements are identified by @FindBy annotation

     */
	
	@FindBy(xpath="//img[@class='mc-avatar-image']")

    private WebElement accountPhoto;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")

    private WebElement signOut;
	
	
	@FindBy(xpath="//a[@id='files']")

    private WebElement files;
	
	
	@FindBy(xpath="//a[@class='maestro-nav__feature maestro-nav__active-feature']")
	
    private WebElement myFiles;
	
	
	@FindBy(xpath="//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-folder']")

    private WebElement newFolder;
	
	
	@FindBy(xpath="//input[@id='new_folder_name_input']")

    private WebElement folderName;
	
	
	@FindBy(xpath="//button[@class='button-primary dbmodal-button']")

    private WebElement folderCreate;
	
	
	@FindBy(xpath="//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-upload-file']")

    private WebElement uploadFiles;
	
	
	@FindBy(xpath="//p[@class='mc-snackbar-title']")

    private WebElement fileUploadVerifyMessage;
	
	
	@FindBy(xpath="//span[@id='notify-msg']")

    private WebElement folderCreateVerifyMessage;
	
	
	
	 public HomePage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 
	//This method is to click on  Files hyper link in Home Page
	public void clickFiles() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(files));
		 
		 files.click(); 
	}
	
	//Method to click on My Files hyper link in the home page
	public void clickMyFiles() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(myFiles));
		 
		 myFiles.click();	 
		 
	}
	
	//Method to Create New folder in the home page of the application 
	public void createNewFolder(String strFolderName) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(newFolder));
			 newFolder.click();
			 wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(folderName));
			 folderName.sendKeys(strFolderName);
			 folderCreate.click();
			 
			 //This make WebDriver to wait until the folder creation completes
			 wait.until(ExpectedConditions.textToBePresentInElement(folderCreateVerifyMessage, "Created folder"));
			 String message=folderCreateVerifyMessage.getText();
			 Assert.assertTrue(message.contains("Created"),"File Upload Success");
		}
		catch(Exception e) {
			Assert.fail("Folder Creation not successful");
			e.printStackTrace();
		}
		 
	}
	
	//Method to upload file in the home page of the application , File name passed as parameter from testng.xml file
	public void uploadFile(String strFileName) {		
		
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(uploadFiles));
		 uploadFiles.click();
		 try{
			 //File name passed as Command Line Argument for AutoIt tool
			 Process process=Runtime.getRuntime().exec("D:\\Automation\\Assessment\\FileUploadTool.exe \\"+strFileName);
			 
			 //This step to make WebDriver to wait until System Process to upload file completes
			 process.waitFor();
			 
			 //This make WebDriver to wait until the Upload completes
			 wait.until(ExpectedConditions.textToBePresentInElement(fileUploadVerifyMessage, "Uploaded"));
			 String message=fileUploadVerifyMessage.getText();
			 Assert.assertTrue(message.contains("Uploaded"),"File Upload Success");
		 }
		 catch(Exception e) {
			 Assert.fail("File not uploaded successfully");
			 e.printStackTrace();
		 }
		 
		 
	}
	 
	 //This method clicks on Account profile picture, this is needed mainly to sign out 
	 public void clickAccountPhoto(){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(accountPhoto));
		 accountPhoto.click();

	    }
	 
	 //Method to click on sign out sub menu that displays once Account profile picture is clicked
	 public void clickSignOut(){

	    	signOut.click();
	    	driver.quit();

	    }
	 
	 //Method to Verify if the Login to Dropbox is Successful
	 public void assertLogin() {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(accountPhoto));
		 Assert.assertTrue(accountPhoto.isDisplayed(), "Login is Successful");
	 }

}
