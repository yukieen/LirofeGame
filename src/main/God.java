/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 *
 * @author yukieen
 */
public class God implements Initializable {
    public Pane canvas;
    public Label counter;
    
    private static final int CELL_UNIT = 5;
    private World world;
    private int generation = 0;
    private boolean isRotate;

    @FXML
    private void handleStartButtonAction(ActionEvent event) throws InterruptedException {
        Thread th = new Thread(new Runnable() {
           @Override
           @SuppressWarnings("SleepWhileInLoop")
           public void run() {
              isRotate = true;
              while (isRotate) {
                  final World newWorld = world.generate();
                  world = newWorld;
                  generation++;
                  view(newWorld);
                  view(generation);
                  try {
                      Thread.sleep(500);
                  } catch (InterruptedException e) {
                  }
              }
           }
        });
        th.setDaemon(true);
        th.start();
    }
    
    @FXML
    private void handleStopButtonAction(ActionEvent event) {
        isRotate = false;
    }
    
    @FXML
    private void handleResetButtonAction(ActionEvent event) throws InterruptedException {
        isRotate = false;
        this.world = new World(Irof.cells);
        view(this.world);
        generation = 0;
        counter.setText(Integer.toString(generation));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.world = new World(Irof.cells);
        view(this.world);
        counter.setText(Integer.toString(generation));
    }
    
    private void view(World world){
        final int[][] cells = world.cells;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                canvas.getChildren().clear();
                for (int y=0;y<cells.length;y++){
                    for(int x=0;x<cells[y].length;x++){
                       if(cells[y][x] == 1){
                            Circle circle = new Circle(CELL_UNIT * x,
                                    CELL_UNIT * y,
                                    CELL_UNIT /2);

                            canvas.getChildren().add(circle);
                        }
                    }
                }  
            }
        });
    }
    
    private void view(final int generation){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
               counter.setText(Integer.toString(generation));
            }
        });
    }
}
