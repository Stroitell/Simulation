package org.example;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap();

        WorldMapRender renderer = new WorldMapRender();

        EntitySpawner spawner = new EntitySpawner();
        EntitySpawner.spawnGrass(worldMap);
        spawner.spawnEntity(worldMap);
        spawner.spawnGrass(worldMap);
        renderer.renderMap(worldMap);

    }
}