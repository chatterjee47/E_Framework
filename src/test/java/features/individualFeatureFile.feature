Feature: Verifying features for individualFeatureFile

    
    
    
    
  @WidgetsDatePicker
  Scenario: To verify Widgets Date Picker function
    Given I go Widgets
    And I click on Date Picker
    When I click DateANDTime
    And I click on month 'March'
    And I click on 'year'
    Then the date and time should be selected
 
      @ActionsPageScenarioOne
  Scenario: To verify Actions Page for Scenario One
    Given I go to Actions Page
    And I verify that the webpage is showing the text 'DROP HERE!'
    And If I put the square 'Drag me to my' target to the 'DROP HERE!' area
    Then I verify that the drop here area is changed from 'DROP HERE!' to 'Dropped!'