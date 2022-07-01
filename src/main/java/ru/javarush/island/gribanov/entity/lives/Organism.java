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

    protected final Limit LIMIT;

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.LIMIT = limit;

        cellWeight = weight/ LIMIT.getCOUNT_ON_CELL();
    }

    public String getType() {
        return type;
    }

    public Limit getLimit() {
        return LIMIT;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isALive() {
        return isALive;
    }

    public double getCellWeight() {
        return cellWeight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        if (weight <= 0){
            this.isALive = false;
        }
    }

    public void setALive(boolean ALive) {
        isALive = ALive;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = LIMIT.getMAX_WEIGHT();
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

    @Override
    public String toString() {
        return "Organism{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", icon='" + icon + '\'' +
                ", weight=" + weight +
                ", isALive=" + isALive +
                ", cellWeight=" + cellWeight +
                ", limit=" + LIMIT +
                '}';
    }
}
