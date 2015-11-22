## Process
## Organization
For the third phase, we decided to organize ourselves in a scrum fashion. We continued to rotate the role of 'Scrum Master' throughout the group, which created an easier method for organizing group meetings and keeping track of app development information. This was done by setting up times for group meetings, online and in person, and making note of important application designs, such as how a certain feature works or how a part of the backend interacts with the frontend.

We compared the features that we finished in the second phase to the final product described in the MVP and drafted a list of what still need to be implemented. From there, we decided on the task size of each feature in the list, prioritized the features and assigned ourselves to the tasks we were comfortable with. We used Git issues to document the task size and priorities, Google Docs to draft the feature implementation list, Slack to oranize our meetings and scrum artifacts - ie. burndown charts, meeting logs, etc. - to further organize ourselves.

## Artifacts
### Update Meetings
#### Meeting #1
Date: November 18, 2015. Location: Online - Slack. Time: 4:00pm-5:00pm. Minutes Taken: 60 mins. Members Present: All -  Daniel, Felicia, Jake, Josh, Matt, Simon.

This meeting focused on filtering out the features of the app that was already accomplished in phase 2, and finding the features that needed to be implemented to reach the MVP. The features below are what needed to be implemented:

#####Frontend
###### General Template
- Navigation bar at the bottom
- GUI - graphics
- Main menu
- Slide gallery 

###### Login Screen 
- Sign up and forgot password functions

######Add Review 
- Add Photo
- Press star or circle for rating
- Food Info
- Picture slide to info
- Add wishlist button 

######Display Info
- Ate it button

######Search App
- Search bar that searches for the most relevant object
- Search via restaurant, categories, etc. list

######Wishlist
- Display more into 
- Add ate it button

######Spent On Dishes 
- Implement list that shows the amount via restaurant 
- When restaurant is clicked on show list of dish totals spent at that restaurant 
- Include picture of food if picture exists

######All Restaurant
- Display a list of all available restaurants
- Clicking on one element will go to All Dishes

######All Dishes
- Display a list of all available dishes in one restaurant

#####Backend
######Dish table 
- Table creation and insert dishes fix
- Add picture value
- Add spent on value
- Add category value

######Review 
- Unique values fix
- Add picture value

######API
- Location services
- Photo table

######User
- Add email attribute

######Restaurant
- Add location value
- Add spent on value

######Wishlist
- Add picture value

Frontend design and backend to frontend functionality was prioritized as the highest, with backend bug fixes, spent feature and picture capabilities as medium priority and fluff features, such as the forgot password function and location services, as the lowest. Teammates assigned themselves to tasks they wanted to undertake.

#### Meeting #2
Date: November 20, 2015. Location: Online - Slack. Time: 2:00pm-3:00pm. Minutes Taken: 60 mins. Members Present: All -  Daniel, Felicia, Jake, Josh, Matt, Simon.

Everyone updated the group on the progress each member has made on their choosen tasks. From there, the group was able to gauge where the application was at, in terms of how close it is to the MVP, and adjust accordingly. More emphasis was placed on the frontend GUI in order to have a functional app, and once the frontend was complete, backend adjustments and bug fixes were to be done. Progress on the application was more or less on track.

#### Meeting #3
Date: November 22, 2015. Location: Bahen 3175 and Online (Slack). Time: 1:00pm-9:00pm. Minutes Taken: 480 mins. Members Present: All - Daniel, Felicia, Jake, Josh, Matt, Simon.

Finalization of the app was done in this meeting. A restructure of what was needed in the application and what wasn't needed was re-evaluated. Certain parts of the original MVP application was scrapped and GUI/UX was re-adjusted to reflect the changes. Backend work was completed during this time and implemented to flow with the frontend. Testing and bug fixes were also done during this time. 

### Burndown Chart

### Diagrams

## Rationale
The rationale for most of our decisions came from time constraints and creating the most fucntional app possible. Features that weren't integral to the functionality of the application were scrapped to further develop other important features. For example, the time spent on trying to develop a function that would send the user an email for a forgotten password could be better spent on creating a function that would give any information in the database based on its parameters. In that sense the application would benefit overall from the latter function, than the first.
