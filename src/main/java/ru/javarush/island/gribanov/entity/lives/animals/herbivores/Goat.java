package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Goat extends Herbivore{

    private final static Limit limit;
    static {
        limit = new Limit(60.0, 10,140,3,10.0);
    }

    public Goat(Sex sex) {
        super("Goat", "\uD83D\uDC10", limit.getMAX_WEIGHT()/3, limit, sex);
    }

    public Goat(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
