# To compile code: 
Open with Inteliij IDEA as a java fx project , then go to src\main\java\com\ap\stickman\StickApplication.java and run it.

# Design Patterns Used 

## Memento and Singleton Patterns in Game Development

### Memento Pattern

The Memento Pattern is implemented through the `gameSerializable` and `gameDeserializable` methods. The `gameSerializable` method allows you to save the state of a `Game` object when the "Save Game" button is clicked. This enables the `GameObject` to be serialized and stored. Later, the game can be deserialized, and the `Game` object can be restored to its previous state when the "Load" button is clicked.

### Singleton Pattern

The Singleton Pattern is applied to the `getInstance` method of the `GameRegistry` class, ensuring that there is only one instance of the `GameRegistry` class. Subsequently, the `getInstance()` method is used to retrieve that singular instance and its array list of game objects.

These design patterns contribute to a more robust and scalable game development framework, providing efficient state management and a streamlined approach to accessing essential game registry information.


# JUnit Testing 

We have done JUnit testing of three functions , i.e. function that is generating stick , function that is generating pillars and the player class initialisation. They are available in src\test\java\com\ap\stickman folder.


# Aditional notes

All assets used are in Assets folder , game files in src\main\java\com\ap .


