# Phase 2 Report

## Initial Planning

1. Our definition of "Scrum Master" was someone who evaluates how the team works when moving forward on the project. This involves actions like making sure everyone attends meetings, making sure meetings are known of in advance, and taking notes during meetings for reference later, among others. In what time we had in the sprint, we attempted to rotate the role so as to have everyone get used to how the role runs.
2. We decided to estimate overall task size based on both the effort needed to complete a particular task as well as how broad the task would be in the scope of our project. For example, in our project doing something like creating a view in an android application would be a small task as it requires minimal effort and is only a small piece of the overall project. However, something like setting up a database is a relatively large task, requires quite a bit of effort to accomplish, and is a central element to the project. 

## Sprint Backlog
For our second sprint, we as a team talked together and threw around ideas of what we wanted to work toward for our MVP. We collectively decided that implementation of the most essential features and components were the way to go, and agreed that in the scope of our application, reviewing the dishes was our central feature and would need to be completed. We also figured out that we needed to construct some sort of database to hold the different types of information found in our app. Finally, we decided to build a very basic "skeleton" UI for our app - consisting of the different classes and activities we needed, even if they didn't necessarily work together yet.

We decided that the best way to build this app was to split it into many smaller, manageable parts that could be taken and completed one-by-one. We created a multitude of issues using both the recommended filters of [S-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AS-Size), [M-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AM-Size), and [L-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AL-Size), and then further put specification based on what part of the project the task was for. Features were tagged with [Feature](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AFeature), database structures were tagged with [Database](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3ADatabase), and the app views were tagged with [View](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AView).

In doing this, our goal was to be able to split up the work for the sprint based on what team members were most comfortable doing, or just wanted to try doing in general. Members were able to assign issues to themselves based on what they wanted to work on, post updates in the comments as needed, and close them when they were done. Essentially, this allowed for maximum organization and efficient communication to see what was going on within the project at all times. 

## Update Meetings

### Meeting 1 
Date: October 28th 2015. Location: BA3200. Time: 5pm-6pm. Minutes Taken: 60. All members present: Daniel, Felicia, Jake, Josh, Matt, Simon.

This meeting focused on getting the initial plan started by discussing the data types and structure needed to build the skeleton of the application. Features and structure types that were agreed upon included:

Minimum Features to add for MVP
- Dish reviewing
- Viewing reviewed dishes
- Keeping track of user stats
- Wishlist

Gameplan
- Initial Android Skeleton
- Setup SQL database
- Create views
    - Register/Login
    - Main Page (grid-based)
    - Add review
    - Browse reviews
    - Wishlist
    - User Stats

SQL
- List of Tables
    - User (username, password)
    - Restaurant (name, location, RID)
    - Review (Description, rating, UserID, DishID, Approval Rating)
    - Wishlist (UserID, DishID)
    - Dish (RID, Dish name, DishID, avg rating)

Inital priorities were set so that the SQL database was given a higher priority than the frontend screens. 

### Meeting 2
Date: October 30, 2015. Location: BA3185. Time: 4pm-4:45pm. Minutes Taken: 45. Most members present, minus two who unfortunately weren't properly notified due to communication errors: Felicia, Jake, Josh, Simon.

This meeting revolved around getting feedback for the phase by meeting with the TA. Allocated a slightly higher priority to the frontend of the application from TA feedback. Emphasis on a scrum method to build the app while organizing the project using issuses, backlogs, etc.

Feedback Given
- Demo a frontend application that the TA can see.
- Less emphasis placed on showing the SQL database.
- Follow the scrum method accordingly.

### Meeting 3 
Date: October 31, 2015. Location: BA3175. Time: 1PM-9PM. Minutes Taken: 480. All members present: Daniel, Felicia, Jake, Josh, Matt, Simon.

