@all @completeTodoItems
Feature: Completing todo items

  In order to not make a mess in todos list
  User should be able to organize his list by marking items as completed


  Scenario: Completed items list should show completed items
    Given John has items 'Fix my car, Walk the dog' in his todo list
    When he completes the item called 'Walk the dog'
    And he filters his list to show only Completed items
    Then his todo list should contain item 'Walk the dog'


  Scenario: Completed items list should be empty when there is nothing completed
    Given John has items 'Fix my car, Walk the dog' in his todo list
    When he filters his list to show only Completed items
    Then his todo list should be empty
