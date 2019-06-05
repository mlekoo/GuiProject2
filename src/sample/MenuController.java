package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;


public class MenuController {

    private ImageChooseSceneController imageChooseSceneController;

    private Scene imageChooseScene;

    @FXML
    private ImageView background;

    @FXML
    private Button startText;

    @FXML
    private Label difficultyLevel;

    @FXML
    private Slider slider1,
                    slider2;

  @FXML
  public void initialize(){
    sliderListener(slider1);
    sliderListener(slider2);
    setBackground("MenuBackground.jpg");
  }

  private void difficultyLevel(String text){
        difficultyLevel.setText(text);
    }

  @FXML
  private void setBackground(String adress){
      File file = new File(adress);
      Image image = new Image(file.toURI().toString());
      background.setImage(image);
  }

  @FXML
  private void sliderListener(Slider slider){
      slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
          @Override
          public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
              if(slider1.getValue() == 3 && slider2.getValue() == 3){
                  difficultyLevel("Easy");
              }else if(slider1.getValue() < 5 || slider2.getValue() < 5){
                  difficultyLevel("Medium");
              }else{
                  difficultyLevel("Hard");
              }
          }
      });
  }

  private void setScene() throws IOException {
      startText.setText("...");
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ImageChooseScene.fxml"));
      Parent root = fxmlLoader.load();
      imageChooseScene = new Scene(root);
      Main.stage.setScene(imageChooseScene);
      imageChooseSceneController=fxmlLoader.getController();
      imageChooseSceneController.setColumns((int)slider1.getValue());
      imageChooseSceneController.setLines((int)slider2.getValue());
  }
  @FXML
  public void onStartClick(ActionEvent e) throws IOException{
      setScene();
  }
}
