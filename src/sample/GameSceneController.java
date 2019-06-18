
package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.lang.System.*;
import java.time.Duration;
import java.util.EventListener;
import java.util.TimerTask;

public class GameSceneController {

    public static Image[][] image;

    public static Scene gameScene;

    public static int columns, lines;

    ScoreBoardController scoreBoardController;



    private ImageView[][] IMGS = new ImageView[lines][columns];
    @FXML
    private GridPane gridPane;
    private AnchorPane anchorPane;

    @FXML
    private Label time;





    @FXML
    public void initialize() {

        Main.stage.setTitle("Do what you can");
        time.setText("time");

        image[(int)(Math.random()* lines)][(int)(Math.random()* columns)]= null;

        ImageView iv;

        for(int i = 0; i < lines; i++){
            for(int j = 0; j < columns; j++){
                IMGS[i][j] = new ImageView(image[i][j]);
                final int y = i, x = j;
                IMGS[i][j].setOnMouseClicked(event->swapImage(x,y));
                gridPane.add(IMGS[i][j],j,i);
            }
        }

       // blendTheImage();
    }

    private void blendTheImage(){
        for(int i = 0; i < 2; i++){
            for(int x = 0; x < lines; x++){
                for(int y = 0; y < columns; y++){
                    if(IMGS[x][y].getImage() == null){
                        int rand = (int)Math.random()*4;
                        try {
                            switch (rand) {
                                case 0:
                                    swapAbove(x,y);
                                    break;
                                case 1:
                                    swapUnder(x, y);
                                    break;
                                case 2:
                                    swapLeft(x, y);
                                    break;
                                case 3:
                                    swapRight(x, y);
                                    break;
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private boolean checkIfWon(){
        for(int i = 0; i < lines; i++){
            for(int j = 0; j < columns; j++){
                if(IMGS[i][j].getImage() != image[i][j]){
                    return false;
                }
            }
        }
        System.out.println("You have won!");
        return true;
    }

    private void swapRight(int x, int y){
        IMGS[y][x + 1].setImage(IMGS[y][x].getImage());
        IMGS[y][x].setImage(null);

    }

    private void swapLeft(int x, int y){
        IMGS[y][x-1].setImage(IMGS[y][x].getImage());
        IMGS[y][x].setImage(null);
    }

    private void swapAbove(int x, int y){
        IMGS[y-1][x].setImage(IMGS[y][x].getImage());
        IMGS[y][x].setImage(null);
    }

    private void swapUnder(int x, int y){
        IMGS[y+1][x].setImage(IMGS[y][x].getImage());
        IMGS[y][x].setImage(null);
    }

    private void swapImage(int x, int y){
       if(x != 0 && x != columns-1 && y != 0 && y != lines-1){
           if(IMGS[y-1][x].getImage() == null){
               swapAbove(x,y);
           }else if(IMGS[y+1][x].getImage() == null){
              swapUnder(x,y);
           }else if(IMGS[y][x-1].getImage() == null){
               swapLeft(x,y);
           }else if(IMGS[y][x+1].getImage() == null){
               swapRight(x,y);
           }
       }else if(x == 0 && y == 0){
           if(IMGS[y+1][x].getImage() == null){
               swapUnder(x,y);
           }else if(IMGS[y][x+1].getImage() == null) {
               swapRight(x,y);
           }
       }else if(x == 0 && y == lines-1){
           if(IMGS[y-1][x].getImage() == null){
                swapAbove(x,y);
          }else if(IMGS[y][x+1].getImage() == null){
               swapRight(x,y);
           }
       }else if(x == columns-1 && y == lines-1){
           if(IMGS[y-1][x].getImage() == null){
               swapAbove(x,y);
           }else if(IMGS[y][x-1].getImage() == null){
               swapLeft(x,y);
           }
       }else if(x  == columns-1 && y == 0){
           if(IMGS[y+1][x].getImage() == null){
               swapUnder(x,y);
           }else if(IMGS[y][x-1].getImage() == null) {
               swapLeft(x,y);
           }
       }else if(x == 0){
           if(IMGS[y][x+1].getImage() == null){
               swapRight(x,y);
           }else if(IMGS[y-1][x].getImage() == null){
                swapAbove(x,y);
           }else if(IMGS[y+1][x].getImage() == null){
               swapUnder(x,y);
           }
       }else if(x == columns-1) {
           if (IMGS[y][x - 1].getImage() == null) {
               swapLeft(x,y);
           } else if (IMGS[y - 1][x].getImage() == null) {
               swapAbove(x,y);
           } else if (IMGS[y + 1][x].getImage() == null) {
               swapUnder(x,y);
           }
       }else if(y == 0){
           if (IMGS[y+1][x].getImage() == null){
               swapUnder(x,y);
           }else if(IMGS[y][x-1].getImage() == null){
               swapLeft(x,y);
           }else if(IMGS[y][x+1].getImage() == null){
               swapRight(x,y);
           }
       }else if(y == lines-1) {
           if(IMGS[y-1][x].getImage() == null){
               swapAbove(x,y);
           }else if(IMGS[y][x-1].getImage() == null){
               swapLeft(x,y);
           }else if(IMGS[y][x+1].getImage() == null) {
               swapRight(x,y);
           }
       }

       if(checkIfWon()){
      //     anchorPane.getChildren().add(new AnchorPane());
           try {
               setScene();
           }catch(IOException e){e.printStackTrace();}
       }

    }
    private void setScene() throws IOException {
        ScoreBoardController.time = time.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoreBoard.fxml"));
        Parent root = fxmlLoader.load();
        gameScene = new Scene(root);
        Main.stage.setScene(gameScene);
        scoreBoardController = fxmlLoader.getController();

    }

    public void setImage(Image[][] image) {
        this.image = image;
    }


    public void setCropsX(int cropsX) {
        this.columns = cropsX;
    }

    public void setCropsY(int cropsY) {
        this.lines = cropsY;
    }
}

