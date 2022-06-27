package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Boar extends Herbivore{

    private final static Limit limit;
    static {
        limit = new Limit(400.0, 50.0,50,2,50.0);
    }
    public Boar(Sex sex) {
        super("Boar", " \uD83D\uDC17", limit.getMAX_WEIGHT()/3, limit, sex);
    }

    public Boar(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
