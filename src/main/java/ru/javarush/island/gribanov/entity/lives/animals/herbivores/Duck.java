package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.map.Cell;

public class Duck extends Herbivore{

    private final static Limit limit;
    static {
        limit = new Limit(1.0, 0,200,4,0.15);
    }
    public Duck(Sex sex) {

        super("Duck", "\uD83E\uDD86", limit.getMAX_WEIGHT()/5, limit, sex);
    }

    public Duck(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }

}
