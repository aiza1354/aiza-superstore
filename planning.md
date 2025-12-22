**Planning**
* Classes
  * Shopper class: 
    * This will be a class controlled by the user. 
    * The user will be assigned a few attributes of 2  shoppers with starkly different backgrounds. 
    * For e.g:
      * String Name
      * String Gender 
      * int Age
      * String Income Bracket (Low/Medium/High) 
      * boolean Financially Struggling (True/False)
      * Throughout the 10 days, the user will make decision based on what they think is most appropriate. 
  * Items Class
    * Each day, on the shelves there will be 2 types of items. A necessity VS a luxury.
      * For e.g: 
        * An unknown addictive substance (Necessity)
        * Bread (Necessity)
        * Steak (Luxury)
          * These will only have the attributes: 
            * String nameOfItem
            * boolean __ (Necessity VS Luxury) 
            * Double price 
  * Manager Class
    * This class will be computer controlled. 
    * And will decide after a day of purchase whether to increase/decrease or keep the price of an item unchanged depending on its demand and supply. 
    * He will also decide how much stock to order.
      * The manager class will have only 2 attributes: 
        * String Name 
        * int Age 
          * These are not necessary, however,  we *need* attributes for a class. 
  * FindingsArray/Queue Class
    * This class will store the relative PED and PES of each item. 
    * It will also store the history of prices in the LinkedList with the day of the price change in one List, all together. 
    * In addition, it will show what the decision of the manager was in changing th price of the item. 
  * DailyPurchasing Class
    * It will have the attributes: 
      * int day 
      * String nameOfItem
      * double priceAtDay 
      * int quantitySold
  * Main Class
    * In our main we will have a range of different methods. 
      * Introduction()
        * This will introduce the store etc. 
        * It will show the different people who are assigned to you. \
      * changePrice()
        * This will change the price as needed. 
      * nextDay()
        * This will change the day from for e.g day 1 to day 2. 
        * It will implement a change in price if needed. 
      * calculatePED() 
        * This class will calculate the PED in relation to the change in demand (if there is any). 
      * calculatePES() 
        * This class will calculate the PES in relation to the change in supply. 
      * showFindings() 
        * This method will gather the data that has been put into the ___ Array and explain how price changes have affected the PED of the product as well as the PES. 
      * exportFindings() 
        * This method will convert what we know into a text file and show our findings. 
  * Overview: What my objective is: 
    * I want to prove the price elasticity of demand
    * And if possible, the price elasticity of supply.
    * I will use: 
      * Data structures - Queues/LinkedList, ArrayList etc. 
      * OOPs (completely)
      * Local/DateTime
      * File I/O (input/output)
      * Maths package for calculations
      * UML Diagram
      * Exception Handling
      * Data Validation