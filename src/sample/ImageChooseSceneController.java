package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.io.File;
import java.io.IOException;


public class ImageChooseSceneController {

    private int cropsX,cropsY;

    private GameSceneController gameSceneController;

    private Scene choosedScene;

    @FXML
    private ImageView imageView1,
                        imageView2,
                            imageView3,
                                imageView4;
    @FXML
    public void initialize(){
        Main.stage.setTitle("Choose your map");
        imageView1.setImage(readImage("Image1.jpg"));
        imageView2.setImage(readImage("Image2.jpg"));
        imageView3.setImage(readImage("Image3.jpg"));
        imageView4.setImage(readImage("Image4.jpg"));

    }

    public Image readImage(String adress){
        File file = new File(adress);
            Image image = new Image(file.toURI().toString());
            return image;
    }

    public void setScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
        Parent root = fxmlLoader.load();
        choosedScene = new Scene(root);
        Main.stage.setScene(choosedScene);
        gameSceneController = fxmlLoader.getController();
    }
    @FXML
    public void setImage1() throws IOException{
        setScene();
        int x = 0;
        int y = 0;
        int width = 426;
        int height = 240;
        Image[][] imageViews = new Image[cropsX][cropsY];
        PixelReader reader = readImage("Image1.jpg").getPixelReader();
        for(int i = 0; i < cropsX; i++){
            imageViews[0][i] = new WritableImage(reader, x, y, width,height);

            imageViews[1][i] = new WritableImage(reader, x, 240, width, height);
            imageViews[2][i] = new WritableImage(reader, x, 480, width, height);
            x+=427;
        }


        gameSceneController.setImage(imageViews);
    }
    public void setImage2() throws IOException{
        setScene();
        //gameSceneController.setImage(readImage("Image2.jpg"));
    }
    public void setImage3() throws IOException {
        setScene();
        //  gameSceneController.setImage(readImage("Image3.jpg"));}
    }

    public void setImage4() throws IOException{
        setScene();
        //gameSceneController.setImage(readImage("Image4.jpg"));
    }

    public void setCropsY(int cropsY) {
        this.cropsY = cropsY;
    }

    public void setCropsX(int cropsX) {
        this.cropsX = cropsX;
    }
}
