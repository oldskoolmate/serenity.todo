@all @filterTodoItems
Feature: Filtering todo items

  In order to not make a mess in todos list
  User should be able to organize his list by filtering items by it's status


  Scenario: Should show only active items when user filters his todo list by status 'active'
    Given John has items 'Fix my car, Walk the dog' in his todo list
    When he completes the item called 'Walk the dog'
    And he filters his list to show only Active items
    Then his todo list should contain item 'Fix my car'


  Scenario: Should show only completed items when user filters his todo list by status 'completed'
    Given John has items 'Fix my car, Walk the dog' in his todo list
    When he completes the item called 'Walk the dog'
    And he filters his list to show only Completed items
    Then his todo list should contain item 'Walk the dog'


  Scenario: Should show all items when user filters his todo list by status 'all'
    Given John has items 'Fix my car, Walk the dog' in his todo list
    And he filters his list to show only Active items
    When he completes the item called 'Walk the dog'
    And he filters his list to show All items
    Then his todo list should contain items 'Fix my car, Walk the dog'