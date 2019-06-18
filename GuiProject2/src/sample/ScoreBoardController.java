package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ScoreBoardController {
    public static String time;
    @FXML
    private TextField username;
    @FXML
    private Button save;
    @FXML
    private TextArea textArea;
    @FXML
    private Pane pane;
    @FXML Label clock;

    public void initialize() throws IOException{
        clock.setText(time);

      StringBuffer sb = new StringBuffer();
      File file = new File("Score.txt");
      Scanner sc = new Scanner(file);

      while(sc.hasNextLine())
          sb.append(sc.nextLine() + "\n");

      textArea.setText(sb.toString());
    }
    @FXML
    private void onClickButton() throws IOException {
       FileWriter fw = new FileWriter("Score.txt", true);
       fw.append(username.getText() + " " + time + "\n");
       System.out.println("x");
       fw.close();
       textArea.setText(textArea.getText() + username.getText() + " " + time + "\n");
        //Files.write(Paths.get("Score.txt"), (username.getText() + " " + time + "\n".getBytes()).getBytes(), StandardOpenOption.APPEND);

    }
}
