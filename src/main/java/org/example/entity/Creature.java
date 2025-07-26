package org.example.entity;

import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

import java.util.LinkedList;
import java.util.List;

public abstract class Creature extends Entity{

    private final int speed;
    private int hp;
    private  int hunger;

    private Coordinate targetAt;
    private final Class<? extends Entity> target;

    private List<Coordinate> path = new LinkedList<>();

    public <T extends Entity> Creature(String sprite, Coordinate coordinate, WorldMap worldMap, int hp, int speed, Class<T> target, int hunger) {
        super(sprite, coordinate, worldMap);
        this.hp = hp;
        this.speed = speed;
        this.target = target;
        this.hunger = hunger;
    }

    public void makeMove (){
        getWorldMap().getEmptyCoordinates().add(getCoordinate());
        getWorldMap().getEntityMap().remove(getCoordinate());

        Coordinate coordinate;
        if (path.size() >= speed){
            coordinate = path.get(speed-1);
        }   else {
            coordinate = path.getLast();
        }
        coordinate.setLink(null);
        setCoordinate(coordinate);
        getWorldMap().getEntityMap().put(getCoordinate(), this);

        getWorldMap().getEmptyCoordinates().remove(getCoordinate());

    }

    public void reduceHunger (){
        hunger = hunger - 4;
    }

    public void increaseHunger (){
        hunger = hunger + 2;
    }

    public void killTarget(){
        getWorldMap().getEntityMap().remove(getTargetAt());
        getWorldMap().getEmptyCoordinates().add(getTargetAt());
        setTargetAt(null);
    }

    public void killCreature(){
        getWorldMap().getEntityMap().remove(getCoordinate());
        getWorldMap().getEmptyCoordinates().add(getCoordinate());

    }



    public Class<? extends Entity> getTarget() {
        return target;
    }

    public Coordinate getTargetAt() {
        return targetAt;
    }

    public void setTargetAt(Coordinate targetAt) {
        this.targetAt = targetAt;
    }

    public List<Coordinate> getPath() {
        return path;
    }

    public void reversedPath() {
        this.path = this.path.reversed();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHunger() {
        return hunger;
    }
}
