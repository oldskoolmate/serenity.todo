@all @clearCompletedTodoItems
Feature: Clear all completed todo items

  User should be able to organize his list by clearing all completed items at once


  Scenario: Todo list should be empty when all completed items are cleared
    Given John has items 'Fix my car, Walk the dog' in his todo list
    And he completes the item called 'Walk the dog'
    And he completes the item called 'Fix my car'
    When he clears all completed items
    Then his todo list should be empty