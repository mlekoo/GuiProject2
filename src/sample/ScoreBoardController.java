package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.*;

public class ScoreBoardController {
    public static String time;
    @FXML
    private TextField username;
    @FXML
    private Button save;
    @FXML
    private Pane pane;

    public void initialize(){
        try(
        Writer output = new BufferedWriter(new FileWriter("Score.txt", true));
        ) {
            output.append(username.getText() + " " + time + "/n");
            output.close();
        }catch(Exception e) {
            e.printStackTrace();

        }

        try (BufferedReader bf = new BufferedReader(new FileReader("Score.txt"))) {
            String tmp;
            while((tmp = bf.readLine()) != null){
                System.out.println(tmp);
            }
        }catch(IOException e){e.printStackTrace();}
    }
    @FXML
    private void onClickButton() throws IOException {
        Writer output = new BufferedWriter(new FileWriter("Score.txt", true));
        output.append(username.getText() + " " +time + "/n");
        output.close();
    }
}
