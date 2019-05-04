$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddNewComputer.feature");
formatter.feature({
  "line": 1,
  "name": "Add a new computer",
  "description": "I want to check if the user can add a new computer data",
  "id": "add-a-new-computer",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Add a new computer",
  "description": "",
  "id": "add-a-new-computer;add-a-new-computer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User Clicks on Add a new compute button from Main Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I entered \"\u003cname\u003e\", \"\u003cintroducedDate\u003e\" , \"\u003cdiscontinuedDate\u003e\" ,\"\u003ccompany\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Adding success message is shwon in the Main Page",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "add-a-new-computer;add-a-new-computer;",
  "rows": [
    {
      "cells": [
        "name",
        "introducedDate",
        "discontinuedDate",
        "company"
      ],
      "line": 10,
      "id": "add-a-new-computer;add-a-new-computer;;1"
    },
    {
      "cells": [
        "HP ProBook",
        "2010-05-01",
        "2010-05-01",
        "Hewlett-Packard"
      ],
      "line": 11,
      "id": "add-a-new-computer;add-a-new-computer;;2"
    },
    {
      "cells": [
        "Lenovo ThinkPad",
        "2015-05-12",
        "2020-05-12",
        "Lenovo Group"
      ],
      "line": 12,
      "id": "add-a-new-computer;add-a-new-computer;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Add a new computer",
  "description": "",
  "id": "add-a-new-computer;add-a-new-computer;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User Clicks on Add a new compute button from Main Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I entered \"HP ProBook\", \"2010-05-01\" , \"2010-05-01\" ,\"Hewlett-Packard\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Adding success message is shwon in the Main Page",
  "keyword": "Then "
});
formatter.match({
  "location": "AddComputerTestwithBDD.i_click_on_Add_a_new_computer_button()"
});
formatter.result({
  "duration": 559774071,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HP ProBook",
      "offset": 11
    },
    {
      "val": "2010-05-01",
      "offset": 25
    },
    {
      "val": "2010-05-01",
      "offset": 40
    },
    {
      "val": "Hewlett-Packard",
      "offset": 54
    }
  ],
  "location": "AddComputerTestwithBDD.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 1186661763,
  "status": "passed"
});
formatter.match({
  "location": "AddComputerTestwithBDD.adding_success_message_is_shwon_in_the_Main_Page()"
});
formatter.result({
  "duration": 91588072,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Add a new computer",
  "description": "",
  "id": "add-a-new-computer;add-a-new-computer;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User Clicks on Add a new compute button from Main Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I entered \"Lenovo ThinkPad\", \"2015-05-12\" , \"2020-05-12\" ,\"Lenovo Group\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Adding success message is shwon in the Main Page",
  "keyword": "Then "
});
formatter.match({
  "location": "AddComputerTestwithBDD.i_click_on_Add_a_new_computer_button()"
});
formatter.result({
  "duration": 319396023,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Lenovo ThinkPad",
      "offset": 11
    },
    {
      "val": "2015-05-12",
      "offset": 30
    },
    {
      "val": "2020-05-12",
      "offset": 45
    },
    {
      "val": "Lenovo Group",
      "offset": 59
    }
  ],
  "location": "AddComputerTestwithBDD.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 994901509,
  "status": "passed"
});
formatter.match({
  "location": "AddComputerTestwithBDD.adding_success_message_is_shwon_in_the_Main_Page()"
});
formatter.result({
  "duration": 68551241,
  "status": "passed"
});
});