package ru.javarush.island.gribanov.constants;

import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.lives.animals.herbivores.*;
import ru.javarush.island.gribanov.entity.lives.animals.predators.*;


public enum OrganismTypes {
    BOAR(Boar.class),
    BUFFALO(Buffalo.class),
    CATERPILLAR(Caterpillar.class),
    DEER(Deer.class),
    DUCK(Duck.class),
    GOAT(Goat.class),
    HORSE(Horse.class),
    MOUSE(Mouse.class),
    RABBIT(Rabbit.class),
    SHEEP(Sheep.class),
    BEAR(Bear.class),
    BOA(Boa.class),
    EAGLE(Eagle.class),
    FOX(Fox.class),
    WOLF(Wolf.class);

    private Class<? extends Organism> clazz;
    OrganismTypes (Class<? extends Organism> clazz){
        this.clazz = clazz;
    }

    public Class<? extends Organism> getClazz() {
        return clazz;
    }
}
