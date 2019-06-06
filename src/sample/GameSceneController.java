
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameSceneController {

    public static Image[][] image;

    public static int columns, lines;

    private ImageView[][] IMGS = new ImageView[lines][columns];
    @FXML
    private GridPane gridPane;

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

    }

    private void swapImage(int x, int y){
       if(x != 0 && x != columns-1 && y != 0 && y != lines-1){
           if(IMGS[y-1][x].getImage() == null){
               IMGS[y-1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y+1][x].getImage() == null){
               IMGS[y+1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x-1].getImage() == null){
               IMGS[y][x-1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x+1].getImage() == null){
               IMGS[y][x+1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x == 0 && y == 0){
           if(IMGS[y+1][x].getImage() == null){
               IMGS[y+1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x+1].getImage() == null) {
               IMGS[y][x + 1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x == 0 && y == lines-1){
           if(IMGS[y-1][x].getImage() == null){
               IMGS[y-1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x+1].getImage() == null){
               IMGS[y][x+1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x == columns-1 && y == lines-1){
           if(IMGS[y-1][x].getImage() == null){
               IMGS[y-1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x-1].getImage() == null){
               IMGS[y][x-1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x  == columns-1 && y == 0){
           if(IMGS[y+1][x].getImage() == null){
               IMGS[y+1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x-1].getImage() == null) {
               IMGS[y][x - 1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x == 0){
           if(IMGS[y][x+1].getImage() == null){
               IMGS[y][x+1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y-1][x].getImage() == null){
               IMGS[y-1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y+1][x].getImage() == null){
               IMGS[y+1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(x == columns-1) {
           if (IMGS[y][x - 1].getImage() == null) {
               IMGS[y][x - 1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           } else if (IMGS[y - 1][x].getImage() == null) {
               IMGS[y - 1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           } else if (IMGS[y + 1][x].getImage() == null) {
               IMGS[y + 1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(y == 0){
           if (IMGS[y+1][x].getImage() == null){
               IMGS[y+1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x-1].getImage() == null){
               IMGS[y][x-1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x+1].getImage() == null){
               IMGS[y][x+1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }else if(y == lines-1) {
           if(IMGS[y-1][x].getImage() == null){
               IMGS[y-1][x].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x-1].getImage() == null){
               IMGS[y][x-1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }else if(IMGS[y][x+1].getImage() == null) {
               IMGS[y][x + 1].setImage(IMGS[y][x].getImage());
               IMGS[y][x].setImage(null);
           }
       }
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

