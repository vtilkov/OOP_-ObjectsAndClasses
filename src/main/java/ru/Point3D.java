package ru;

/*Практика ООП. Полиморфизм #1. Трехмерная точка
        Дан класс,
        описывающий точку координат:
        class Point{
            int x,y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Создайте такой подкласс (Point3D) класса Point, который будет иметь не две, а три координаты на плоскости: X,Y,Z. Вместо класса приведенного в задании можно использовать сделанный ранее самостоятельно класс Точки.*/

public class Point3D extends Point { //унаследовали

    private int z; //третья точка

    public Point3D(int x, int y, int z) { //конструктор
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + z +
                '}';
    }
}