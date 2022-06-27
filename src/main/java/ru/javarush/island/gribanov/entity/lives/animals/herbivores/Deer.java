package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Deer extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(300.0, 50.0,20,4,50.0);
    }
    public Deer(Sex sex) {

        super("Deer", "\uD83E\uDD8C", limit.getMAX_WEIGHT()/3, limit, sex);
    }

    public Deer(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
