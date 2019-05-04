Feature: Add a new computer
I want to check if the user can add a new computer data

  Scenario Outline: Add a new computer
    Given User Clicks on Add a new compute button from Main Page
    When  I entered "<name>", "<introducedDate>" , "<discontinuedDate>" ,"<company>"
    Then Adding success message is shwon in the Main Page

    Examples: 
      | name | introducedDate | discontinuedDate | company |
      | HP ProBook | 2010-05-01 | 2010-05-01 | Hewlett-Packard | 
      | Lenovo ThinkPad | 2015-05-12 | 2020-05-12 | Lenovo Group | 
      