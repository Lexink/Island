package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Boa extends Predator{
    private final static Limit limit;
    static {
        limit = new Limit(15.0, 5.0,30,1,3.0);
    }
    public Boa(Sex sex) {
        super("Boa", "\uD83D\uDC0D", limit.getMAX_WEIGHT()/5, limit, sex);
    }

    public Boa(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
