@all @completeTodoItems
Feature: Completing todo items

  In order to not make a mess in todos list
  User should be able to organize his list by marking items as completed


  Scenario: Completed items should appear as completed in a list
    Given John has items 'Fix my car, Walk the dog' in his todo list
    When he completes the item called 'Walk the dog'
    Then 'Walk the dog' should appear as completed in his list