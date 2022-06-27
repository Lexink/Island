package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Fox extends Predator{
    private final static Limit limit;
    static {
        limit = new Limit(8.0, 2.0,30,2,2.0);
    }
    public Fox(Sex sex)
    {
        super("Fox", "\uD83E\uDD8A", limit.getMAX_WEIGHT()/4, limit, sex);
    }

    public Fox(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
