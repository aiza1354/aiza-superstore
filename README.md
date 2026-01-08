**Aiza Superstore**
* Classes
    * `Person` Class:
      * This will inherit the Shopper and Manager class and prove them will the following attributes: 
        * String `name`
          int `age`
          String `gender`
    * `Shopper` class: 
      * This class will contain attributes for different Shoppers.
      * It is going to be the child class of Person. (Person will inherit Shopper, and shopper will therefore share some attributes). 
      * It is also connected to `CartItem` via composition. 
      * The user will be assigned a few attributes of 3 shoppers with different backgrounds. 
      * For e.g:
        * (private) boolean `isLowIncome`
        * Instead of making sensitive information public, this attribute will only be available through a getter. 
        * Shopper and CartItem are connected through composition.
        * There is a method called `addToCart` which uses an ArrayList of CartItem (s) to add different products to the shoppers cart. 
        * There is also a method called `calculateTotal` which calculates the total price of a shopper's cart. 
        * During the 10 days, the project will simulate what these shoppers by depending on their income, their and how elastic or inelastic they feel towards certain items. 
    * `Manager` Class
      * This class carries most of the methods. 
      * A method called addProductToShelf uses the Type `Product` and add it to the ArrayList of `shelf`.
      * addProductHistory uses the type ProductDetails' and add it the ArrayList of `productHistory`.
      * calculatePED loops through `productHistory` and find the PED of each product by comparing the %change in price and %change in quantity sold.
      * displayShelf loops through `shelf` and display the products.
      * implementAdjustedPrice loops through `shelf` and changes the new-found price from `autoPriceAdjuster`.
      * getLatestProductDetails loops through `productHistory` and returns the most recent details of any product.
      * findElasticity uses double `PED` to find the elasticity of a product.
      * autoPriceAdjuster uses the `elasticity` of a product to change its price to maximise revenue. 
        * For example, if bread is inelastic, people will buy it no matter what, even if the price increases.
    * `Product` Class
      * Product is connected to `Manager` via aggregation. 
      * It contains the attributes:
        * String `name` 
        * boolean `isNecessity` = true
        * double `price`
        * double `currentPED` 
        * String `currentElasticity` = "Unknown"
          * As these attributes are private, there are getters and setters for other classes to gain access to them. 
      * Each day, on the shelves there will be 3 types of items. A necessity, a luxury and an addictive substance which comes under necessity (as those who are addicted must buy it).
      * For e.g: 
        * An addictive substance (Necessity)
        * Bread (Necessity)
        * Steak (Luxury)
    * `ProductDetails` Class
      * This class is associated with Product. 
      * It is connected with `Manager` via aggregation. 
      * It contains the attributes: 
        * private int `productId`
          private int `day`
          private int `quantitySold`
          private double `priceAtTime`
          * As these attributes are private, there are getters for other classes to gain access to them.
    * `CartItem` Class
      * Associated with Product.
        * It will have the attributes: 
          * Product `product`
          * int `quantityBought`
    * `Main Class`
      * This is where we make our 3 products (bread, steak and addictiveSubstance)
      * We create the ArrayLists of shelf, shoppersToday, productHistory 
      * It calls all the different methods.
    * Overview: 
      * *This project proves the price elasticity of demand as depending on the elasticity of products, raising/decreasing its price allows greater revenue for my superStore.*
      * I have used
        * Data structures - ArrayList 
        * OOPs (inheritance, aggregation, composition, polymorphism)
        * Maths package for calculations
        * (created) a UML Diagram
        * Exception Handling
        * Iteration 
        * Data Validation