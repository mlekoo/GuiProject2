package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.EventListener;

public class Controller {

    Scene gameScene;

    @FXML
    private Button startText;

    @FXML
    private Label difficultyLevel;

    @FXML
    private Slider slider1,
                    slider2;
    private File image;



  @FXML
  public void initialize(){
    sliderListener(slider1);
    sliderListener(slider2);
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
  public void difficultyLevel(ActionEvent e) throws Exception{

        difficultyLevel.setText("lol");
  }

    @FXML
    public void onStartClick(ActionEvent e) throws Exception{
        startText.setText("...");

        /*sliderValue1 = (int)slider1.getValue();
        sliderValue2 = (int)slider2.getValue();*/

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        Parent root = fxmlLoader.load();
        gameScene = new Scene(root);
        Main.stage.setScene(gameScene);


    }


}
