@all @toggleAllTodoItems
Feature: Toggle all todo items

  In order to not make a mess in todos list
  User should be able to organize his list by changing status of all items at once


  Scenario: Should toggle all active items on a list to completed status
    Given John has items 'Fix my car, Walk the dog' in his todo list
    And he filters his list to show only Completed items
    When he toggles the status of all items
    Then his todo list should contain items 'Fix my car, Walk the dog'


  Scenario: Should toggle all completed items on a list to active status
    Given John has completed items 'Fix my car, Walk the dog' in his todo list
    And he filters his list to show only Active items
    When he toggles the status of all items
    Then his todo list should contain items 'Fix my car, Walk the dog'


  Scenario: Should toggle all items on a list to completed status when there is at least one active item
    Given John has completed items 'Fix my car, Walk the dog' in his todo list
    And he adds 'Buy a house' to his list
    And he filters his list to show only Completed items
    When he toggles the status of all items
    Then his todo list should contain items 'Fix my car, Walk the dog, Buy a house'