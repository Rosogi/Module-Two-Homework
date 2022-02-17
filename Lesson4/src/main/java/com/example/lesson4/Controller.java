package com.example.lesson4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    TextField messageTextField;
    @FXML
    TextArea messagesTextArea;
    @FXML
    Button sendButton;




    public void sendButtonViaPress(ActionEvent actionEvent) {
        changeText();
    }

    public void sendButtonViaKey(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            changeText();
        }
    }

    private void changeText(){
        messagesTextArea.appendText(messageTextField.getText() + "\n");
        messageTextField.setText("");
    }
}