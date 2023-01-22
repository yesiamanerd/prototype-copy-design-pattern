package org.example;

public class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Copy constructor
    public Line(Line line) {
        this(new Point(line.start), new Point(line.end));
    }

    // no args constructor
    public Line() {
    }

    public Line deepCopy() {
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
