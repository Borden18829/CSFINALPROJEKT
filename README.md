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

## NOTE: buttons createNewEvent and gameType do not have implementations

## Back End

### After the user passes in the inputs from the UI, the person class creates an instance of the game class that runs the relevant calculations. The events to be tested are loaded by a text file that has the following format.

#### 1. Size of the Event Category.
#### 2. Name of Category
#### 3. Name of the Event
#### 4. Probability of event, repeat 3 and 4 until the size of category is reached.

### When these events are read and stored in two two-dimensional arrays (one for int probabilities and one for string names), every individual event is tested by testing if a random value out of 24,000,000 times timeScale (1 for years, 12 for months, 365 for days) and see if it is less than the probability of that event. If an event fires, a result in the proper format is added to text and added to a VBox that will be applied by the Scroll Pane passed in from the person class.

# Plan

## Week 1: Design User Interface

## Week 2: Create Super-Class for person

## Week 3: Create test implementation for conditionals, add conditionals.

## Week 4: Implement User Interface

## Week 5: Testing De-bugging

## Week 6: Any addons or presents to add polish to game + any more debugging

# Getting Started

## To install the program, pull the project from GIT, the only necessary component is the java package, which contains all of the necessary files and classes.
## To run the program, the user runs from the 'person' class. The user then inputs the desired inputs for the buttons and then press play to run the game.

# Features

## An ability to create a new profile to be stored persistently in a text file that automatically initializes with empty slots. To create a new profile, press play with an 'Empty Slot' selected and input a name. Pressing clear name sets the selected profile to 'Empty Slot' once the app is closed, the text file is updated.

## A choice between selected timeScales, from days to months to years which dictates how many times a year an event will be tested for. For example, a years game would print out: "Event Fired! Year: 3002 Event:......" , while a months game would print out: "Event Fired! Year 2005, Month: 6 ......" etc.

## A choice between set presets, given names in reference to each category of events. Each preset will increase the probabilty of a category of events from happening by 5.

## A checkbox stopOnDeath that allows the user to run the game until the character dies from an event, this leads to more events happening per run.

## A choice from 1 to 5 for the number of runs to calculate, after an event is fired or the character dies (depending on StopOnDeath) the number of current runs is incremented by one and stops when it equals numRuns.

# DEMO VIDEO
## https://youtu.be/wcVrC3sa3HA

# Team Members

## Ray Borden, Lead Designer, Head Programmer

## Chandler Dreyfuss, Head of the Division for Morale Support
