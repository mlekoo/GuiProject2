package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import java.io.File;


public class GameSceneController {

    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        File file = new File("Z:/GuiProject2/GuiProject2/Image1.jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }


}
