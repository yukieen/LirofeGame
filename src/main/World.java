/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author lpczclt
 */
public class World {
    public final int[][] cells;
    
    public World(int[][] cells){
        this.cells = cells;
    }
    
    public World generate(){
         int[][] newCells = new int[cells.length][cells[0].length];

         for(int y=0; y<cells.length; y++){
             for(int x=0; x<cells[y].length; x++){
                 int alive = countAliveCell(x,y);
                 if(alive==2){
                     newCells[y][x] = cells[y][x];
                 }else if(alive==3){
                     newCells[y][x] = 1;
                 }else{
                     newCells[y][x] = 0;
                 }
             }
         }
         return new World(newCells);
     }
    
    private int countAliveCell(int x, int y){
        int alive = 0;
        
        for(int i=y-1; i<=y+1; i++){
            for(int j=x-1; j<=x+1; j++){
                //端っこ
                if(i<0 || j<0 || i >= cells.length || j >= cells[i].length){
                    continue;
                }
                //自分自身
                if(i==y && j==x){
                    continue;
                }
                alive += cells[i][j];
            }
        }
        return alive;
    }
    
}
