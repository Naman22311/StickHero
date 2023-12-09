# About

This is a living plan for the project that will be updated as the project evolves.

# Current classes and their attributes

## 1. GameMech Class

  ### Inner Classes:

   #### 1. Cherry

      - Attributes:
        - 'int points'

      - Methods:
        - 'int updatePoints()'
        - 'void generateCherry()'

   #### 2. Pillar

      - Attributes:
        - 'int width'

      - Methods:
        - 'int generateWidth()'

## 2. Game Class (extends GameMech)

  - Attributes:
    - 'int score'
    - 'int PowerupsCollected'
    - 'Player Player'
    - 'ArrayList<Cherry> cherries'
    - 'ArrayList<Pillar> pillars'

  - Methods:
    - 'void start()'
    - 'void restart()'
    - 'int getScore()'
    - 'void setScore(int score)'
    - 'int getPowerupsCollected()'
    - 'void setPowerupsCollected(int powerupsCollected)'
    - 'Player getPlayer()'
    - 'void setPlayer(Player player)'
    - 'ArrayList<Cherry> getCherries()'
    - 'void setCherries(ArrayList<Cherry> cherries)'
    - 'ArrayList<Pillar> getPillars()'
    - 'void setPillars(ArrayList<Pillar> pillars)'

## 3. LoadGame Class (extends SaveGame)

  - Methods:
    - 'void load()'
    - 'void DisplaySavedGames()'

## 4. Menu Class (extends SaveGame)

  - Methods:
    - 'void save()'
    - 'void exitGame()'
    - 'void resumeGame()'

## 5. Pillar Class

  - Attributes:
    - 'int width'

  - Methods:
    - 'int getPoints()'

## 6. Player Class

  - Attributes:
    - 'String name'
    - 'ScoreCard score'
    - 'Revive revive'
    - 'ArrayList<Cherry> earnedCherries'

  - Methods:
    - 'void move()'
    - 'void stretchStick()'
    - 'void collectCherry(Cherry cherry)'

## 7. Revive Class (extends Player)

  - Attributes:
    - 'int cost'

  - Methods:
    - 'int updatePoints()'
    - 'void revivePlayer(Player player)'

## 8. SaveGame Class (extends Game)

  - Attributes:
    - 'ArrayList<Game> games'

  - Methods:
    - 'void StoreBinFiles()'

## 9. ScoreUpdater Interface

  - Methods:
    - 'int updateScore()'

## 10. ScoreCard Class (implements ScoreUpdater)

  - Attributes:
    - 'int total'

  - Methods:
    - 'int updateScore()'

## 11. StickOutOfBound exception
  - Methods:
    - 'StickOutOfBoundException'
  

# Possible OOP Concepts

1. **Encapsulation:**
   - Encapsulation is demonstrated through the bundling of attributes and methods within each class, such as 'Cherry', 'Game', 'Player', etc.

2. **Inheritance:**
   - Inheritance is used in classes like 'Game' extending 'GameMech', 'Revive' extending 'Player', and 'ScoreCard' implementing the 'ScoreUpdater' interface.

3. **Polymorphism:**
   - Polymorphism is achieved through method overriding, as seen in methods like 'updatePoints()' in 'Cherry' and 'Revive' classes.

4. **Abstraction:**
   - Abstraction is applied through the use of abstract classes (e.g., 'GameMech') and interfaces (e.g., 'ScoreUpdater'), providing a level of abstraction for related classes.

5. **Composition:**
   - Composition is demonstrated by including instances of one class within another class, such as 'Player' containing instances of 'ScoreCard' and 'Revive'.

6. **Association:**
   - Association represents relationships between classes, for example, the association between 'Game' and 'GameMech', 'Player' and 'Cherry', etc.

7. **Aggregation:**
   - Aggregation is demonstrated by having ArrayLists of objects in the 'Game' class, such as 'cherries' and 'pillars'.


