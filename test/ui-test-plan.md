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
deadline return book /by Sunday
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
       [D][ ] return book (by: Sunday)
     Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
     Here are the tasks in your list:
     1.[D][ ] return book (by: Sunday)
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
deadline submit assignment /by Friday
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
       [D][ ] submit assignment (by: Friday)
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
     2.[D][ ] submit assignment (by: Friday)
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
     Please use the format: deadline <description> /by <time>
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
     Please use the format: event <description> /from <time> /to <time>
____________________________________________________________
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```
