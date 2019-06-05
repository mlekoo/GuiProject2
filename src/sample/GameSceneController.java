
package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;

public class GameSceneController {

    public static Image[][] image;

    public static int cropsX,cropsY;

    private ImageView[][] IMGS = new ImageView[cropsY][cropsX];
    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {

        image[(int)(Math.random()*cropsY)][(int)(Math.random()*cropsX)]= null;

        ImageView iv;

        for(int i = 0; i < cropsY;i++){
            for(int j = 0; j < cropsX;j++){
                IMGS[i][j] = new ImageView(image[i][j]);
                IMGS[i][j].setOnMouseClicked(event->swapImage(i,j));
                gridPane.add(IMGS[i][j],j,i);
            }
        }
    }

    private void swapImage(int x, int y){

    }


    public void setImage(Image[][] image) {
        this.image = image;
    }


    public void setCropsX(int cropsX) {
        this.cropsX = cropsX;
    }

    public void setCropsY(int cropsY) {
        this.cropsY = cropsY;
    }
}

