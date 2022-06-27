package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Horse extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(400.0, 50,20,4,60.0);
    }
    public Horse(Sex sex) {
        super("Horse", "\uD83D\uDC0E", limit.getMAX_WEIGHT()/4, limit, sex);
    }

    public Horse(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
