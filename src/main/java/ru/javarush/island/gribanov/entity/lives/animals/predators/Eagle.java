package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Eagle extends Predator{
    private final static Limit limit;
    static {
        limit = new Limit(6.0, 1.0,20,3,1.0);
    }
    public Eagle(Sex sex)
    {
        super("Eagle", "\uD83E\uDD85", limit.getMAX_WEIGHT()/4, limit, sex);
    }

    public Eagle(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
