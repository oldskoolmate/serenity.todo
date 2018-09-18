@all @countActiveTodoItems
Feature: Items left counter should reflect count of current active items


  Scenario: Items left counter should get incremented when a new item is added
    Given John has an empty todo list
    When he adds 'Write email to Kelly' to his list
    Then he should see 1 item left on his todo list counter


  Scenario: Items left counter should get decremented when an item is completed
    Given John has items 'Fix my car, Walk the dog, Find a new job' in his todo list
    When he completes the item called 'Find a new job'
    Then he should see 2 items left on his todo list counter