Feature: Verifying features for webdriveruniversity.com

  @LoginPortal
  Scenario Outline: To verify Login-Portal function
    Given I go to webdriveruniversity website
    When I clicked on Login Portal link
    When I type Username "<username>"
    And I type password "<password>"
    And I click login button
    Then I can be able to log in successfully
    Then User close the Browser

    Examples: 
      | username | password      |
      | abcd     | Testing12345$ |

  @WebElementClick
  Scenario: To verify WebElement Click function
    Given I am in  Button Clicks page
    When I click WebElement click me
    And press close
    Then the modal Congratulations should be closed

  @JavaScriptClick
  Scenario: To verify JavaScript Click function
    Given User is in  Button Clicks page
    When I click JavaScript Click <click me>
    And I verify that the string is present with some message
    And close the pop window
    Then the modal <It’s that Easy!! Well I think it is>should be closed

  @ActionMoveClick
  Scenario: To verify Action Move & Click function
    Given User Clicks on Button page
    When I click Action Move & Click <click me>
    And Click on close button
    Then the modal should be closed

  @PageObjectModel
  Scenario: To verify Page Object Model function
    Given I go to the page called Page Object Model
    And I click Our products
    And I click New Laptops
    And I verify from the modal the number <NEWCUSTOMER>
    And I click proceed
    And I click desktop systems
    And I click Cancel
    Then the modal should be cancelled

  @AccordianTextAffects
  Scenario: To verify AccordianTextAffects function
    Given I go to the ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR) page
    When I click on Manual Testing
    And I verify the following  Manual Testing text display
    And I click on Cucumber BDD
    And I verify the Cucumber BDD text display

  @DropdownMenuCheckboxeRadioBtns
  Scenario: To verify Dropdown Menus, Checkboxes & Radio Btns function
    Given Land on Dropdown Menu(s), Checkboxe(s), Radio Btns page
    And from the Dropdown Menu(s) I select C#
    And from the second Dropdown Menu I select Junit
    And from the third Dropdown Menu I select Html
    And again from the third Dropdown Menu I change Html to css
    And from the Checkboxe(s) I click on option three and option four
    And from the Selected & Disabled I click Cabbage
    And from the Selected & Disabled dropdown menu I select Pear
    And I click again the Selected & Disabled dropdown menu and I verify that Orange is disabled
    Then we should be able to verify that Orange is disabled

  @AjaxLoader
  Scenario: To verify Ajax-Loader function
    Given I go to Ajax-Loader page
    And I click 'Click Me'
    And I verify the following text in the modal 'Well Done For Waiting'
    And I verify the following text in the modal 'The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits.'
    And I click close
    Then the modal shall close

  @ActionsPageScenarioOne
  Scenario: To verify Actions Page for Scenario One
    Given I go to Actions Page
    And I verify that the webpage is showing the text 'DROP HERE!'
    And If I put the square 'Drag me to my' target to the 'DROP HERE!' area
    Then I verify that the drop here area is changed from 'DROP HERE!' to 'Dropped!'

  @ActionsPageScenarioTwo
  Scenario: To verify Actions Page for Scenario Two
    Given I navigate go to Actions Page
    And I double click on the 'Double Click Me!' area
    And I hover over the 'Hover Over Me First!'
    And I click 'Link one'
    And I verify the string 'Well done you clicked on the link!'
    And I click Ok
    Then The javascript modal should get close

  @ActionsPageScenarioThree
  Scenario: To verify Actions Page for Scenario Three
    Given I landed on Actions Page
    And I click on 'Don't Release me'
    Then I verify the string 'Well done! keep holding that click now.....'
    And I hover over the 'Hover Over Me Third!'
    And I click the second 'Link one'
    Then the Javascript modal should come up

  @Scrollingpage
  Scenario: To verify Scrolling page
    Given I go to Scrolling page
    When I scroll to the 'Dont forget to scroll to me' area
    Then I verify that this character 'X:' is showing on the page

  @PopupsAlertspage
  Scenario: To verify Popups & Alerts page
    Given I go to Popups & Alerts page
    When I click on click me on JavaScript Alert
    And I click Ok on the javascript modal
    And I click on click me on Modal Popup
    And I verify the following text from the modal 'We can inject and use JavaScript code if all else fails! Remember always try to use WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).'
    And User click on close
    Then modalwindow should be closed

  @IFramepage
  Scenario: To verify IFrame page
    Given I go to IFrame page
    And I click Find out more
    And I click Close on the modal
    And I click Contact us
    And I fill in the contact us page with all the information except with an incorrect email
    And I click submit
    And I verify the error message 'Error: Invalid email address'
    And on the browser I click the previous button
    And on the browser I click the previous button again
    Then I should go back to the IFrame page

  @AutocompleteTextField
  Scenario: To verify Autocomplete TextField page
    Given I go to Autocomplete TextField page
    And I type in P on the search area
    Then I verify the the following came up as selection: Pizza Pepperoni Pancakes

  @FileUploadpage
  Scenario: To verify File Upload page
    Given I go to File Upload page
    And I click Choose file
    And I choose a file from the pc and upload it
    And I click on submit button
    Then a modal confirmation shows 'Your file has now been uploaded!'

  @Datepickerpage
  Scenario: To verify Datepicker page
    Given I go to Datepicker page
    When I click on tomorrows date
    Then Tommorows date should be selected

  @SelectNMDate
  Scenario: To verify Date for November and March
    Given Launch Datepicker page
    When I click on the date second november twenty twenty
    And I click on the date fifth march twenty twentyone
    Then the date fifth march twenty twentyone should be selected

  @VerifyWebsites
  Scenario: To verify Two websites simutaneously
    Given that I go to webdriveruniversity url
    And I Go to the Login Portal
    And I Go from the login portal to another website called simonskitchens url
    And I click Kitchens
    And I select new england eight
    And I go back to the previous page and I click again Kitchens
    And I select new england nine
    Then New england nine kitchen page should be shown
