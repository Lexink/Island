package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Bear extends Predator{
    private final static Limit limit;
    static {
        limit = new Limit(500.0, 100.0,5,2,80.0);
    }
    public Bear(Sex sex)
    {
        super("Bear", "\uD83D\uDC3B", limit.getMAX_WEIGHT()/5, limit, sex);
    }

    public Bear(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
