@all @clearCompletedTodoItems
Feature: Clear all completed todo items

  User should be able to organize his list by clearing all completed items at once


  Scenario: Todo list should be empty when all completed items are cleared
    Given John has completed items 'Fix my car, Walk the dog' in his todo list
    When he clears all completed items
    Then his todo list should be empty