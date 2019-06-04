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

    private Scene gameScene;

    @FXML
    private ImageView imageView1,
                        imageView2,
                            imageView3,
                                imageView4;
    @FXML
    public void setImage1() throws IOException{
        setImage("Image1.jpg");
    }
    @FXML
    public void setImage2() throws IOException{
        setImage("Image2.jpg");
    }
    @FXML
    public void setImage3() throws IOException {
        setImage("Image3.jpg");
    }
    @FXML
    public void setImage4() throws IOException{
        setImage("Image4.jpg");
    }

    @FXML
    public void initialize() throws IOException {
        Main.stage.setTitle("Choose your map");
        imageView1.setImage(readImage("Image1.jpg"));
        imageView2.setImage(readImage("Image2.jpg"));
        imageView3.setImage(readImage("Image3.jpg"));
        imageView4.setImage(readImage("Image4.jpg"));

    }

    private void setScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
        Parent root = fxmlLoader.load();
        gameScene = new Scene(root);
        Main.stage.setScene(gameScene);
        gameSceneController = fxmlLoader.getController();
    }

    private Image readImage(String adress){
        File file = new File(adress);
        Image image = new Image(file.toURI().toString());
            return image;
    }

    private void setImage(String adress) throws IOException{
        setScene();
        int x = 0, y = 0,
                width = Main.windowWidth / cropsX, height = Main.windowHeight / cropsY;
       Image[][] imagePieces = new Image[cropsX][cropsY];
       PixelReader reader = readImage(adress).getPixelReader();
       for(int i = 0; i < cropsX; i++){
           x=0;
           for(int j = 0; j < cropsY; j++){
               imagePieces[i][j] = new WritableImage(reader, x, y, width, height);
                       x+=width;
           }
           y+=height;
       }
       gameSceneController.setImage(imagePieces);
    }

    void setCropsY(int cropsY) {
        this.cropsY = cropsY;
    }

    void setCropsX(int cropsX) {
        this.cropsX = cropsX;
    }
}
