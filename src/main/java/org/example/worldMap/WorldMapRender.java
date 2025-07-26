package org.example.worldMap;

import org.example.coordinate.Coordinate;
import org.example.entity.Entity;

import java.util.Map;

public class WorldMapRender {
    public static void renderMap (WorldMap worldMap){

        Map<Coordinate, Entity> entityMap = worldMap.getEntityMap();

        for (Coordinate coordinate: worldMap.setAllWorldMapCoordinate()){
            Entity value = entityMap.get(coordinate);
            printWall(coordinate);
            printValue(value);
        }
        printBottomLine(worldMap);
    }

    private static void printWall (Coordinate coordinate){
        if (coordinate.getX() == 0){
            System.out.println(" ");
            System.out.print(coordinate.getY()+ "┃ ");
        }
    }

    private static void printValue (Entity value){
        if (value != null){
            System.out.print(value);
        }
        if (value == null){
            System.out.print(" . ");
        }
    }

    private static void printBottomLine (WorldMap worldMap){
        System.out.println(" ");
        System.out.print("   ");
        for (int i = 0; i < worldMap.getWIDTH(); i++) {
            System.out.print("▁▁▁" +"");
        }
        System.out.println(" ");
        System.out.print("    ");
        for (int i = 0; i < worldMap.getWIDTH(); i++) {
            System.out.print(i +"  ");
        }

        System.out.println("");
    }

}
