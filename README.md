# CSFINALPROJEKT - J.A.N.K

## What is JANK?

### J.A.N.K. - or Just Awesome Nonsensical Knowledge- is a simulation design to give user feedback based on the time it takes for an unlikely event to happen, and the event in question

## Why JANK?

### While it is easy to say that your chance of getting eaten by a shark is one in a million, people are still terrified by sharks. On the other hand, you still have people drinking and driving despite the high probability of a crash, we wanted to express this relationship.

## How JANK?

### The game should be presented as an application with a user friendly interface that allows the user to set their name, habits, and the amount of times they want to run their simulation. Once run, the program will test for random values for each event, displaying the results of each game. The game will also test the probability of them dying from each event. 

# Deliverables

## Front End

### The front end consists of a user interface class that is loaded from the backend via. FXML file made through SceneBuilder. This scene consists of buttons: play, profile, preset, stopOnDeath, timeScale, numRuns which affect the variables that are used in the back end. All of the implementations of these buttons are handled in the Person class that inherits the User Interface class. Once the classes in the backend finish their calculations the results are printed onto a scroll pane in original scene.

## Back End

### After the user passes in the inputs from the UI, the person class creates an instance of the game class that runs the relevant calculations. The events to be tested are loaded by a text file that has the following format.

#### 1. Size of the Event Category.
#### 2. Name of Category
#### 3. Name of the Event
#### 4. Probability of event, repeat 3 and 4 until the size of category is reached.
