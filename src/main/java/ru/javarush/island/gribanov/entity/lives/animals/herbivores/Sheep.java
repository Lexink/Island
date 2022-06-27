package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Sheep extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(70.0, 20.0,140,3,15.0);
    }
    public Sheep(Sex sex) {
        super("Sheep", "\uD83D\uDC11", limit.getMAX_WEIGHT()/2, limit, sex);
    }

    public Sheep(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
