# BlazeDemo Test Project
Requirement - To test booking a flight from blaze demo site - https://blazedemo.com/
Solution - UI Automation using Java/Selenium/TestNG as Maven project
Approach - UI Automation is achieved using Page Object Model [POF] framework
  - For every page, corresponding page object class will be created
  - Locators of all the elements of that page will be stored on that page class using @FindBy and initialized using PageFactory
  - Actions perfomed on a particular page are achieved through methods created on that page (Ex: click on a button, enter some text etc..)
  - OOPs concept of inheritance is used wherein the base class (TestBase) contains common methods and is inherited by other page classes and test classes
  - A test package consists of all the required tests are created 
  - TestNG is used for annotations, execution and reporting
  - Created a test suite called 'FlightBooking.xml' and mapped to the test class to execute the tests.
  - All the required dependencies are declared in POM.xml
  - I have used a couple of design patters in this framework
    1. PageFactory Design pattern - Used in TestBase class - Which creates the driver instance depending on the browser passed 
    2. Facade Design Pattern - At the test class wherein navigation happens across several different pages like FlightsHomePage, SearchPage, PassengerDetailsPage
  - Currently I have added a test case with these steps:
    1. Navigate to URL - https://blazedemo.com/
    2. Enter 'From' and 'To' airports and search for available flights
    3. From the search list iterate through the prices of each flight and select the flight with lowest price
    4. Once the flight is selected, provide the passenger details and confirm the booking
    5. Verify that the booking is successful
  - To test the project, download and open this repository on Eclipse, right click on project --> Maven Build and then perform Maven --> Install to execute the tests
  
