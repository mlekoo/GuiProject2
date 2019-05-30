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
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.io.File;


public class MenuController {

    ImageChooseSceneController imageChooseSceneController;

    Scene imageChooseScene;
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

  @FXML
  public void setBackground(String adress){
      File file = new File(adress);
      Image image = new Image(file.toURI().toString());
      background.setImage(image);
  }

  @FXML
  public void difficultyLevel(){
      if (slider1.getValue() < 4) difficultyLevel.setText("");
  }

  @FXML
  public void sliderListener(Slider slider){
      slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
          @Override
          public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
              if (slider1.getValue() < 4 || slider2.getValue() < 4) {
                  difficultyLevel.textProperty().setValue("Medium");
              }else if (slider1.getValue() < 5 || slider2.getValue() < 5) {
                  difficultyLevel.textProperty().setValue("Hard");
                 }else
                    if(slider1.getValue() < 6 || slider2.getValue() < 6) {
                        difficultyLevel.textProperty().setValue("Extreme");
                    }
          }
      });
  }


    @FXML
    public void onStartClick(ActionEvent e) throws Exception{
        startText.setText("...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ImageChooseScene.fxml"));
        Parent root = fxmlLoader.load();
        imageChooseScene = new Scene(root);
        Main.stage.setScene(imageChooseScene);

        imageChooseSceneController=fxmlLoader.getController();
        imageChooseSceneController.setCropsX((int)slider1.getValue());
        imageChooseSceneController.setCropsY((int)slider2.getValue());
  }
}
