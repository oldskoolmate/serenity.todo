@all @addNewTodoItems
  Feature: User should be able to add new todo items


    Scenario: Should add an item to an empty list
      Given John has an empty todo list
      When he adds 'Write email to Kelly' to his list
      Then 'Write email to Kelly' should be created in his list


    Scenario: Should add an item to an existing list
      Given John has items 'Fix my car, Walk the dog' in his todo list
      When he adds 'Visit doctor' to his list
      Then his todo list should contain items 'Fix my car, Walk the dog, Visit doctor'

