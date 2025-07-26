package org.example.coordinate;

import java.util.Comparator;

public class CoordinateComparator implements Comparator<Coordinate> {
    @Override
    public int compare(Coordinate o1, Coordinate o2) {
        if (o1.getY() != o2.getY()) {
            return o2.getY() - o1.getY();
        }
        return o1.getX() - o2.getX();
    }
}
