package com.prestashop.step_definitions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class ProductInformationValidationsStepDefs {
	ItemPage itemPage = new ItemPage();
	HomePage homePage = new HomePage();
	
	@Then("the user should be able to see {string}")
	public void the_user_should_be_able_to_see(String productName) {
	    assertTrue(homePage.item( productName ).isDisplayed());
	}
	
	@Then("the user should be able to see following products")
	public void the_user_should_be_able_to_see_following_products(List<String> products) {
		for (String product : products) {
			System.out.println(product);
			assertTrue(homePage.item(product).isDisplayed());
			
		}
	}
	
	@Then("the product be available in the following sizes")
	public void the_product_be_available_in_the_following_sizes(List<String> sizes) {
	   
		for(String size: sizes) {
			System.out.println(size);
			
		}
		Select sizeSelect = itemPage.size();
		// will contain the actual sizes
		List<String> actualList = new ArrayList<>();
		
		// get the all options from the dropdown
		// and add the text of the option to the acualList
		for (WebElement optionElement : sizeSelect.getOptions()) {
			actualList.add(optionElement.getText());
		}
		
		assertEquals(sizes, actualList);
	}
	
	
	
	@Then("the system should display the product information:")
	  public void the_system_should_display_the_product_information(Map<String, String> product) {
	    System.out.println(product);
	    
	    ItemPage itemPage = new ItemPage();
	    
	    String expectedName = product.get("name");
	    System.out.println("Product name: "+expectedName);
	    assertEquals(expectedName, itemPage.itemName.getText());
	    
	    String expectedPrice = product.get("price");
	    System.out.println("Product price: "+expectedPrice);
	    assertEquals(expectedPrice, itemPage.price.getText());
	    
	    String expectedSize = product.get("size");
	    System.out.println("Product size: "+expectedSize);
	    assertEquals(expectedSize, itemPage.size().getFirstSelectedOption().getText());
	    
	    String expectedCondition = product.get("condition");
	    System.out.println("Product condition: "+expectedCondition);
	    assertEquals(expectedCondition, itemPage.condition.getText());
	    
	    String expectedCount= product.get("count");
	    System.out.println("Product count: "+expectedCount);
	    assertEquals(expectedCount, itemPage.count.getAttribute("value"));
	    
	    
	  }

}
