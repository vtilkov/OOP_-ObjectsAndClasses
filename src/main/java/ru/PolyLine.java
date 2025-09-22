package ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    //конструктор без параметра
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    //с начальным набором точек
    public PolyLine(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    //добавить точки в ломанную
    public void addPoint(Point point){
        //InnoKodAI
        //обработка на NullPointerException
        if (point != null) {
            points.add(point);
        }
    }

    public void addPoint(int x, int y){
        points.add(new Point(x, y)); //пред ипсрвление с точками)
    }

    // Получить у Ломаной массив Линий
    public Line[] getLines() {
        if (points.size() < 2) {
            return new Line[0];
        }

        Line[] lines = new Line[points.size() - 1];
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            if (start != null && end != null) {
                lines[i] = new Line(start, end);
            } else {
                //(InnoKodAI)
                // Методы getPoint, getLines и getLength могут выбрасывать IndexOutOfBoundsException, если индекс выходит за границы списка
                throw new IllegalArgumentException("Points in the list should not be null");
            }
        }
        return lines;
    }

    //Рассчитать длину Ломаной
    public double getLength() {
        if (points.size() < 2) {
            return 0;
        }

        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            int deltaX = end.getX() - start.getX();
            int deltaY = end.getY() - start.getY();
            length += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
        return length;
    }

    //Получить точки по индексу
    public Point getPoint(int index) {
        if (index >= 0 && index < points.size()) {
            return points.get(index);
        }
        return null;
    }

    //Подсказка: текстовое представление объекта лучше реализовывать в переопределенном методе toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //Практика ООП. Полиморфизм #2. Замкнутая ломаная
    public List<Point> getPoints() {
        return points;
    }
}