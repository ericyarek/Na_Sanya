package com.prestashop.step_definitions;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SigninPage;
import com.prestashop.utilities.BrowserUtils;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginStepDefs {
	
	SigninPage signinPage = new SigninPage();
	String email;

	
	@Given("the user is on the login page")
	public void the_user_is_on_the_home_page() {
		//open website
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		new HomePage().signin.click();
	}
	
	@When("I login using username {string} and {string}")
	public void i_login_using_username_and(String username, String password) {
	    signinPage.loginEmail.sendKeys(username);
	    signinPage.password.sendKeys(password);
	    signinPage.submitLogin.click();
	}
		
	@Then("users full name {string} {string} should be displayed")
	public void users_full_name_should_be_displayed(String firstName, String lastName) {
	    String expected = firstName+" "+ lastName;
	    String actual = new MyAccountPage().fullName.getText();
	    assertEquals(expected,actual);
	    System.out.println("IM PASS BROO !");
	}
	
	@When("the user tries to register an ivalid email")
	public void the_user_tries_to_register_an_ivalid_email() {
		signinPage.signupEmail.sendKeys("uygurno1gmail.com");
		signinPage.signupEmail.submit();
	}

	@Then("the system should dispaly error message {string}")
	public void the_system_should_dispaly_error_message(String message) {
		  // signinPage.errorMessage is always present in the page, with or without any error
		 // but it only becomes visible when there is an actual error message
		 // calling an explicit wait utility method to wait for the visibility of the message
		BrowserUtils.waitForVisibility(signinPage.errorMessage, 5);
		// now that element is fully loaded, we can capture the text
	   String actual = signinPage.errorMessage.getText();
	   assertEquals(message, actual);
	}
	
	@When("the user tries to register blank email")
	public void the_user_tries_to_register_blank_email() {
		signinPage.signupEmail.sendKeys("");
		signinPage.signupEmail.submit();
		signinPage.signupEmail.submit();
	}
	
//	@When("the user tries to register existing email")
//	public void the_user_tries_to_register_existing_email() {
//	    signinPage.signupEmail.sendKeys("");
//	}

	
	@Given("there is an existing user")
	public void there_is_an_existing_user() {
		Faker fake = new Faker();
		new HomePage().signin.click();
        email = fake.name().username() + "@gmail.com";
        signinPage.signupEmail.sendKeys(email+Keys.ENTER);
        
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.firstName.sendKeys(fake.name().firstName());
        registrationPage.lastName.sendKeys(fake.name().lastName());
        registrationPage.password.sendKeys("password123");
        
        Address adress = fake.address();
        
        registrationPage.address.sendKeys(adress.buildingNumber() + " " + adress.streetName());
        registrationPage.city.sendKeys(adress.city());
   
        
//        Select states = registrationPage.stateList();
//        for (WebElement option : states.getOptions()) {
//        	String text = option.getText();
//        	System.out.println(text);
//		}
        
        BrowserUtils.waitFor(4);
        
        registrationPage.stateList().selectByValue("2");
        registrationPage.zipCode.sendKeys("22311");
        registrationPage.mobilePhone.sendKeys(fake.phoneNumber().cellPhone());
        registrationPage.register.click();
  
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.logout.click();
	}
	
	@When("the user tries to register the same email")
	public void the_user_tries_to_register_the_same_email() {
	    signinPage.signupEmail.sendKeys(email);
	    signinPage.signupEmail.submit();
	}
	
	@When("I enter invalid data on the page")
	//public void i_enter_invalid_data_on_the_page(DataTable dataTable) {
	public void i_enter_invalid_data_on_the_page(Map<String, String> dataTable) {
		//Initialize data table 
	/*	
		List<String> data = dataTable.asList();
		System.out.println(data);
		System.out.println(data.size());
		System.out.println(data.get(0));
		System.out.println(data.get(data.size()-1));
		System.out.println(data.indexOf("Password1"));
		signinPage.loginEmail.sendKeys(data.get(3));
		  signinPage.password.sendKeys(data.get(5));
		  signinPage.submitLogin.click();
	    */
		
		//===================================================
		/*
		List<List<String>> data = dataTable.cells();
		System.out.println("HELLO THERE "+ data.get(1).get(1));
	    System.out.println("HELLO THERE "+ data.get(2).get(1));
		
	      signinPage.loginEmail.sendKeys(data.get(1).get(1));
		  signinPage.password.sendKeys(data.get(2).get(1));
		  signinPage.submitLogin.click();
	    */

		
		//===================================================
//		List<Map<String, String>> data = dataTable.asMaps();
//		
//		System.out.println(data);
//		System.out.println(data.get(0).size());
//		System.out.println(data.get(0).values());
//		System.out.println(data.get(1).get("Values"));
//		
//		System.out.println(data.get(0).get("Values"));

		//===========================================
		System.out.println(dataTable);
		System.out.println(dataTable.get("Password"));
	      
		signinPage.loginEmail.sendKeys(dataTable.get("Email Address"));
		  signinPage.password.sendKeys(dataTable.get("Password"));
		  signinPage.submitLogin.click();

	}
	
	@Then("the system should dispaly error message signIn {string}")
	public void the_system_should_dispaly_error_message_signIn(String message) {
		  // signinPage.errorMessage is always present in the page, with or without any error
		 // but it only becomes visible when there is an actual error message
		 // calling an explicit wait utility method to wait for the visibility of the message
		BrowserUtils.waitForVisibility(signinPage.errorMessage_signIn, 5);
		// now that element is fully loaded, we can capture the text
	   String actual = signinPage.errorMessage_signIn.getText();
	   assertEquals(message, actual);
	}

}
