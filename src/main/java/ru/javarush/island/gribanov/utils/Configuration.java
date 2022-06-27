package ru.javarush.island.gribanov.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.javarush.island.gribanov.constants.OrganismTypes;
import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.animals.Animal;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Configuration implements Serializable {
    public static final String YAML_FILE = "start_configuration.yaml";

    private static volatile Configuration CONFIG;

    public static Configuration get() {
        Configuration config = CONFIG;
        if (Objects.isNull(config)) {
            synchronized (Configuration.class) {
                if (Objects.isNull(config = CONFIG)) {
                    config = CONFIG = new Configuration();
                }
            }
        }
        return config;
    }
    @JsonIgnore
    private Animal[] prototypes;
    private int period;
    private int height;
    private int width;
    private Parameters[] parameters;

    private final Map<String, Map<String, Integer>> probabilityFoodMap = new LinkedHashMap<>();

    public Map<String, Integer> getFoodMap(String keyName) {
        this.probabilityFoodMap.putIfAbsent(keyName, new LinkedHashMap<>());
        return probabilityFoodMap.get(keyName);
    }

    private Configuration() {
        loadFromDefault();
        updateFromYaml();
    }

    private void loadFromDefault() {
        period = DefaultConfig.PERIOD;
        height = DefaultConfig.ROWS;
        width = DefaultConfig.COLS;
        parameters = DefaultConfig.parameters;
        for (int i = 0, n = DefaultConfig.names.length; i < n; i++) {
            String key = DefaultConfig.names[i];
            this.probabilityFoodMap.putIfAbsent(key, new LinkedHashMap<>());
            for (int j = 0; j < n; j++) {
                int ratio = DefaultConfig.setProbablyTable[i][j];
                if (ratio > 0) {
                    this.probabilityFoodMap.get(key).put(DefaultConfig.names[j], ratio);
                }
            }
        }
    }

    private void updateFromYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ObjectReader readerForUpdating = mapper.readerForUpdating(this);
        URL resource = Configuration.class.getClassLoader().getResource(YAML_FILE);
        if (Objects.nonNull(resource)) {
            try {
                readerForUpdating.readValue(resource.openStream());
                this.prototypes = createPrototypes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getPeriod() {
        return period;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Animal[] getPrototypes() {
        return prototypes;
    }

    private Animal[] createPrototypes() {
        Animal[] animals = new Animal[OrganismTypes.values().length];
        int index = 0;
        for (OrganismTypes type : OrganismTypes.values()) {
            for (Parameters parameter : parameters) {
                if (type.getClazz().getSimpleName().equals(parameter.getName())){
                    String name = parameter.getName();
                    String icon = parameter.getIcon();

                    Limit limit = new Limit(
                            parameter.getMaxWeight(),
                            parameter.getMinWeight(),
                            parameter.getCount(),
                            parameter.getSpeed(),
                            parameter.getFoodWeight()
                    );
                    double weight = limit.getMAX_WEIGHT()/parameter.getStartWeightDivisor();
                    animals[index++] = generatePrototype(type.getClazz(), name, icon, weight, limit);
                }
            }
        }
        return animals;
    }

    private Animal generatePrototype(Class<?> type, String name, String icon, double weight, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, double.class, Limit.class, Sex.class);
            return (Animal) constructor.newInstance(name, icon, weight, limit, Sex.FEMALE);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("not found Entity constructor", e);
        }
    }
}
