package org.example;

import java.lang.reflect.Field;

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point(Point point)
    {
        this.x = point.x;
        this.y = point.y;
    }

    // no args constructor
    public Point()
    {
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    // Copy constructor
    public Line(Line line)
    {
        this(new Point(line.start), new Point(line.end));
    }

    // no args constructor
    public Line()
    {
    }

    public Line deepCopy()
    {
        return new Line(this);
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Main
{
    public static void main(String[] args) throws Exception {
        System.out.println("Using Copy Constructor");
        Line line = new Line(new Point(1, 1), new Point(10, 10));

        System.out.println("\tLine 1: " + line);

        Line line2 = line.deepCopy();

        line2.start.x = 2;
        line2.start.y = 2;
        line2.end.x = 20;
        line2.end.y = 20;

        System.out.println("\tLine 2: " + line2);

        System.out.println("Using Reflection");

        Line line3 = (Line) deepCopy(line);

        line3.start.x = 3;
        line3.start.y = 3;
        line3.end.x = 30;
        line3.end.y = 30;

        System.out.println("\tLine 3: " + line3);
    }

    public static Object deepCopy(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Object copy = clazz.getConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            field.set(copy, value);
        }
        return copy;
    }

}