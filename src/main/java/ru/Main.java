package ru;

public class Main {
    public static void main(String[] args) {

        //Задание 4
        // создать город
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        // связи (вес)
        A.addPath(B, 5);
        A.addPath(D, 6);
        A.addPath(F, 1);
        B.addPath(C, 3);
        B.addPath(A, 5);
        B.addPath(F, 1);
        C.addPath(B, 3);
        C.addPath(D, 4);
        D.addPath(C, 4);
        D.addPath(A, 6);
        D.addPath(E, 2);
        E.addPath(D, 2);
        E.addPath(F, 2);
        F.addPath(E, 2);
        F.addPath(A, 1);
        F.addPath(B, 1);

        System.out.println("\n ** Информация о граничущих городах **");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);


        System.out.println("\n ** Далее необходимо методу путешествия объекта B передать некоторое число и вывести возвращенный город на экран: **");
        City result1 = B.travelBy(1);
        System.out.println("результат должен быть либо A, либо С");
        System.out.println("travelBy(1) из B: " + result1);

        City result2 = B.travelBy(2);
        System.out.println("результат должен быть либо B, либо D, либо F");
        System.out.println("travelBy(2) из B: " + result2);

        City result3 = B.travelBy(3);
        System.out.println("результат может быть любом городом в зависимости от порядка следования путей в списках таковых у городов, город A");
        System.out.println("travelBy(3) из B: " + result3);


    }
}

        /*Задание 3
        //Создаем точки
        Point point1 = new Point(1, 5);
        Point point2 = new Point(2, 8);
        Point point3 = new Point(5, 3);
        Point point4 = new Point(8, 9);

        //Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
        PolyLine polyLine = new PolyLine(point1, point2, point3, point4);

        System.out.println("Созданная ломаная:");
        System.out.println(polyLine);
        System.out.println();

        //Рассчитать длину Ломаной
        double polyLineLength = polyLine.getLength();
        System.out.println("Длина ломаной: " + polyLineLength);
        System.out.println();

        //Получить у Ломаной массив Линий
        Line[] lines = polyLine.getLines();
        System.out.println("Массив линий ломаной:");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Линия " + (i + 1) + ": " + lines[i]);
        }
        System.out.println();

        //Рассчитать длину массива Линий
        double linesLength = 0;
        for (Line line : lines) {
            linesLength += line.getLength();
        }
        System.out.println("Суммарная длина массива линий: " + linesLength);
        System.out.println();

        //Сравнить длину Ломаной и массива Линий: они должны совпасть
        System.out.println("Сравнение длин:");
        System.out.println("Длина ломаной: " + polyLineLength);
        System.out.println("Длина массива линий: " + linesLength);
        System.out.println("Совпадают: " + (Math.abs(polyLineLength - linesLength) < 0.0001));
        System.out.println();

        //Изменить координаты Точки {2,8} таким образом, чтобы она стала иметь значение {12,8}. Если изменения отразились в данной точке, в Ломаной и в двух Линиях массива (из пункта 3), то задача решена верно
        System.out.println("До изменения:");
        System.out.println("Точка 2: " + point2);
        System.out.println("Ломаная: " + polyLine);
        System.out.println("Линия 1: " + lines[0]);
        System.out.println("Линия 2: " + lines[1]);
        System.out.println();

        //Изменить координаты Точки {2,8} таким образом, чтобы она стала иметь значение {12,8}.
        point2.setX(12);
        point2.setY(8);

        System.out.println("После изменения точки {2,8} на {12,8}:");
        System.out.println("Точка 2: " + point2);
        System.out.println("Ломаная: " + polyLine);
        System.out.println("Линия 1: " + lines[0]); //Должна измениться тот же объект точки
        System.out.println("Линия 2: " + lines[1]); //Должна измениться тот же объект точки
        System.out.println();
    }

}*/


        /*Задание 2
        // Создаем линии
        //Линия 1 начиналась в Точке  {1;3} и кончалась в Точке {5;8}.
        Line line1 = new Line(1, 3, 5, 8);
        //Линия 2 начиналась в Точке {10;11} и кончалась в Точке {15;19}
        Line line2 = new Line(10, 11, 15, 19);
        //Линия 3 начиналась в Точке конца Линии 1, а кончалась в Точке начала Линии 2
        Line line3 = new Line(line1.getEnd(), line2.getStart());

        //Выведите текстовое представление Линии 3 на экран
        System.out.println("Линия 3 до изменения: " + line3);

        // Измените координаты точек начала и конца Линии 3 таким образом, чтобы изменились все три объекта Линии
        line3.getStart().setX(20);  //изменит конец line1
        line3.getStart().setY(25);  //изменит конец line1
        line3.getEnd().setX(30);    //изменит начало line2
        line3.getEnd().setY(35);    //изменит начало line2

        //Выведите текстовое представление Линии 3 на экран после изменения её состояния
        System.out.println("Линия 3 после изменения: " + line3);

        //Рассчитайте суммарную длину всех трех линий и выведите её на экран
        double totalLength = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.println("Суммарная длина всех линий: " + totalLength); */

     /*   //Задание 1
        // Создаем три объекта точки
        Point point = new Point(1, 3);
        Point point2 = new Point(1, 3);
        Point point3 = new Point(5, 8);

        // Выводим текстовое представление точек
        System.out.println("Текстовое представление этих точек:");
        System.out.println("Точка 1: " + point);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        System.out.println("\nРезультаты сравнения точек между собой:");
        System.out.println("Точка 1 == Точка 2: " + (point == point2));
        System.out.println("Точка 1 == Точка 3: " + (point == point3));
        System.out.println("Точка 2 == Точка 3: " + (point2 == point3));*/