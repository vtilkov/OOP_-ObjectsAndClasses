package ru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class City {
    private final String name; //Имя
    private final List<Path> paths; //путь

    // Вложенный класс для представления пути
    private static class Path {
        private final City destination; //путь
        private final int cost; //цена

        Path(City destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return destination.name + ": " + cost;
        }
    }

    // Конструкторы
    public City(String name) {
        this(name, new ArrayList<>());
    }

    public City(String name, List<Path> paths) {
        this.name = name;
        this.paths = paths != null ? new ArrayList<>(paths) : new ArrayList<>();
    }

    // Добавление пути с указанием города и стоимости
    public void addPath(City destination, int cost) {
        if (destination != null) {
            paths.add(new Path(destination, cost));
        }
    }

    // Добавление готового пути
    public void addPath(Path path) {
        if (path != null && path.destination != null) {
            paths.add(path);
        }
    }

    // Метод путешествия
    /*Город должен иметь метод путешествия (travelBy).
    Такой метод принимает число n, который обозначает количество переходов.
    Проще говоря, в текущем списке путей берется первый город,
    из его списка путей так же берется первый город,
    из списка путей которого в свою очередь берется город и так далее до тех пор,
    пока либо количество городов не станет равным n,
    либо у текущего города не окажется путей.
    Метод возвращает последний Город пути или null если мы попали в тупик*/
    public City travelBy(int steps) {
        if (steps <= 0) { //принимает число n >0
            return this;
        }

        City currentCity = this; //полетели по городам
        for (int i = 0; i < steps; i++) {
            if (currentCity.paths.isEmpty()) { //нет городов
                return null; // Тупик
            }

            // Берем первый путь из списка
            Path firstPath = currentCity.paths.get(0);
            currentCity = firstPath.destination;

            // Если достигли нужного количества переходов
            if (i == steps - 1) {
                return currentCity;
            }
        }

        return currentCity;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", paths=" + paths +
                '}';
    }
}