package org.example;

import java.util.List;
import java.util.Map;

public class WorldMapRender {
    
    public void renderMap (WorldMap worldMap){
        Map<Coodinate, Entity> entityMap = worldMap.getEntityMap();
        List<Coodinate> sortedWoldMapCoordinates = worldMap.setAllWorldMapCoordinate();


        for (Coodinate coodinate: sortedWoldMapCoordinates){
            Entity value = entityMap.get(coodinate);
            if (coodinate.getX() == 0){
                System.out.println(" ");
                System.out.print(coodinate.getY()+ "   ");
            }
            if (value == null){
                System.out.print(" . ");
            }
            if (value != null){
                System.out.print(value);
            }
        }

        System.out.println(" ");
        System.out.println(" ");

        System.out.print("     ");
        for (int i = 0; i < worldMap.getWIDTH(); i++) {
            System.out.print(i +"  ");
        }
    }
}
