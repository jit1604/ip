# GUNNA User Guide

GUNNA is a desktop application for managing your tasks via a Command Line Interface (CLI). If you can type fast, GUNNA can help you manage your tasks faster than traditional GUI applications.

## Quick Start

1. Ensure you have Java 11 or above installed
2. Download the latest `gunna.jar` from the releases page
3. Run the application with `java -jar gunna.jar`
4. Type commands in the command box and press Enter to execute them

## Features

### Adding a Todo Task

Adds a simple task without any date/time.

Format: `todo DESCRIPTION`

Example: `todo borrow book`

Expected output:
```
____________________________________________________________
     Got it. I've added this task:
       [T][ ] borrow book
     Now you have 1 tasks in the list.
____________________________________________________________
```

### Adding a Deadline Task

Adds a task with a specific deadline.

Format: `deadline DESCRIPTION /by DATE`

- `DATE` must be in `yyyy-MM-dd` format (e.g., 2024-12-31)

Example: `deadline return book /by 2024-12-15`

Expected output:
```
____________________________________________________________
     Got it. I've added this task:
       [D][ ] return book (by: Dec 15 2024)
     Now you have 1 tasks in the list.
____________________________________________________________
```

### Adding an Event Task

Adds a task that occurs during a specific time period.

Format: `event DESCRIPTION /from START_TIME /to END_TIME`

Example: `event project meeting /from Mon 2pm /to 4pm`

Expected output:
```
____________________________________________________________
     Got it. I've added this task:
       [E][ ] project meeting (from: Mon 2pm to: 4pm)
     Now you have 1 tasks in the list.
____________________________________________________________
```

### Listing All Tasks

Shows all tasks in your task list in the order they were added.

Format: `list`

Example: `list`

Expected output:
```
____________________________________________________________
     Here are the tasks in your list:
     1.[T][ ] borrow book
     2.[D][ ] return book (by: Dec 15 2024)
     3.[E][ ] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
```

### Marking a Task as Done

Marks a task as completed.

Format: `mark TASK_NUMBER`

- `TASK_NUMBER` refers to the task number shown in the list

Example: `mark 1`

Expected output:
```
____________________________________________________________
     Nice! I've marked this task as done:
       [T][X] borrow book
____________________________________________________________
```

### Unmarking a Task

Marks a task as not done yet.

Format: `unmark TASK_NUMBER`

Example: `unmark 1`

Expected output:
```
____________________________________________________________
     OK, I've marked this task as not done yet:
       [T][ ] borrow book
____________________________________________________________
```

### Deleting a Task

Removes a task from your task list permanently.

Format: `delete TASK_NUMBER`

Example: `delete 2`

Expected output:
```
____________________________________________________________
     Noted. I've removed this task:
       [D][ ] return book (by: Dec 15 2024)
     Now you have 2 tasks in the list.
____________________________________________________________
```

### Finding Tasks by Keyword

Searches for tasks whose descriptions contain the given keyword (case-insensitive).

Format: `find KEYWORD`

Example: `find book`

Expected output:
```
____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][ ] borrow book
     2.[D][ ] return book (by: Jun 15 2024)
____________________________________________________________
```

### Finding Tasks by Date

Finds all deadline tasks that are due on a specific date.

Format: `on DATE`

- `DATE` must be in `yyyy-MM-dd` format

Example: `on 2024-12-15`

Expected output:
```
____________________________________________________________
     Here are the tasks on Dec 15 2024:
     1.[D][ ] return book (by: Dec 15 2024)
     2.[D][ ] submit assignment (by: Dec 15 2024)
____________________________________________________________
```

### Sorting Tasks

Displays your tasks in sorted order (temporary display only - does not save to file).

Format: `sort CRITERION`

Available criteria:
- `status` - Not-done tasks first, then done tasks
- `description` - Alphabetical order A-Z (case-insensitive)
- `date` - Deadlines by date (oldest first), then Todos/Events in original order

Examples:

**Sort by status:**
```
sort status
____________________________________________________________
     Here are your tasks sorted by status:
     1.[T][ ] task B
     2.[T][X] task A
____________________________________________________________
```

**Sort by description:**
```
sort description
____________________________________________________________
     Here are your tasks sorted by description:
     1.[T][ ] apple
     2.[T][ ] Mango
     3.[T][ ] zebra
____________________________________________________________
```

**Sort by date:**
```
sort date
____________________________________________________________
     Here are your tasks sorted by date:
     1.[D][ ] early (by: Jan 15 2024)
     2.[D][ ] late (by: Dec 31 2024)
     3.[T][ ] no date task
     4.[E][ ] meeting (from: 2pm to: 4pm)
____________________________________________________________
```

**Note:** Sorting is temporary. Use the `list` command to see tasks in their original order.

### Exiting the Application

Exits GUNNA and saves your tasks to disk.

Format: `bye`

Expected output:
```
____________________________________________________________
     Bye. Hope to see you again soon!
____________________________________________________________
```

## Command Summary

| Command | Format | Example |
|---------|--------|---------|
| Add Todo | `todo DESCRIPTION` | `todo read book` |
| Add Deadline | `deadline DESCRIPTION /by DATE` | `deadline return book /by 2024-12-31` |
| Add Event | `event DESCRIPTION /from START /to END` | `event meeting /from 2pm /to 4pm` |
| List Tasks | `list` | `list` |
| Mark Task | `mark TASK_NUMBER` | `mark 1` |
| Unmark Task | `unmark TASK_NUMBER` | `unmark 1` |
| Delete Task | `delete TASK_NUMBER` | `delete 2` |
| Find by Keyword | `find KEYWORD` | `find book` |
| Find by Date | `on DATE` | `on 2024-12-15` |
| Sort Tasks | `sort CRITERION` | `sort status` |
| Exit | `bye` | `bye` |

## Data Storage

Your tasks are automatically saved to `data/duke.txt` in the same folder as the application. The file is created automatically if it doesn't exist. You can safely delete this file if you want to start fresh.

## Error Messages

GUNNA will display helpful error messages if you enter invalid commands:

- **Missing description:** "OOPS!!! The description of a [task type] cannot be empty."
- **Invalid format:** "OOPS!!! Please use the format: [correct format]"
- **Invalid task number:** "OOPS!!! Task number X doesn't exist."
- **Invalid date format:** "OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)"
- **Invalid sort criterion:** "OOPS!!! Invalid sort criterion.\n     Usage: sort status / sort description / sort date"

## Tips

- All commands are case-sensitive (use lowercase)
- Task numbers start from 1
- Dates must be in `yyyy-MM-dd` format for deadlines and the `on` command
- The sort criterion (`status`, `description`, `date`) is case-insensitive
- Sorting does not modify your saved task list - it only displays a sorted view
- Use `list` after sorting to see your tasks in their original order
