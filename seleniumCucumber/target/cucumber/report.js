$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("apm_traverse.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "Title of your feature",
  "description": "I want to use this template for my APM login \u0026 validation test",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Navigate to APM \u0026 Login",
  "description": "",
  "id": "title-of-your-feature;navigate-to-apm-\u0026-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@Selenium"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I want to navigate to APM url",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "user provided with \"\u003cuid\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "pwd provided with \"\u003cpwd\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "tenant provided with \"\u003ctenant\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I click on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I validate the apm botton",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "click on apm bottom",
  "keyword": "And "
});
formatter.examples({
  "line": 32,
  "name": "",
  "description": "",
  "id": "title-of-your-feature;navigate-to-apm-\u0026-login;",
  "rows": [
    {
      "cells": [
        "uid",
        "pwd",
        "tenant"
      ],
      "line": 33,
      "id": "title-of-your-feature;navigate-to-apm-\u0026-login;;1"
    },
    {
      "cells": [
        "automation",
        "interOP@123",
        "Jyotsna.Akula@automation.com"
      ],
      "line": 34,
      "id": "title-of-your-feature;navigate-to-apm-\u0026-login;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1476386015,
  "status": "passed"
});
formatter.before({
  "duration": 1100645722,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Navigate to APM \u0026 Login",
  "description": "",
  "id": "title-of-your-feature;navigate-to-apm-\u0026-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@Selenium"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I want to navigate to APM url",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "user provided with \"automation\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "pwd provided with \"interOP@123\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "tenant provided with \"Jyotsna.Akula@automation.com\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I click on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I validate the apm botton",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "click on apm bottom",
  "keyword": "And "
});
formatter.match({
  "location": "APMBDDTraverse.navigateUrl()"
});
formatter.result({
  "duration": 23473618476,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automation",
      "offset": 20
    }
  ],
  "location": "APMBDDTraverse.getUID(String)"
});
formatter.result({
  "duration": 2037172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "interOP@123",
      "offset": 19
    }
  ],
  "location": "APMBDDTraverse.getpwd(String)"
});
formatter.result({
  "duration": 73459,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jyotsna.Akula@automation.com",
      "offset": 22
    }
  ],
  "location": "APMBDDTraverse.getTenant(String)"
});
formatter.result({
  "duration": 64016,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.i_search()"
});
formatter.result({
  "duration": 5121511337,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.validateAPMButton()"
});
formatter.result({
  "duration": 567765685,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.clickOnAPMButton()"
});
formatter.result({
  "duration": 18564881994,
  "status": "passed"
});
formatter.after({
  "duration": 91915527,
  "status": "passed"
});
formatter.after({
  "duration": 10908,
  "status": "passed"
});
formatter.before({
  "duration": 1071052972,
  "status": "passed"
});
formatter.before({
  "duration": 1072510039,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Click on Security Tab",
  "description": "",
  "id": "title-of-your-feature;click-on-security-tab",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@Selenium"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "I want to navigate to APM url",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "user provided with \"automation\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "pwd provided with \"interOP@123\"",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "tenant provided with \"Jyotsna.Akula@automation.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I click on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "click on apm bottom",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "close the popup",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I click on security tab",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "security list page should display",
  "keyword": "Then "
});
formatter.match({
  "location": "APMBDDTraverse.navigateUrl()"
});
formatter.result({
  "duration": 22987148435,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automation",
      "offset": 20
    }
  ],
  "location": "APMBDDTraverse.getUID(String)"
});
formatter.result({
  "duration": 96625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "interOP@123",
      "offset": 19
    }
  ],
  "location": "APMBDDTraverse.getpwd(String)"
});
formatter.result({
  "duration": 46041,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jyotsna.Akula@automation.com",
      "offset": 22
    }
  ],
  "location": "APMBDDTraverse.getTenant(String)"
});
formatter.result({
  "duration": 45431,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.i_search()"
});
formatter.result({
  "duration": 5436471331,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.clickOnAPMButton()"
});
formatter.result({
  "duration": 10570425723,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.closePopup()"
});
formatter.result({
  "duration": 1249570175,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.securityTabClick()"
});
formatter.result({
  "duration": 1665114385,
  "status": "passed"
});
formatter.match({
  "location": "APMBDDTraverse.securityList()"
});
formatter.result({
  "duration": 16525,
  "status": "passed"
});
formatter.after({
  "duration": 107927726,
  "status": "passed"
});
formatter.after({
  "duration": 13587,
  "status": "passed"
});
formatter.uri("google_Search.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: basanta4u@gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Title of your feature",
  "description": "I want to use this file for my first  BDD test",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1181873023,
  "status": "passed"
});
formatter.before({
  "duration": 972245609,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Search an item with google and found wiki page",
  "description": "",
  "id": "title-of-your-feature;search-an-item-with-google-and-found-wiki-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@Selenium"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the google search page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I search \"Dog\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I should find a list results of \"Dog\"",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchTestBDD.get_google_search_page()"
});
formatter.result({
  "duration": 614836381,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dog",
      "offset": 10
    }
  ],
  "location": "GoogleSearchTestBDD.i_search(String)"
});
formatter.result({
  "duration": 8002888266,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dog",
      "offset": 33
    }
  ],
  "location": "GoogleSearchTestBDD.i_should_find_a_list_results_of(String)"
});
formatter.result({
  "duration": 9333162,
  "status": "passed"
});
formatter.after({
  "duration": 68933929,
  "status": "passed"
});
formatter.after({
  "duration": 11463,
  "status": "passed"
});
});