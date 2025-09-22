package ru;

public class Line implements Measurable {
    final Point start;
    final Point end;

    //с указанием двух Точек
    public Line(Point start, Point end) {
        //InnoKodeAI
        //может привести к NullPointerException при вызове методов getX() и getY()
        if (start == null || end == null) {
            throw new IllegalArgumentException("Points should not be null");
        }
        this.start = start;
        this.end = end;
    }

    //с указанием четырех целых чисел (x y начала и x y конца)
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    //Может вернуть длину Линии
    public double getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        //формулу расчёта гипотенузы: корень суммы квадратов катетов. Для извлечения корня можно использовать Math.sqrt
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}