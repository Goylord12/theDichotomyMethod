package com.example.gg;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DhtController {

    private final String regexp = "\\D*\\d+";
    private final String regexp1 = "\\D*\\d+\\.?\\d+";

    @FXML
    public Button result_dht;
    @FXML
    public Label res1;
    @FXML
    public Button help;
    @FXML
    private TextField firstNum;
    @FXML
    private TextField secondNum;
    @FXML
    private TextField thirdNum;
    @FXML
    private TextField lastNum;
    @FXML
    private TextField upTXT;
    @FXML
    private TextField downTXT;
    @FXML
    private TextField accuracyTXT;

    public void getResultDht() {
        if (firstNum.getText().matches(regexp) && secondNum.getText().matches(regexp)
                && thirdNum.getText().matches(regexp) && !(Objects.equals(thirdNum.getText(), "0"))
                && lastNum.getText().matches(regexp) && upTXT.getText().matches(regexp) &&
                downTXT.getText().matches(regexp) && intFromBox(upTXT)>intFromBox(downTXT)
                && accuracyTXT.getText().matches(regexp1)) {
            List<Double> resultList = calculation(intFromBox(firstNum), intFromBox(secondNum), intFromBox(thirdNum), intFromBox(lastNum), doubleFromBox(upTXT), doubleFromBox(downTXT), doubleFromBox(accuracyTXT));
            if (resultList.get(resultList.size() - 1) == 1) {
                res1.setText("X = " + resultList.get(resultList.size() - 2).toString());
            } else {
                res1.setText("Корней нет");
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Введены неверные или не нечисловые значения!", ButtonType.OK);
            alert.showAndWait();
        }


    }

    private static List<Double> calculation(int a, int b, int c, int d, double up, double down, double accuracy) {
        List<Double> resultList = new ArrayList<>();
        int variants = 0;
        double r = 0;
        double result = 0;
        if(((a*3*Math.pow(down, 2) + b*2*down + c)<1)||((a*3*Math.pow(up, 2) + b*2*up + c)<1)){
            do {
                result= (up+down)/2;
                r=Math.abs(down)-Math.abs(up);
                if((a*Math.pow(down, 3) + b * down * down + c * down + d)*(a*Math.pow(result, 3) + b * result * result + c * result + d)==0) {
                    break;
                } else if ((a*Math.pow(down, 3) + b * down * down + c * down + d)*(a*Math.pow(result, 3) + b * result * result + c * result + d)>0){//(a*Math.pow(down, 3) + b * down * down + c * down + d)*(a*Math.pow(result, 3) + b * result * result + c * result + d)==0
                    up = result;
                }
                else{
                    down = result;
                }
            }
            while (r>accuracy);
            resultList.add(result);
            variants = variants + 1;
            resultList.add((double)variants);
        }

        else{
            resultList.add((double)variants);
        }
       
    }
    public void getHelp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("C:\\Games\\gg\\src\\main\\resources\\com\\example\\gg\\help.fxml")));
        root.setId("pane");
        Stage stage = new Stage();
        stage.setTitle("Справка");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(this.getClass().getClassLoader().getResource("style.css")));
        stage.setScene(scene);
        stage.show();
    }
}
