package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Wolf extends Predator{
    private final static Limit limit;
    static {
        limit = new Limit(50.0, 10.0,30,3,8.0);
    }
    public Wolf(Sex sex) {
        super("Wolf", "\uD83D\uDC3A", limit.getMAX_WEIGHT()/10, limit, sex);
    }

    public Wolf(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
