package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Caterpillar extends Herbivore{

    private final static Limit limit;
    static {
        limit = new Limit(0.01, 0,1000,0,0.0);
    }

    public Caterpillar(Sex sex) {
        super("Caterpillar", "\uD83D\uDC1B", limit.getMAX_WEIGHT(), limit, sex);
    }

    public Caterpillar(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
