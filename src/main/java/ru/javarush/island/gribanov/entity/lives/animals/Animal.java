package ru.javarush.island.gribanov.entity.lives.animals;

import ru.javarush.island.gribanov.abstraction.entity.Eatable;
import ru.javarush.island.gribanov.abstraction.entity.Movable;
import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.map.Cell;

public abstract class Animal extends Organism implements Eatable, Movable {

    private final Sex sex;
    public Animal(String name, String icon, double weight, Limit limit, Sex sex) {

        super(name, icon, weight, limit);
        this.sex = sex;
    }

    @Override
    public void eat(Cell currentCell) {

    }

    @Override
    public void move(Cell startCell) {

    }

    @Override
    public void spawn(Cell currentCell) {

    }
}
