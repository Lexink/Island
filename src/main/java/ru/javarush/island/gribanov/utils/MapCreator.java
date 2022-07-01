package ru.javarush.island.gribanov.utils;

import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.map.Cell;
import ru.javarush.island.gribanov.entity.map.GameMap;
import ru.javarush.island.gribanov.exception.IslandException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapCreator {

    private final Configuration CONFIG = Configuration.get();
    public GameMap createMap(){
        GameMap gameMap = new GameMap(CONFIG.getHeight(), CONFIG.getWidth());
        Cell[][] cells = gameMap.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                cells[i][j] = new Cell(i, j,randomFillResidents());
            }
        }
        return gameMap;
    }

    private Map<String, Set<Organism>> randomFillResidents(){
        Map<String, Set<Organism>> residents = new HashMap<>();
        Organism[] prototypes = CONFIG.getPrototypes();
        for (Organism prototype : prototypes) {
            String typeName = prototype.getType();
            residents.put(typeName, createOrganisms(typeName));
        }
        return residents;
    }

    private Set<Organism> createOrganisms(String type){
        Set<Organism> organisms = new HashSet<>();
        Organism organism = null;
        for (Organism prototype : CONFIG.getPrototypes()) {
            if (type.equalsIgnoreCase(prototype.getClass().getSimpleName())){
                organism = prototype;
            }
        }
        if (organism != null){
            int organismQty = organism
                    .getLimit()
                    .getCOUNT_ON_CELL();
            int qtyLimit = "Plant".equalsIgnoreCase(type) ? organismQty : organismQty/2;
            for (int i = 0; i < RandomGenerator.random(0,qtyLimit); i++) {
                organisms.add(Organism.replicate(organism));
            }
            return organisms;
        } else {
            throw new IslandException("Prototype not found");
        }
    }
}
