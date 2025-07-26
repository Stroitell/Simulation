package org.example.coordinate;

import java.util.Objects;

public class Coordinate {
    private final static Coordinate DEFAULT_COORDINATE = new Coordinate(-1, -1);
    private final int X;
    private final int Y;
    private Coordinate link;

    public Coordinate(int x, int y, Coordinate link){
        X = x;
        Y = y;
        this.link = link;
    }
    public Coordinate(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate coordinate = (Coordinate) o;
        return X == coordinate.X && Y == coordinate.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return X + ";" + Y;
    }

    public Coordinate getLink() {
        return link;
    }

    public void setLink(Coordinate link) {
        this.link = link;
    }

    public static Coordinate getDefaultCoordinate() {
        return DEFAULT_COORDINATE;
    }
}