Began the application development by assigning screens and structures to two different teams: the frontend and the backend (SQL database). The two teams worked simutaneously together, opting to combine the backend and the frontend closer to when both ends are complete. A higher priority was set to the front end than the backend. The team was split in half with three members each composing the two teams.

Halfway through the meeting, there was a disparity between the amount of progress done with the frontend and the backend. The frontend was slightly ahead from the backend, therefore priority for the two ends were adjusted accordingly: frontend has a lower priority and backend now has a higher priority. Team members were also adjusted to reflect the priority change: frontend now has two members and backend has four members.

### Meeting 4
Date: November 1st, 2015. Location: BA3175. Time: 1PM-10PM. Minutes Taken: 600. All members present: Daniel, Felicia, Jake, Josh, Matt, Simon.

Focus for this meeting centered around fixing bugs in both ends of the project, completing unfinished parts, and combining the two ends together. After the completing of the frontend/backend. Members are now split into two different teams: the frontend/backend combining team and the bug fixing team. A higher priority was set for the combining team, in order to create a complete application. App was completed this meeting.

## Burndown Chart

Our burndown chart is accessible by clicking the link [Here](https://docs.google.com/spreadsheets/d/14-2i2dyXsWxWn_dsbVRaWYxYuStTxfykUb0gB_00piM/pubchart?oid=1671198759&format=interactive).

We formed our burndown chart by converting the opened issues for the sprint into points based on the size assigned. A task with an L-Size would be issued a size of 4, an M-Size a size of 2, and an S-size a size of 1.

We kept track of our tasks completed by evaluating our progress toward the closure of each issue per day. If significant progress had been made, points were taken off the task and "given" to the team members who worked on them that day, until that task's points reached zero - this would mean that the task was done, upon which the issue would be closed. For example, if two people worked on the database over two days, each person would get a point on each of the days, and 2 points are subtracted from the "Database" task each day. 

For our chart, the y-axis represents the total "points" that we assign all of the issues for this sprint for, which then decrease based on the work we were able to complete. 

## Review and Retrospective

1.
Tasks that dealt with the frontend UI were omitted due to time constraints. Functionality of the app was more important than designing an appealing GUI for the user. The task of fully implementing the restaurant table was also forgoed (ie. filling in all of the attributes - all restaurant locations are set to null), since restaurant location was a side detail that implemented location services. The payoff for implementing location services at this stage was not worth it.

Parts of the frontend that closely worked with the backend was split for functionality purposes. Screens, such as Add Review, had to be split into a purely UI interface and a SQL part. This was to ensure that data could be passed from the frontend to the backend without any issues and for testing purposes for the backend. The backend of the app had to be split so that more members were working on it, in order for funtionality and time requirements to be met. 

2.
The decisions to assign team members based on their strengths, allocate a specific time and place to work together, and create an skeleton of the application proved to be a well-thought out one. Members who were comfortable in their assigned tasks were able to create and implement the tasks with relative ease. The decision to meet in a specific time and place allowed for easy communication between team members and allowed for problems that arose while working to be quickly identified and solved. Designing the skeleton and choosing which features to implement allowed for a focused workflow. It was clear what needed to be implemented.

Decisions that did not work out well included: not keeping in mind how the two ends of the app melded together, and choosing a relatively new data structure for the backbone of the app. A lot of time was wasted due to not knowing exactly how each part of the app was supposed to interact with each other. For example, the restaurant table had fields that didn't take direct input from the screen and had to be further explained. Choosing a relatively new data structure for the backbone of the app had a few small hiccups. Some members were comfortable with the syntax and SQL language, while other were not. A significant amount of time was spent determining how to implement the database by other teammates clarifyinig how the structure worked to looking at tutorials on the Web.

Some ways to improve the project process would be to choose a data structure that more members are familiar with, and planning with a bit more detail. Choosing a familiar data structure would decrease the amount of time spent on figuring out how to implement the structure, and planning with more detail would eliminate confusion with how the project parts interact with each other. 
