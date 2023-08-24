Feature: login and logout 
Background: 
 Given user should be on login page 
 When user passed credential as "utanekishor@gmail.com" and "Test@123" 
  Then user click on login button 
  
  Scenario: verify addproduct into the cart 
  Given user Should be at product page
  When user click on add to cart 
  And user should on cart icon 
  Then user should see the product into the my cart
  
  
  
 Scenario: sign out verify
Given user should on product page 
When user click on signout button 
Then user exit from that page 
