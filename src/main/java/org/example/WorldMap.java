package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WorldMap {

    private final int [] SIZE_MAP = {4, 4};
    private final int WIDTH = SIZE_MAP[0];
    private final int HEIGHT = SIZE_MAP[1];

    private final int COUNT_GRASS = 2;

    private Map<Coodinate, Entity> entityMap = new HashMap<>();
    private List<Coodinate> availableCoordinates = setAllWorldMapCoordinate();


    public List<Coodinate> setAllWorldMapCoordinate (){
        List<Coodinate> allWorldMapCoordinate = new ArrayList<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                allWorldMapCoordinate.add(new Coodinate(x, y));
                Collections.sort(allWorldMapCoordinate, new CoordinateComparator());
            }
        }
        return allWorldMapCoordinate;
    }


    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public int getCountGrass() {
        return COUNT_GRASS;
    }
    public List<Coodinate> getAvailableCoordinates() {
        return availableCoordinates;
    }
    public Map<Coodinate, Entity> getEntityMap() {
        return entityMap;
    }
}
