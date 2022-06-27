package ru.javarush.island.gribanov.entity.map;

import ru.javarush.island.gribanov.entity.lives.Organism;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private int column;
    private int row;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    private final Map<Type, Set<Organism>> residents;
    private List<Cell> nextCells;

    public Cell(int column, int row, Map<Type, Set<Organism>> residents) {
        this.column = column;
        this.row = row;
        this.residents = residents;
    }

    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }
}
