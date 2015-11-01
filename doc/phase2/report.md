# Phase 2 Report

## Initial Planning

1. Our definition of "Scrum Master" was someone who evaluates how the team works when moving forward on the project. This involves actions like making sure everyone attends meetings, making sure meetings are known of in advance, and taking notes during meetings for reference later, among others. In what time we had in the sprint, we attempted to rotate the role so as to have everyone get used to how the role runs.
2. We decided to estimate overall task size based on both the effort needed to complete a particular task as well as how broad the task would be in the scope of our project. For example, in our project doing something like creating a view in an android application would be a small task as it requires minimal effort and is only a small piece of the overall project. However, something like setting up a database is a relatively large task, requires quite a bit of effort to accomplish, and is a central element to the project. 

## Sprint Backlog
For our second sprint, we as a team talked together and threw around ideas of what we wanted to work toward for our MVP. We collectively decided that implementation of the most essential features and components were the way to go, and agreed that in the scope of our application, reviewing the dishes was our central feature and would need to be completed. We also figured out that we needed to construct some sort of database to hold the different types of information found in our app. Finally, we decided to build a very basic "skeleton" UI for our app - consisting of the different classes and activities we needed, even if they didn't necessarily work together yet.

We decided that the best way to build this app was to split it into many smaller, manageable parts that could be taken and completed one-by-one. We created a multitude of issues using both the recommended filters of [S-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AS-Size), [M-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AM-Size), and [L-size](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AL-Size), and then further put specification based on what part of the project the task was for. Features were tagged with [Feature](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AFeature), database structures were tagged with [Database](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3ADatabase), and the app views were tagged with [View](https://github.com/issues?q=is%3Aopen+is%3Aissue+author%3Ajoshdmcc+label%3AView).

In doing this, our goal was to be able to split up the work for the sprint based on what team members were most comfortable doing, or just wanted to try doing in general. Members were able to assign issues to themselves based on what they wanted to work on, post updates in the comments as needed, and close them when they were done. Essentially, this allowed for maximum organization and efficient communication to see what was going on within the project at all times. 

## Update Meetings

### Meeting 1: October 28th 2015. BA3200. 5pm. All members present. 

Discussed Minimum Features to add for MVP
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
    - Review (Description, rating, UserID, DishID, Approval Rating
    - Wishlist (UserID, DishID)
    - Dish (RID, Dish name, DishID, avg rating)

### Meeting 2: October 30, 2015. BA3185. 4pm. Most members present, minus two who unfortunately weren't properly notified due to communication errors. 
- Met with TA to gather feedback on phase progress so far
- Clarified certain expectations of the phase in order to gather how best to move forward
- Provided insight on how to best organize aspects of the phase such as use of issues, backlog, etc. 

### Meeting 3: October 30, 2015. BA3175. 1PM. All members present. 
- Met up together to collaborate on the project as a whole
- Members assigned themselves tasks they wanted to take on for phase 2. 

## Burndown Chart

## Review and Retrospective
