# Java console exemplars

## Run Java in your browser

1. [Open the Java workspace](https://codespaces.new/mcheering/java-console-exemplars?quickstart=1), sign in to GitHub, and create or resume your codespace.
2. In the Explorer, open `colony/ColonyManager.java` or `ocean/OceanicResearchStation.java`. Read the Javadoc above a method, edit the code or a companion text file, and save.
3. Choose **Terminal → New Terminal**. From the repository folder run `./run colony` or `./run ocean`. Each command compiles the current source and runs it with its sample data.

Try changing the upper oxygen limit in `ColonyManager.java` from `250.0` to `400.0`. Predict which sector changes status, save, and run `./run colony` again.

## More ways to run the examples

**[Open the two editable CodePen labs](https://mcheering.github.io/java-console-exemplars/)** to experiment with JavaScript versions in your browser. Each lab includes a prediction to test.

To run the Java versions locally, clone this repository, or select **Code → Download ZIP** on GitHub and extract the folder. Open a terminal in the repository folder with a Java Development Kit (JDK 8 or newer) installed.

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
