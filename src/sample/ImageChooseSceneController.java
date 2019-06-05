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

    private int columns, lines;

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

        int x = 0, y = 0,
                width = Main.windowWidth / columns, height = Main.windowHeight / lines;
       Image[][] imagePieces = new Image[lines][columns];
       PixelReader reader = readImage(adress).getPixelReader();
       for(int i = 0; i < lines; i++){
           x=0;
           for(int j = 0; j < columns; j++){
               imagePieces[i][j] = new WritableImage(reader, x, y, width, height);
                       x+=width;
           }
           y+=height;
       }

       GameSceneController.image = imagePieces;
       GameSceneController.columns = columns;
       GameSceneController.lines = lines;
      // gameSceneController.setImage(imagePieces);
      // gameSceneController.setColumns(columns);
      // gameSceneController.setLines(lines);

        setScene();

    }

    void setLines(int lines) {
        this.lines = lines;
    }

    void setColumns(int columns) {
        this.columns = columns;
    }
}
