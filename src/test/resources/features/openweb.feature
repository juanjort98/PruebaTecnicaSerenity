#author: Juan Jose Ramirez Torres
#language: en


  Feature: Open a web page


    Background:
      Given "Juan" opens the testing web page

    @successful
    Scenario: Add a product from a specific category to the shopping cart
      Given Juan selects a category in the navigation bar
      When Adds a product from the selected category to the shopping cart
      And  Goes back to the product selection view to add a new product
      Then Should see the added product's name in the shopping cart view


