package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Rabbit extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(2.0, 0.5,150,2,0.45);
    }
    public Rabbit(Sex sex) {
        super("Rabbit", "\uD83D\uDC07", limit.getMAX_WEIGHT()/2, limit, sex);
    }

    public Rabbit(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
