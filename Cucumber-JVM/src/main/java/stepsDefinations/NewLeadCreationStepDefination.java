package stepsDefinations;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePageObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewLeadCreationStepDefination {
	public String mainwinhandle;

    WebDriver driver;
    String url;
    String baseUrl;
    HomePageObject homePageObject;
    //NewUserPageObject newUserPageObject;
    //ConfirmUserPageObject confirmUserPageObject;
   
    
  //Static variable
  	String sRandStr = RandomStringUtils.randomAlphabetic(5);
  	public String sFirstName = "TestNGFNInfoCall_" + sRandStr;
  	public String sLastName = "TestNGLNInfoCall_" + sRandStr;			
  	public String sEmailAddress = sFirstName + "IC@kap.com";
  	public String sAddressLine1 = "kaplan";
  	public String sCity = "NewYork";
  	public String sDayTimePhone ="9545151234";
  	public String sZipCode = "30256";
  	public String sTCPA ="Yes";
  	public String windowName="";
  	public String sSpouseMilitary ="Yes";
  	
  	public String windowName_mainwindow="";
  	public String windowName_AddNewLead="script";
    
 

    @Before
    public void beforeScenario() {
        driver=new FirefoxDriver();
        url = "http://10.78.58.44/Orion.aspx?r=http://10.78.58.44/Default.aspx";
        driver.manage().window().maximize();
        
    }
	
	@Given("^I am on Orion CLS Home page$")
	public void i_am_on_Orion_CLS_Home_page() throws Throwable {
		
	driver.get(url);
	
		try {
			Runtime.getRuntime().exec("C:\\Login.exe");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
			}
	}
	
	@When("^I click on Admission Link$")
	public void i_click_on_Admission_Link() throws Throwable {
		homePageObject = new HomePageObject(driver);
        driver.switchTo().frame("Orion");
        homePageObject.tabHome.click();
        
        homePageObject.tabAdmissions.click();
        driver.manage().window().maximize();
	    
	}

	@When("^I click on Admission Manager and Add New Lead/Referral Link$")
	public void i_click_on_Admission_Manager_and_Add_New_Lead_Referral_Link() throws
	 Throwable {
		mainwinhandle = driver.getWindowHandle();
		homePageObject.lnkAdmissionManager.click();
		homePageObject.lnkAddNewLeadReferral.click();
		driver.switchTo().window(windowName_AddNewLead);
		homePageObject.rbnReferral.click();
	}

	@When("^I fill all the required details for New Referral$")
	public void i_fill_all_the_required_details_for_New_Referral() throws Throwable {
		
		
		homePageObject.txtFirstName.sendKeys(sFirstName);
		homePageObject.txtLastName.sendKeys(sLastName);
		homePageObject.txtEmail.sendKeys(sEmailAddress);
		
		homePageObject.txtDayTimePhone.sendKeys(sDayTimePhone);
		
		homePageObject.txtZIPCode.sendKeys(sZipCode);
		
//TCPA Disclosure
if(sTCPA.equalsIgnoreCase("yes"))
{
	homePageObject.rbtnTCPA_Yes.click();				
}
else
{
	homePageObject.rbtnTCPA_No.click();
}

//Spouse Military Status
if(sSpouseMilitary.equalsIgnoreCase("yes"))
{
	homePageObject.rbtnMilitary_Yes.click();					
}
else
{
	homePageObject.rbtnMilitary_No.click();
}

Select ddHighestEducation = new Select(homePageObject.dropDownHighestEducation);

ddHighestEducation.selectByIndex(1);


//Drop Down Military Types

Select ddMilitaryType = new Select(homePageObject.DropDownMilitaryType);
ddMilitaryType.selectByIndex(1);

//Click on Add New Lead Button

homePageObject.btnAddLead.click();

driver.switchTo().window(mainwinhandle);

	    
	}

	@Then("^I should be able to see the created new Lead$")
	public void i_should_be_able_to_see_the_created_new_Lead() throws Throwable {
		homePageObject = new HomePageObject(driver);
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.switchTo().frame("Orion");
		homePageObject.tabAdmissions.click();
		homePageObject.lnkAdmissionManager.click();
		Assert.assertEquals(homePageObject.lnkFirstLeadInTable.getText().trim(), sLastName + ", " + sFirstName);
	}

	@When("^I fill invalid details for New Referral$")
	public void i_fill_invalid_details_for_New_Referral() throws Throwable {
		homePageObject.txtFirstName.sendKeys(sFirstName);
		homePageObject.txtLastName.sendKeys(sLastName);
		homePageObject.txtEmail.sendKeys(sEmailAddress);
		
		homePageObject.txtDayTimePhone.sendKeys(sDayTimePhone);
		
		//homePageObject.txtZIPCode.sendKeys(sZipCode);
		homePageObject.btnAddLead.click();
		System.out.println(homePageObject.txtErrorMessage.getText());
	    
	}

	@Then("^I should be able to see error message$")
	public void i_should_be_able_to_see_error_message() throws Throwable {
		Assert.assertEquals(homePageObject.txtErrorMessage.getText(),"Please enter a valid zip.\nPlease select a valid tcpa disclosure.\nPlease fill out all fields and make sure they are in the proper format.");
	    
	}
	

        @After
        public void afterScenario(Scenario scenario) {
            if (scenario.isFailed()) {
            	driver.manage().window().setSize(new Dimension(1024, 768));
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),"image/png");
            }
            driver.close();
            driver.quit();
		
	}
}
	
        
        
        