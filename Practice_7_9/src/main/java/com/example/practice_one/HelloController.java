package com.example.practice_one;

import com.example.practice_one.page_114.Page114;
import com.example.practice_one.page_118.Page118;
import com.example.practice_one.page_132.Page132;
import javafx.fxml.FXML;

public class HelloController {

    @FXML
    protected void onE1Click(){
        Page114.show();
    }
    @FXML
    protected void onE2Click(){
        Page118.startGame();
    }
    @FXML
    protected void onE3Click(){
        Page132.show();
    }
}