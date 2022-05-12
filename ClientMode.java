package com.example.demo21;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class ClientMode extends Application {
    private Stage myStage;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    private Scene game;
    @Override
    public void start(Stage stage) throws Exception {
        myStage = stage;
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        socket = new Socket("localhost",1234);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        out = new DataOutputStream(socket.getOutputStream());
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        in = new DataInputStream(socket.getInputStream());
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");


        stage.setWidth(500);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        stage.setHeight(400);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        stage.setScene(pinCode());
        stage.show();
    }

    public Button frontButtons(String colour){
        Font font = Font.font("Times new Roman", FontWeight.BOLD, FontPosture.ITALIC,18);
        Button button = new Button();
        button.setMinWidth(250);
        button.setMinHeight(80);
        button.setStyle("-fx-background-color:"+colour);
        button.setTextFill(Color.BLACK);
        button.setFont(font);
        button.setOnAction(e->{
            try {
                out.writeUTF(colour);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        return button;
    }


    public Scene pinCode() throws FileNotFoundException {
        Button pinCodeButton = new Button("next");
        pinCodeButton.setMaxWidth(50);
        pinCodeButton.setMaxHeight(70);

        TextField pinCodeInput = new TextField();
        String pinCode = pinCodeInput.getText();
        pinCodeInput.setMaxSize(200,110);
        pinCodeInput.setPromptText("GAME PIN");
        ImageView look = new ImageView(new Image((new FileInputStream("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\background.jpg"))));
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(pinCodeInput,pinCodeButton);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(look,vbox);

        pinCodeButton.setOnAction(e->{
            try {
                out.writeInt(parseInt(pinCodeInput.getText()));
                String a = in.readUTF();
                System.out.println(a);
                if(a.equals("Success!")){
                    myStage.setScene(new Scene(nameIn()));
                } else{
                    myStage.setScene(pinCode());
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Scene scene = new Scene(stack);
        return scene;
    }
    private void logic() throws IOException {

        String go = in.readUTF();
        System.out.println(go);
        if(go.equals("Starting")){
            String orient = "hele";
            while(true){
                orient = in.readUTF();
                if(orient.equals("fillIn")){
                   game = new Scene(fillIn());
                }
                else if(orient.equals("tf")){
                    game = new Scene(trueFalse());
                } else if(orient.equals("test")){
                    game = new Scene(mainGame());
                }
                else if(orient.equals("endGame")){
                    break;
                }
            }
        }
        else{
            Label label =new Label("Waiting players");
            label.setMaxSize(250,250);
            BorderPane waitPane = new BorderPane();
            waitPane.getChildren().addAll(label);
            game = new Scene(waitPane);
        }
    }
    public StackPane nameIn() throws IOException {
        logic();
        logic();
        logic();
        logic();
        Button nameInputButton = new Button("START");
        logic();
        logic();
        logic();
        logic();
        nameInputButton.setMaxWidth(50);
        logic();
        logic();
        logic();
        logic();
        nameInputButton.setMaxHeight(70);

        logic();
        logic();
        logic();
        logic();
        TextField enteringName = new TextField();
        logic();
        logic();
        logic();
        logic();
        enteringName.setMaxSize(200,110);
        logic();
        logic();
        logic();
        logic();
        enteringName.setPromptText("Enter your name");
        logic();
        logic();
        logic();
        logic();
        ImageView look = new ImageView(new Image((new FileInputStream("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\background.jpg"))));
        VBox vbox = new VBox();
        logic();
        logic();
        logic();
        logic();
        vbox.setAlignment(Pos.CENTER);
        logic();
        logic();
        logic();
        logic();
        vbox.getChildren().addAll(enteringName,nameInputButton);
        logic();
        logic();
        logic();
        logic();
        StackPane stack = new StackPane();
        logic();
        logic();
        logic();
        logic();
        stack.getChildren().addAll(look,vbox);
        logic();
        logic();
        logic();
        logic();
        name = enteringName.getText();
        nameInputButton.setOnAction(e->{
            myStage.setTitle(enteringName.getText());
            try {
                out.writeUTF(enteringName.getText());
                myStage.setScene(game);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        return stack;
    }

    private HBox mainGame() throws IOException {
        Button redButton = frontButtons("red");
        logic();
        logic();
        logic();
        logic();
        Button blueButton = frontButtons("blue");
        logic();
        logic();
        logic();
        logic();
        Button yellowButton = frontButtons("yellow");
        logic();
        logic();
        logic();
        logic();
        Button greenButton = frontButtons("green");
        logic();
        logic();
        logic();
        logic();
        VBox vBox = new VBox(3);
        logic();
        logic();
        logic();
        logic();
        vBox.getChildren().addAll(greenButton,blueButton);
        logic();
        logic();
        logic();
        logic();
        vBox.setAlignment(Pos.CENTER);
        logic();
        logic();
        logic();
        logic();

        VBox vBox1 = new VBox(3);
        logic();
        logic();
        logic();
        logic();
        vBox1.getChildren().addAll(redButton,yellowButton);
        logic();
        logic();
        logic();
        logic();
        vBox1.setAlignment(Pos.CENTER);
        logic();
        logic();
        logic();
        logic();

        HBox hbox = new HBox(3);
        logic();
        logic();
        logic();
        logic();
        hbox.getChildren().addAll(vBox, vBox1);
        logic();
        logic();
        logic();
        logic();
        return hbox;

    }
    private VBox fillIn() throws IOException {
        ImageView view = new ImageView(new Image(new FileInputStream("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\fillin.png")));
        view.setFitWidth(250);
        logic();
        logic();
        logic();
        logic();
        view.setFitHeight(100);
        logic();
        logic();
        logic();
        logic();
        TextField field = new TextField();
        logic();
        logic();
        logic();
        logic();
        field.setPromptText("YOUR ANSWER");
        logic();
        logic();
        logic();
        logic();
        field.setMaxSize(200,70);
        logic();
        logic();
        logic();
        logic();
        VBox vBox = new VBox(15);
        logic();
        logic();
        logic();
        logic();

        vBox.getChildren().addAll(view,field);
        logic();
        logic();
        logic();
        logic();
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
    private HBox trueFalse() throws IOException {
        Button buttonTrue = frontButtons("red");
        logic();
        logic();
        logic();
        logic();
        buttonTrue.setText("TRUE");logic();
        logic();
        logic();
        logic();
        buttonTrue.setMaxSize(250,250);
        logic();
        logic();
        logic();
        logic();
        Button buttonFalse = frontButtons("blue");
        logic();
        logic();
        logic();
        logic();
        buttonFalse.setText("FALSE");
        logic();
        logic();
        logic();
        logic();
        buttonFalse.setMaxSize(250,250);
        logic();
        logic();
        logic();
        logic();
        HBox box = new HBox();
        logic();
        logic();
        logic();
        logic();
        box.setAlignment(Pos.CENTER);
        logic();
        logic();
        logic();
        logic();
        box.getChildren().addAll(buttonTrue,buttonFalse);
        logic();
        logic();
        logic();
        logic();
        return box;
    }

}
