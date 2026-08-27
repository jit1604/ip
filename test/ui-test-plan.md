# UI Test Plan for GUNNA Chatbot

This file contains test cases for the GUNNA chatbot user interface.

## Test Case 1: Add Todo Task

**Aim:** Test that a todo task can be added successfully

**Input:**
```
todo borrow book
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] borrow book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] borrow book
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 2: Add Deadline Task

**Aim:** Test that a deadline task can be added successfully

**Input:**
```
deadline return book /by 2024-12-15
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] return book (by: Dec 15 2024)
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[D][ ] return book (by: Dec 15 2024)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 3: Add Event Task

**Aim:** Test that an event task can be added successfully

**Input:**
```
event project meeting /from Mon 2pm /to 4pm
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [E][ ] project meeting (from: Mon 2pm to: 4pm)
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[E][ ] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 4: Mark Task as Done

**Aim:** Test that a task can be marked as done

**Input:**
```
todo read book
mark 1
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] read book
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][X] read book
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 5: Unmark Task

**Aim:** Test that a task can be unmarked (marked as not done)

**Input:**
```
todo read book
mark 1
unmark 1
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] read book
____________________________________________________________
____________________________________________________________
     OK, I've marked this task as not done yet:
       [T][ ] read book
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] read book
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 6: Multiple Tasks with Different Types

**Aim:** Test adding multiple tasks of different types and listing them

**Input:**
```
todo buy groceries
deadline submit assignment /by 2024-12-20
event team meeting /from 2pm /to 3pm
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] buy groceries
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] submit assignment (by: Dec 20 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [E][ ] team meeting (from: 2pm to: 3pm)
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] buy groceries
     2.[D][ ] submit assignment (by: Dec 20 2024)
     3.[E][ ] team meeting (from: 2pm to: 3pm)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 7: Deadline with Invalid Format

**Aim:** Test error handling for deadline without /by delimiter

**Input:**
```
deadline return book
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! Please use the format: deadline <description> /by <time>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 8: Event with Invalid Format

**Aim:** Test error handling for event without proper delimiters

**Input:**
```
event meeting
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! Please use the format: event <description> /from <time> /to <time>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 9: Empty Todo Description

**Aim:** Test error handling for todo without description

**Input:**
```
todo
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The description of a todo cannot be empty.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 10: Unknown Command

**Aim:** Test error handling for unknown commands

**Input:**
```
blah
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! I'm sorry, but I don't know what that means :-(
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 11: Invalid Mark Number

**Aim:** Test error handling for marking non-existent task

**Input:**
```
todo read book
mark 5
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 5 doesn't exist.
     You have 1 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 12: Empty Deadline Description

**Aim:** Test error handling for deadline with empty description

**Input:**
```
deadline  /by tomorrow
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The description of a deadline cannot be empty.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 13: Mark with Non-Numeric Input

**Aim:** Test error handling for mark with non-numeric input

**Input:**
```
todo read book
mark abc
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number must be a valid number.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 14: Empty Event Description

**Aim:** Test error handling for event with empty description

**Input:**
```
event  /from 2pm /to 4pm
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The description of an event cannot be empty.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 15: Interleaved Error and Success - State Integrity

**Aim:** Test that errors don't corrupt internal state; task count should remain correct

**Input:**
```
todo
todo valid task
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The description of a todo cannot be empty.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] valid task
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] valid task
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 16: Mark with Zero

**Aim:** Test error handling for marking task 0

**Input:**
```
todo read book
mark 0
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 0 doesn't exist.
     You have 1 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 17: Mark with Negative Number

**Aim:** Test error handling for marking with negative task number

**Input:**
```
todo read book
mark -1
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number -1 doesn't exist.
     You have 1 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 18: Multiple Errors Then Success

**Aim:** Test that multiple errors don't affect subsequent successful operations

**Input:**
```
blah
todo
deadline return book
todo buy groceries
deadline submit report /by 2024-12-25
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! I'm sorry, but I don't know what that means :-(
____________________________________________________________
____________________________________________________________
     OOPS!!! The description of a todo cannot be empty.
____________________________________________________________
____________________________________________________________
     OOPS!!! Please use the format: deadline <description> /by <time>
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] buy groceries
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] submit report (by: Dec 25 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] buy groceries
     2.[D][ ] submit report (by: Dec 25 2024)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 19: Unmark Non-Existent Task

**Aim:** Test error handling for unmarking non-existent task

**Input:**
```
todo task1
unmark 2
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 2 doesn't exist.
     You have 1 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 20: Empty Deadline Time

**Aim:** Test error handling for deadline with empty time after /by

**Input:**
```
deadline submit assignment /by
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The deadline time cannot be empty.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 21: Interleaved Success, Error, Success - Mark Operations

**Aim:** Test that marking errors don't affect valid mark operations

**Input:**
```
todo task1
todo task2
mark 1
mark 5
mark 2
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task2
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] task1
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 5 doesn't exist.
     You have 2 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] task2
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][X] task1
     2.[T][X] task2
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 22: Mark Without Number

**Aim:** Test error handling for mark command without task number

**Input:**
```
todo task1
mark
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Please specify which task to mark.
     Usage: mark <task number>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 23: Unmark Without Number

