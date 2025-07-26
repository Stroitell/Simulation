package org.example;

import org.example.coordinate.Coordinate;
import org.example.entity.Creature;
import org.example.worldMap.WorldMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    private final Creature creature;
    private final WorldMap worldMap;

    public BreadthFirstSearch(Creature creature) {
        this.creature = creature;
        this.worldMap = creature.getWorldMap();
    }

    private final Queue<Coordinate> pendingReview = new LinkedList<>();
    private final List<Coordinate> checkedCoordinate = new LinkedList<>();

    public void bfs() {
        resetBfs();
        findTarget();
        makePath();
    }

    public void resetBfs() {
        creature.getPath().clear();
        checkedCoordinate.clear();
        pendingReview.clear();
    }

    public void makePath() {
        if (creature.getTargetAt() != null){

            creature.getPath().add(checkedCoordinate.getLast());
            while (creature.getPath().getLast().getLink() != null){
                creature.getPath().add(creature.getPath().getLast().getLink());
            }
            creature.getPath().removeLast();
            creature.reversedPath();
        }   else {
            creature.getPath().clear();
        }
    }

    public void findTarget() {
        pendingReview.add(creature.getCoordinate());
        while (true){
            if (pendingReview.isEmpty()){
                break;
            }
            if (isNeighbourTarget(pendingReview.remove())){
                break;
            }
        }
    }

    public boolean isNeighbourTarget(Coordinate coordinate) {
        List<Coordinate> stepList = makeNeighborList(coordinate);
        for (Coordinate neighbour: stepList){
            if (worldMap.getEntityMap().get(neighbour) != null){
                if (worldMap.getEntityMap().get(neighbour).getClass().equals(creature.getTarget())){
                    creature.setTargetAt(neighbour);
                    checkedCoordinate.add(coordinate);
                    return true;
                }
            }
        }
        checkedCoordinate.add(coordinate);
        return false;
    }

    public List<Coordinate> makeNeighborList(Coordinate coordinate){
        List<Coordinate> neighborList = new ArrayList<>();
        int []x = {coordinate.getX()-1, coordinate.getX()+1};
        int []y = {coordinate.getY()-1, coordinate.getY()+1};
        for (int x2: x){
            Coordinate newCoordinate = new Coordinate(x2, coordinate.getY(), coordinate);
            addToPendingReview(neighborList, newCoordinate);
        }
        for (int y2: y){
            Coordinate newCoordinate = new Coordinate(coordinate.getX(), y2, coordinate);
            addToPendingReview(neighborList, newCoordinate);
        }
        return neighborList;
    }

    private void addToPendingReview(List<Coordinate> neighborList, Coordinate newCoordinate) {
        if (isCoordinateAvailable(newCoordinate) & !checkedCoordinate.contains(newCoordinate) & !pendingReview.contains(newCoordinate)){
            neighborList.add(newCoordinate);
            if (worldMap.getEntityMap().get(newCoordinate) == null){
                pendingReview.add(newCoordinate);
            }
        }
    }

    private boolean isCoordinateAvailable(Coordinate coordinate) {
        if (coordinate.getX() >= 0 & coordinate.getX() < worldMap.getWIDTH()){
            return coordinate.getY() >= 0 & coordinate.getY() < worldMap.getHEIGHT();
        }
        return false;
    }

}
