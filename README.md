# Java console exemplars

Clone this repository, or select **Code → Download ZIP** on GitHub and extract the folder. Open a terminal in the repository folder with a Java Development Kit (JDK 8 or newer) installed.

## Exo-Planet Colony Simulator

```sh
cd colony
javac *.java
java ColonyManager
```

Start with [ColonyManager.java](colony/ColonyManager.java). Each habitat name pairs with the population on the same line in the second file. Look for two stable sectors and a critical alert for Hydro-Gamma. Before running again, predict what happens if you change its population from 310 to 200.

## Deep Ocean Abyss Migration Tracker

From the repository folder (use `cd ..` first if you are in `colony`):

```sh
cd ocean
javac *.java
java OceanicResearchStation
```

Start with [OceanicResearchStation.java](ocean/OceanicResearchStation.java). The sample pairs species names with capture depths and uses fictional traits and containment rules. VampireSquid starts in low compression. Change its depth from 900 to 1000 meters and predict which classification it receives.

## Reading the code

Follow one line of data from its text file into an array, then into a subclass constructor. Both programs keep different subclasses in one superclass-typed ArrayList. Find the call to calculate oxygen or pressure and trace which implementation runs for each object. Compare that override with the overload that takes an extra argument.

Each method comment describes its purpose, the precondition the caller should satisfy, and the postcondition after a successful call. Recompile after editing Java code. For data-only edits, rerun the java command.
