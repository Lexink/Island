package ru.javarush.island.gribanov;

import ru.javarush.island.gribanov.utils.Configuration;

public class ConsoleRunner {
    public static void main(String[] args) {
        int height = Configuration.get().getHeight();
        int width = Configuration.get().getWidth();
    }
}
