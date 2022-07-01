package ru.javarush.island.gribanov.entity.lives.animals;

import ru.javarush.island.gribanov.abstraction.entity.Eatable;
import ru.javarush.island.gribanov.abstraction.entity.Movable;
import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.map.Cell;
import ru.javarush.island.gribanov.utils.Configuration;
import ru.javarush.island.gribanov.utils.RandomGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Animal extends Organism implements Eatable, Movable {

    private final Sex sex;
    public Animal(String name, String icon, double weight, Limit limit, Sex sex) {

        super(name, icon, weight, limit);
        this.sex = sex;
    }

    @Override
    public boolean eat(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            double needToEat = getWeightToEat();
            if (!(needToEat <= 0)) {
                Configuration config = Configuration.get();
                Map<String, Integer> foodMap = config.getFoodMap(getType());
                Set<String> residents = currentCell.getResidents().keySet();
                Set<String> existingFoodTypes = new HashSet<>(foodMap.keySet());
                existingFoodTypes.retainAll(residents);

                for (String foodType : existingFoodTypes) {
                    int probably = foodMap.get(foodType);
                    Set<Organism> foods = currentCell
                            .getResidents()
                            .get(foodType);
                    if (foods.size() > 0 && RandomGenerator.get(probably)){
                        Organism food = foods
                                .iterator()
                                .next();
                        double weight = getWeight();
                        double foodWeight = food.getWeight();
                        double weightToEat = Math.min(foodWeight, needToEat);

                        setWeight(weight + weightToEat);
                        food.setWeight(food.getWeight() - weightToEat);
                        if (!food.isALive()){
                            foods.remove(food);
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        } finally {
            currentCell.getLock().unlock();
        }
    }

    private double getWeightToEat() {
        double maxEatingWeight = LIMIT.getMAX_EATING_WEIGHT();
        double hungryWeight = LIMIT.getMAX_WEIGHT() - this.getWeight();
        return Math.min(hungryWeight, maxEatingWeight);
    }

    @Override
    public void move(Cell startCell) {

    }

    @Override
    public void spawn(Cell currentCell) {

    }
}
