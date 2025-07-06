package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Coodinate {
    private final int X;
    private final int Y;

    public Coodinate(int x, int y) {
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
        Coodinate coodinate = (Coodinate) o;
        return X == coodinate.X && Y == coodinate.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return X + ";" + Y;
    }
}
