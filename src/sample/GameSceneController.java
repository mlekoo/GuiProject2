
package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GameSceneController {

    private Image[][] image;


    @FXML
    public ImageView imageView1,
                        imageView2,
                            imageView3,
                                imageView4,
                                    imageView5,
                                        imageView6,
                                            imageView7,
                                                imageView8,
                                                    imageView9;

    ImageView[][] IMGS = {{imageView1, imageView2, imageView3}
                        ,{imageView4,imageView5,imageView6}
                        ,{imageView7,imageView8,imageView9}};
    @FXML
    public GridPane gridPane;

    @FXML
    public void dd(){

        gridPane.add(imageView3,0,0);

    }

    @FXML
    public void initialize() {
        dd();
    }

    public void setImage(Image[][] image) {
        this.image = image;
       /* imageView1.setImage(image[0][0]);
        imageView2.setImage(image[0][1]);
        imageView3.setImage(image[0][2]);
        imageView4.setImage(image[1][0]);
        imageView5.setImage(image[1][1]);
        imageView6.setImage(image[1][2]);
        imageView7.setImage(image[2][0]);
        imageView8.setImage(image[2][1]);
        imageView9.setImage(image[2][2]);*/
    }

    public void swapImage1(){
        if(imageView1.getImage() == null) System.out.println("null");
        else{

        }
        System.out.println("shit");
    }

}

