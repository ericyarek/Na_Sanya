package com.prestashop.step_definitions;

import java.util.Locale;
import java.util.Map;

import com.prestashop.beans.User;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

/*
 * This class needs to e in same package as step defenitions
 * 
 */

public class DataTableConfigurer implements TypeRegistryConfigurer{

  @Override
  public Locale locale() {
    return Locale.ENGLISH;
  }

  public void configureTypeRegistry(TypeRegistry typeRegistry) {

    typeRegistry.defineDataTableType(new DataTableType(User.class,

        new TableEntryTransformer<User>() {

          @Override
          public User transform(Map<String, String> row) throws Throwable {
        	  //these keys must match the data table in the feature file .
            String firstName = row.get("First Name");
            String lastName = row.get("Last Name");
            String address = row.get("Address");
            String city = row.get("City");
            String company = row.get("Company");
            return new User(firstName, lastName, address, company, city);
          }
        }));

  }
  
//	typeRegistry.defineDataTableType(new DataTableType(
//  User.class,
//  (Map<String, String> row) -> new User(
//      row.get("name"),
//      Price.fromString(row.get("price"))
//  )
//));

}