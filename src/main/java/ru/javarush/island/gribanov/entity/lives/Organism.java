package ru.javarush.island.gribanov.entity.lives;

import ru.javarush.island.gribanov.abstraction.entity.Reproducible;
import ru.javarush.island.gribanov.entity.map.Cell;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducible, Serializable, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private String name;

    private final String type = this.getClass().getSimpleName();
    private long id = idCounter.incrementAndGet();
    private String icon;
    private double weight;
    private boolean isALive = true;
    private final double cellWeight;

    private Limit limit;

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limit = limit;

        cellWeight = weight/ limit.getCOUNT_ON_CELL();
    }

    public String getType() {
        return type;
    }

    public Limit getLimit() {
        return limit;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = limit.getMAX_WEIGHT();
        return clone;
    }

    public static <T extends Organism> T replicate(T original) {
        try {
            return (T) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    protected boolean safeDie(Cell target) {
        target.getLock().lock();
        try {
            if (!this.isALive) {
                return target.getResidents().get(type).remove(this);
            }
            return false;
        } finally {
            target.getLock().unlock();
        }
    }

    public String getIcon() {
        return icon;
    }
}
