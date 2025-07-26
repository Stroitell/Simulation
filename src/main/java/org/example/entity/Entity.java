package org.example.entity;

import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

public abstract class Entity {
    private String sprite;
    private Coordinate coordinate;
    private final WorldMap worldMap;


    public Entity(String sprite, Coordinate coordinate, WorldMap worldMap) {
        this.coordinate = coordinate;
        this.sprite = sprite;
        this.worldMap = worldMap;
    }


    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    @Override
    public String toString() {
        return sprite + "";
    }
}
