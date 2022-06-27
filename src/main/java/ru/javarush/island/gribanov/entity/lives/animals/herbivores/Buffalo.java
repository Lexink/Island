package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Buffalo extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(700.0, 50.0,10,3,100.0);
    }
    public Buffalo(Sex sex) {
        super("Buffalo", "\uD83D\uDC03", limit.getMAX_WEIGHT()/7,limit, sex);
    }

    public Buffalo(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
