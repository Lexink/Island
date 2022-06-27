package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Mouse extends Herbivore{
    private final static Limit limit;
    static {
        limit = new Limit(0.05, 0.0,500,1,0.01);
    }
    public Mouse(Sex sex) {
        super("Mouse", "\uD83D\uDC01", limit.getMAX_WEIGHT()/2, limit, sex);
    }

    public Mouse(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