**Aim:** Test error handling for unmark command without task number

**Input:**
```
todo task1
mark 1
unmark
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] task1
____________________________________________________________
____________________________________________________________
     OOPS!!! Please specify which task to unmark.
     Usage: unmark <task number>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 24: Empty Event Time

**Aim:** Test error handling for event with empty time fields

**Input:**
```
event meeting /from 2pm /to
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! The event time cannot be empty.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 25: Complex Interleaved Operations

**Aim:** Test complex interleaving of successful and failed operations to verify complete state integrity

**Input:**
```
todo task1
deadline
event meeting /from 2pm /to 3pm
mark 1
mark 10
todo task2
unmark abc
unmark 1
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Please use the format: deadline <description> /by <time>
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [E][ ] meeting (from: 2pm to: 3pm)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] task1
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 10 doesn't exist.
     You have 2 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task2
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number must be a valid number.
____________________________________________________________
____________________________________________________________
     OK, I've marked this task as not done yet:
       [T][ ] task1
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] task1
     2.[E][ ] meeting (from: 2pm to: 3pm)
     3.[T][ ] task2
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 26: Delete Task

**Aim:** Test that a task can be deleted successfully

**Input:**
```
todo task1
todo task2
todo task3
delete 2
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task2
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task3
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     Noted. I've removed this task:
       [T][ ] task2
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] task1
     2.[T][ ] task3
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 27: Delete Non-Existent Task

**Aim:** Test error handling for deleting non-existent task

**Input:**
```
todo task1
delete 5
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number 5 doesn't exist.
     You have 1 task(s) in your list.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 28: Delete Without Number

**Aim:** Test error handling for delete command without task number

**Input:**
```
todo task1
delete
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Please specify which task to delete.
     Usage: delete <task number>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 29: Delete with Invalid Number

**Aim:** Test error handling for delete with non-numeric input

**Input:**
```
todo task1
delete abc
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] task1
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Task number must be a valid number.
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 30: Delete Different Task Types

**Aim:** Test deleting different task types (Todo, Deadline, Event)

**Input:**
```
todo buy groceries
deadline submit report /by 2024-12-31
event meeting /from 2pm /to 3pm
delete 2
list
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] buy groceries
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] submit report (by: Dec 31 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [E][ ] meeting (from: 2pm to: 3pm)
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     Noted. I've removed this task:
       [D][ ] submit report (by: Dec 31 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] buy groceries
     2.[E][ ] meeting (from: 2pm to: 3pm)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 31: Invalid Date Format in Deadline

**Aim:** Test error handling for invalid date format in deadline

**Input:**
```
deadline return book /by 12/31/2024
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 32: Find Tasks on Specific Date

**Aim:** Test the on command to find tasks on a specific date

**Input:**
```
deadline return book /by 2024-12-15
deadline submit assignment /by 2024-12-15
deadline project meeting /by 2024-12-20
on 2024-12-15
on 2024-12-20
on 2024-12-10
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] return book (by: Dec 15 2024)
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] submit assignment (by: Dec 15 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] project meeting (by: Dec 20 2024)
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks on Dec 15 2024:
     1.[D][ ] return book (by: Dec 15 2024)
     2.[D][ ] submit assignment (by: Dec 15 2024)
____________________________________________________________
____________________________________________________________
     Here are the tasks on Dec 20 2024:
     1.[D][ ] project meeting (by: Dec 20 2024)
____________________________________________________________
____________________________________________________________
     No tasks found on Dec 10 2024
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 33: Find Tasks by Keyword - Multiple Matches

**Aim:** Test finding tasks by searching for a keyword with multiple matches

**Input:**
```
todo read book
deadline return book /by 2024-06-15
todo buy groceries
find book
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [D][ ] return book (by: Jun 15 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] buy groceries
     Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][ ] read book
     2.[D][ ] return book (by: Jun 15 2024)
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 34: Find Tasks by Keyword - No Matches

**Aim:** Test finding tasks when no matches exist

**Input:**
```
todo read book
todo buy groceries
find meeting
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] buy groceries
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     No matching tasks found for: meeting
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 35: Find Tasks by Keyword - Case Insensitive

**Aim:** Test that keyword search is case-insensitive

**Input:**
```
todo Read Book
todo BUY GROCERIES
find book
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] Read Book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] BUY GROCERIES
     Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][ ] Read Book
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Test Case 36: Find Tasks with Empty Keyword

**Aim:** Test error handling when find command has no keyword

**Input:**
```
todo read book
find
bye
```

**Expected Output:**
```
____________________________________________________________
    ____
 / ___|_   _ _ __  _ __   __ _
| |  _| | | | '_ \| '_ \ / _` |
| |_| | |_| | | | | | | | (_| |
 \____|\__,_|_| |_|_| |_|\__,_|

     Hello! I'm GUNNA.
     What can I do for you?
____________________________________________________________
____________________________________________________________
     Got it. I've added this task:
       [T][ ] read book
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     OOPS!!! Please specify a search keyword.
     Usage: find <keyword>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```
