package ru;
import java.util.List;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine()
    {
        super();
    }

    public ClosedPolyLine(Point... points) {
        super(points);
        ensureClosed();
    }

    // замкнуть ломанную
    private void ensureClosed() {
        List<Point> points = getPoints();
        if (points.size() >= 2 && !isClosed(points)) {
            Point first = points.get(0);
            super.addPoint(new Point(first.getX(), first.getY()));
        }
    }

    // проеврка, замкната ли ломанная (yandex)
    private boolean isClosed(List<Point> points) {
        if (points.size() < 2) return false;
        Point first = points.get(0);
        Point last = points.get(points.size() - 1);
        return first.getX() == last.getX() && first.getY() == last.getY();
    }

    @Override
    public void addPoint(Point point) {
        super.addPoint(point);
        ensureClosed();
    }

    @Override
    public void addPoint(int x, int y) {
        super.addPoint(x, y);
        ensureClosed();
    }

    @Override
    public double getLength() {
        double length = super.getLength();

        List<Point> points = getPoints();
        if (points.size() >= 2 && !isClosed(points)) {
            // Добавляем длину замыкающего отрезка
            Point first = points.get(0);
            Point last = points.get(points.size() - 1);
            int deltaX = first.getX() - last.getX();
            int deltaY = first.getY() - last.getY();
            length += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }

        return length;
    }

    @Override
    public String toString() {
        return "Замкнутая ломанная линия : " + super.toString();
    }
}