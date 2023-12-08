package com.example.practice_one.page_132;

import com.example.practice_one.HelloApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Page132 {

    @FXML
    private GridPane computerGridPane;

    @FXML
    private GridPane playerGridPane;

    @FXML
    private Label playerResultLabel;

    @FXML
    private Label compResultLabel;

    @FXML
    private Label label1;

    @FXML
    private Label label10;

    @FXML
    private Label compLabel10;

    @FXML
    private Label label11;

    @FXML
    private Label compLabel11;

    @FXML
    private Label label12;

    @FXML
    private Label compLabel12;

    @FXML
    private Label label13;

    @FXML
    private Label compLabel13;

    @FXML
    private Label label14;

    @FXML
    private Label compLabel14;

    @FXML
    private Label label15;

    @FXML
    private Label compLabel15;

    @FXML
    private Label label16;

    @FXML
    private Label compLabel16;

    @FXML
    private Label label17;

    @FXML
    private Label compLabel17;

    @FXML
    private Label label18;

    @FXML
    private Label compLabel18;

    @FXML
    private Label label19;

    @FXML
    private Label compLabel19;

    @FXML
    private Label compLabel1;

    @FXML
    private Label label2;

    @FXML
    private Label label20;

    @FXML
    private Label compLabel20;

    @FXML
    private Label label21;

    @FXML
    private Label compLabel21;

    @FXML
    private Label label22;

    @FXML
    private Label compLabel22;

    @FXML
    private Label label23;

    @FXML
    private Label compLabel23;

    @FXML
    private Label label24;

    @FXML
    private Label compLabel24;

    @FXML
    private Label label25;

    @FXML
    private Label compLabel25;

    @FXML
    private Label compLabel2;

    @FXML
    private Label label3;

    @FXML
    private Label compLabel3;

    @FXML
    private Label label4;

    @FXML
    private Label compLabel4;

    @FXML
    private Label label5;

    @FXML
    private Label compLabel5;

    @FXML
    private Label label6;

    @FXML
    private Label compLabel6;

    @FXML
    private Label label7;

    @FXML
    private Label compLabel7;

    @FXML
    private Label label8;

    @FXML
    private Label compLabel8;

    @FXML
    private Label label9;

    @FXML
    private Label compLabel9;

    @FXML
    private Label currentCard;

    private Map<String, Label> labelsP = new HashMap<>();
    private Map<String, Label> labelsC = new HashMap<>();

    public static void show() {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page132.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Математико");
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void initialize() {

        labelsP.put("label1", label1);
        labelsP.put("label2", label2);
        labelsP.put("label3", label3);
        labelsP.put("label4", label4);
        labelsP.put("label5", label5);
        labelsP.put("label6", label6);
        labelsP.put("label7", label7);
        labelsP.put("label8", label8);
        labelsP.put("label9", label9);
        labelsP.put("label10", label10);
        labelsP.put("label11", label11);
        labelsP.put("label12", label12);
        labelsP.put("label13", label13);
        labelsP.put("label14", label14);
        labelsP.put("label15", label15);
        labelsP.put("label16", label16);
        labelsP.put("label17", label17);
        labelsP.put("label18", label18);
        labelsP.put("label19", label19);
        labelsP.put("label20", label20);
        labelsP.put("label21", label21);
        labelsP.put("label22", label22);
        labelsP.put("label23", label23);
        labelsP.put("label24", label24);
        labelsP.put("label25", label25);

        labelsC.put("compLabel1", compLabel1);
        labelsC.put("compLabel2", compLabel2);
        labelsC.put("compLabel3", compLabel3);
        labelsC.put("compLabel4", compLabel4);
        labelsC.put("compLabel5", compLabel5);
        labelsC.put("compLabel6", compLabel6);
        labelsC.put("compLabel7", compLabel7);
        labelsC.put("compLabel8", compLabel8);
        labelsC.put("compLabel9", compLabel9);
        labelsC.put("compLabel10", compLabel10);
        labelsC.put("compLabel11", compLabel11);
        labelsC.put("compLabel12", compLabel12);
        labelsC.put("compLabel13", compLabel13);
        labelsC.put("compLabel14", compLabel14);
        labelsC.put("compLabel15", compLabel15);
        labelsC.put("compLabel16", compLabel16);
        labelsC.put("compLabel17", compLabel17);
        labelsC.put("compLabel18", compLabel18);
        labelsC.put("compLabel19", compLabel19);
        labelsC.put("compLabel20", compLabel20);
        labelsC.put("compLabel21", compLabel21);
        labelsC.put("compLabel22", compLabel22);
        labelsC.put("compLabel23", compLabel23);
        labelsC.put("compLabel24", compLabel24);
        labelsC.put("compLabel25", compLabel25);

        Card card = new Card(currentCard);
        card.writeCurrentCard();
        Computer computer = new Computer(this.computerGridPane, labelsC, card);
        Player player = new Player(this.playerGridPane, labelsP, card, computer);
        player.putCard();

        resultObserving();
    }

    private void resultObserving(){

        Timeline timeline = new Timeline();

        javafx.util.Duration duration = new Duration(100);

        KeyFrame keyFrame = new KeyFrame(duration, event -> {

            if(!Check.playerResult.isEmpty() && !Check.compResult.isEmpty()){

                compResultLabel.setText("Очки: " + Check.compResult);
                playerResultLabel.setText("Очки: " + Check.playerResult);

                if(Integer.parseInt(Check.compResult) > Integer.parseInt(Check.playerResult)){

                    currentCard.setText("Вы проиграли");
                }
                else{

                    if(Integer.parseInt(Check.compResult) < Integer.parseInt(Check.playerResult)){

                        currentCard.setText("Вы выиграли");
                    }
                    else currentCard.setText("Ничья");
                }
            }
            }
        );

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}