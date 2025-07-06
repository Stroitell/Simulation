package org.example;

import java.util.Comparator;

public class CoordinateComparator implements Comparator<Coodinate> {
    @Override
    public int compare(Coodinate o1, Coodinate o2) {
        if (o1.getY() != o2.getY()) {
            return o2.getY() - o1.getY();
        }
        return o1.getX() - o2.getX();
    }
}
