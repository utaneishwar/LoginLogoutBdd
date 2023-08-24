Feature: verify Add product without login
Background:Added Desktop
Given user should be on nop commerce
And user provide credential as "priyankadcruz@gmail.com" and "Test@123"
And user click on log in button 

Scenario: select any categories and add product 
Given user should be on nop commerce Homepage
And user click on computer categories
And user click on desktop
And user click on enterprizer add to cart desktop product
Then user seen build your own computer 
And user select Ram and HDD
And user click on Add to cart
And desktop Should Added into the shopping cart 

 