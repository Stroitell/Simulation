package org.example.actions;

import org.example.BreadthFirstSearch;
import org.example.entity.Creature;
import org.example.entity.Herbivore;
import org.example.entity.Predator;
import org.example.worldMap.WorldMap;
import org.example.worldMap.WorldMapRender;

import java.util.Iterator;

public class TurnActions extends Thread{

    private final int nextTurn = 1;
    private final int startSimulation = 2;
    private final int pauseSimulation = 4;
    private final int endSimulation = 3;

    private volatile int input;
    private int index;
    private final WorldMap worldMap;

    public TurnActions(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void run() {
        say();
        do {
            if (input == pauseSimulation){
                pauseSimulation();
            }
            if (input == nextTurn) {
                nextTurn();
            }
            while (input == startSimulation) {
                startSimulation();
            }
        } while (input != endSimulation);
    }

    public void turnActions (WorldMap worldMap){
        InitActions.spawnEntityIfNeed(worldMap, this);
        Iterator<Creature> iterator = worldMap.getCreatures().iterator();
        while (iterator.hasNext()){
            Creature creature = iterator.next();

            if (isCreatureMustDie(creature)){
                removeCreature(creature);
                iterator.remove();
                continue;
            }
            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(creature);
            breadthFirstSearch.bfs();
            if (hasPath(creature)){
                creature.makeMove();
            }
            else if (hasTarget(creature)){
                attackTarget(creature);
            }
            creature.increaseHunger();
        }
        WorldMapRender.renderMap(worldMap);
        InitActions.shuffleCreatures(worldMap);
        say();
    }

    private void nextTurn() {
        turnActions(worldMap);
        input = 0;
    }

    private void startSimulation() {
        turnActions(worldMap);
        try {
            TurnActions.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void pauseSimulation() {
        say();
        input = 0;
    }

    private boolean hasPath (Creature creature){
        return !creature.getPath().isEmpty();
    }

    private boolean hasTarget (Creature creature){
        return creature.getTargetAt() != null;
    }

    private void attackTarget(Creature creature){
        if (creature.getClass() == Predator.class){
            ((Predator) creature).attackTarget();
        }
        if (creature.getClass() == Herbivore.class){
            ((Herbivore) creature).attackTarget();
        }
    }

    private void removeCreature (Creature creature){
        if (creature instanceof Predator){
            worldMap.decrementNumberPredator();
        }   else {
            worldMap.decrementNumberHerbivore();
        }
        creature.killCreature();
    }

    private boolean isCreatureMustDie (Creature creature){
        return creature.getHunger() >= 8 | creature.getHp() <= 0;
    }

    public void incrementIndex (){
        index ++;
    }

    public void say (){
        if (input != startSimulation){

        System.out.println("""
                
                1. Просимулировать 1 ход
                2. Начать бесконечный цикл симуляции
                3. Завершить симуляцию""");
        }
        else {
            System.out.println("""
                
                1. Просимулировать 1 ход
                2. Выйти из бесконечного цикла симуляции
                3. Завершить симуляцию""");
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getEndSimulation() {
        return endSimulation;
    }

    public int getStartSimulation() {
        return startSimulation;
    }

}
