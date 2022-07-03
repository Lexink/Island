package ru.javarush.island.gribanov;

import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.utils.Configuration;

public class Tester {
    public static void main(String[] args) {
        Configuration configuration = Configuration.get();
        Organism[] organisms = configuration.getPrototypes();
        for (Organism animal : organisms) {
            System.out.println("[33m" + animal.toString());
        }
//        MapCreator creator = new MapCreator();
//        GameMap gameMap = creator.createMap();
//        ConsoleView view = new ConsoleView(gameMap);
//        view.showMap();
//        view.showStatistics();
    }
}
