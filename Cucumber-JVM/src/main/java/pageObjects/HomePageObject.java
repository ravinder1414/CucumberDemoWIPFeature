package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    WebDriver driver;

    public HomePageObject (WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
	//Home tab
	  @FindBy(how=How.XPATH, using= ".//td[text()='Home']")
	  public WebElement tabHome;
	  
	//Admissions Tab
	  @FindBy(how=How.XPATH, using= ".//td[text()='Admissions']")
	  public WebElement tabAdmissions;
	  
	  //Admission Manager link
	  
	  @FindBy(how=How.LINK_TEXT, using= "Admissions Manager")
	  public WebElement lnkAdmissionManager;
	  
	//Link Add New Lead/Referral
	  @FindBy(how=How.XPATH, using= ".//*[@id='tabnavi_TabRow']/td[20]/a/img")
	  public WebElement lnkAddNewLeadReferral;
	  
	  //Info Call Radio Button
	  
	  @FindBy(how=How.XPATH, using= ".//*[@id='CtlApplyForm1_RadCheck_0']")
	  public WebElement rbnInfoCall;
	  
	  //Referral Radio Button
	  
	  @FindBy(how=How.XPATH, using= ".//*[@id='CtlApplyForm1_RadCheck_1']")
	  public WebElement rbnReferral;
	  
	  //Live Chat Radio Button
	  
	  @FindBy(how=How.XPATH, using= ".//*[@id='CtlApplyForm1_RadCheck_2']")
	  public WebElement rbnLiveChat;
	  
	  //Radio Warm Transfer
	  
	  @FindBy(how=How.XPATH, using= ".//*[@id='CtlApplyForm1_RadCheck_3']")
	  public WebElement rbnWarmTransfer;
	  
	  //First Name text field
	  
	  @FindBy(how=How.ID, using= "CtlApplyForm1_XMLRFname")
	  public WebElement txtFirstName;
	  
      //Last Name text field
	  
	  @FindBy(how=How.ID, using= "CtlApplyForm1_XMLRLname")
	  public WebElement txtLastName;
	  
	  //Email Required Field
	  
	  @FindBy(how=How.ID, using= "CtlApplyForm1_XMLREmail")
	  public WebElement txtEmail;
	  

      //Home Phone  Text Field
      

	  @FindBy(how=How.ID, using= "CtlApplyForm1_XMLNHPhone")
	  public WebElement txtHomePhone;
	  
	  
	  //Day Time Phone Text Field
	  
	  @FindBy(how=How.ID, using= "CtlApplyForm1_XMLRWPhone")
	  public WebElement txtDayTimePhone;
      
      
//City Text Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLNCity")
public WebElement txtCity;
  
//State Text Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLNState")
public WebElement txtState;
   
   
//ZIP Code Text Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLRZip")
public WebElement txtZIPCode;
 
   
//Country Text Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLNCountry")
public WebElement dropDownCountry;
  
  
//TCPA Disclosure Radio Button Yes

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLRTCPA_Disc_0")
public WebElement rbtnTCPA_Yes;
  
 
   
//TCPA Disclosure Radio Button No
   
@FindBy(how=How.ID, using= "CtlApplyForm1_XMLRTCPA_Disc_1")
public WebElement rbtnTCPA_No;
      	
  
//Spouse Military Radio Button Yes
   
@FindBy(how=How.ID, using= "CtlApplyForm1_XMLRMilitary_0")
public WebElement rbtnMilitary_Yes;
      	
 
//Spouse Military Radio Button No

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLRMilitary_1")
public WebElement rbtnMilitary_No;
   

//Highest Education Text Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLNHighestEducation")
public WebElement dropDownHighestEducation;
   
//Drop Down Military Type Field

@FindBy(how=How.ID, using= "CtlApplyForm1_XMLNMilitary2")
public WebElement DropDownMilitaryType;
   
  // Button Add New Lead

	   @FindBy(how=How.ID, using= "CtlApplyForm1_btnAddLead")
	   public WebElement btnAddLead;
	   
	   @FindBy(linkText = "New User")
	    WebElement newUserLink;
	   
	   //Link text in first table
	   
	   @FindBy(how=How.XPATH, using="//tr[2]/td[4]/a")
		
	    public WebElement lnkFirstLeadInTable;
	   
	   
	   //Error message
	   @FindBy(how=How.XPATH, using=".//*[@id='CtlApplyForm1_lblErrorMessage']")
		
	    public WebElement txtErrorMessage;

}
