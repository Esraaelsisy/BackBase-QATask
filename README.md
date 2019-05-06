# BackBase-QATask
Selenium Framework project using Java , Maven , TestNG  , Cucumber with applying Page Object Model and Behavior Driven Development.

# Description 
Selenium Framework project using Java , Maven , TestNG  , Cucumber with applying Page Object Model and Behavior Driven Development.
This framework is developed for Regression Testing scope of the CURD Functions of "https://computer-database.herokuapp.com/computers" on Both Chrome and Firefox browsers on Windows OS

# How to run? 
There are several ways to run the code after importing the project:

- Run each test separately by right click on the class and select run as testNG test.
- Run the "Regression Suite.xml" as testNG suite you can add the browser parameter in it or leave it to take the optional value in testBase class --> it will run the tests with "Regression" group included
- Run the "Regression Suite for Selenium Grid.xml" as testNG suite you can add the browser parameter in it or leave it to take the optional value in testBase class --> it will run the tests with "Regression" group included Parallel 
- Run the BDD test by right click on the "Test Runner.java" class and select run as testNG test.
- Run through the command line by navigating to the project folder then write "mvn clean install test -DsuiteXmlFile= Regression Suite.xml" or "mvn clean install test -DsuiteXmlFile= Regression Suite for Selenium Grid.xml"

# Project Packages
Project consists of 7 packages as the following:

- "pages": This package contains of "PageBase" class which initializes the driver and elements of each Page . 
  Besides , Page Classes which have the locators and methods for dealing with the web elements of each page with an inheritance of "PageBase" superclass.

- "tests": This package contains of "TestBase" class which starts and stops the WebDriver for each <Test> tag in TestNG xml file. 
    Besides , Test Classes which have the Independent Test scenarios mapped with the methods from page objects , with an inheritance from "TestBase" superclass 
    
- "gridTests" : This package contains of "TestBaseforSeleniumGrid" class which starts and stops the Remote WebDriver for each <Test> tag in TestNG xml file. Besides , Test Classes which have the Independent Test scenarios mapped with the methods from page objects , with an inheritance from "TestBasefor SeleniumGrid" superclass to be run parallel.
  
- "utilities": This package contains of "helper" class that has all the handler functions needed through the test classes , like : Date formatting , Taking screenshots and Colors formatting

- "data" :  This package contains JSON File contains computer Data and JSON File reader to get Data from the JSON file

- "features" :  This package is related to BDD using cucumber , it contains a sample of feature files written in gherkin language , so it can be readable by the whole team

- "steps" :  This package is related to BDD using cucumber and contains the Test Class that is mapped to each step mentioned in the feature file

- "runner" :  This package is related to BDD using cucumber , it contains of the Runner Class that runs the features file mapped to its test class with steps


- Every test class in "tests" package contains one or more test methods that deals with one or more page object to make the steps for the test and then after complete the steps verifying the results with assertions .Most of them are grouped in "Regression" group.

# Project Additional Folders 
- "Manual Testing" :  contains the manual tests for CURD functions.
- "drivers" : contains Chrome Driver and geckodriver for Windows OS.
- "Screenshots" :  contains screenshots taken on failure or on purpose.
- "target / cucumber-html-report" :  contains "index.html" file for cucumber BDD test running results.
- "test-output" : contains "index.html" file for TestNG tests running results.
- "Regression suite.xml" :  XML file for testng suite to be run sequentially
- "Regression Suite for Selenium Grid.xml" :  XML file for testng suite to be run parallel


# Project Deliverables 
- Screenshots taken in case of failure of test cases.
- Screenshots taken for the test cases of checking Page UI .
- TestNG Report will be in  "test-output" folder after running the tests in "Regression Suite.xml" file
- Cucumber Report will be in "target/ cucumber-html-report" after running the "TestRunner.java" class


# Dependencies/Plugins used
- Selenium: To initiate the driver and handle with the web elements.
- Testng: Used for test annotations , asserting on the results and parallel execution.
- Cucumber: Used for testing BDD via features , steps and runner 
- Gherkin: Used for writing testing BDD readable features 
- json-simple: This used to parse  and read the JSON test data file.
- Maven-surefire-plugin: used for configuring the testng and suite xml"Regression Suite.xml"
- Maven-compiler-plugin: used to compile the project to  java version 1.8 
- Faker : for creating random fake data