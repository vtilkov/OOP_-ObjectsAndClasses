package ru;

//нужно создать адаптер, который позволит использовать строку как объект, реализующий интерфейс Measurable
//адаптируем класс String к интерфейсу Measurable

public class StringAdapter implements Measurable {

    private final String string;

    public StringAdapter(String string) {
        if (string == null) throw new IllegalArgumentException("Строка не может быть пустой");
        this.string = string;
    }

    @Override
    public double getLength() {
        return string.length(); //используем  метод length
    }

    @Override
    public String toString() {
        return "StringAdapter{" +
                "string='" + string + '\'' +
                ", length=" + string.length() +
                '}';
    }

    public String getString() {
        return string; //получить исходную строку
    }
}
