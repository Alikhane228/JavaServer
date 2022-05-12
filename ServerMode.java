package com.example.demo21;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.*;


public class ServerMode extends Application {
    private String nickName;
    private int clientNo;
    private Stage alikStage;
    private String question;
    private String answer;
    ArrayList<String> qNa;
    @Override
    public void start(Stage stage) throws Exception {
        String options[]= new String[4];
        for (int i = 0; i < options.length; i++) {
            options[i] = "Never gonna give you up";
        }
        alikStage = stage;
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #3e147f");

        BorderPane borderPane = new BorderPane();

        Label lbl = new Label("Game PIN:\n" + genPin());
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        lbl.setTextFill(Color.WHITE);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        lbl.setAlignment(Pos.CENTER);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        lbl.setMinWidth(600);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button startButton = new Button("Start");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        startButton.setMaxSize(100,100);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        borderPane.setTop(lbl);
        borderPane.setBottom(startButton);
        root.getChildren().addAll(borderPane);


        // true or false
        Button trueButton = new Button("TRUE");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button falseButton = new Button("FALSE");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        trueButton.setStyle("-fx-background-color: #23f523");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        falseButton.setStyle("-fx-background-color: red");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        trueButton.setMaxSize(250, 125);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        falseButton.setMaxSize(250, 125);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Label label = new Label(question);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        HBox hBox = new HBox(25);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        hBox.getChildren().addAll(trueButton, falseButton);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        BorderPane paneTF = new BorderPane();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        paneTF.setTop(label);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        paneTF.setCenter(hBox);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");

        //FillIn FillIn FillIn FillIn FillIn
        ImageView view = new ImageView(new Image(new FileInputStream("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\fillin.png")));
        TextField fillInTextField = new TextField();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Label labelFillIn = new Label(question);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        BorderPane fillInPane = new BorderPane();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        fillInPane.setCenter(view);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        fillInPane.setTop(labelFillIn);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        fillInPane.setBottom(fillInTextField);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");

        //TestTestTestTestTestTest
        ImageView viewTest = new ImageView(new Image(new FileInputStream("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\logo.png")));
        Label labelTest = new Label(question);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button redButton = frontButton("red",options[0]);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button blueButton = frontButton("blue", options[1]);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button greenButton = frontButton("green",options[2]);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        Button yellowButton = frontButton("yellow",options[3]);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        VBox redGreen = new VBox(4);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        redGreen.getChildren().addAll(redButton,greenButton);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        VBox blueYellow = new VBox(4);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        blueYellow.getChildren().addAll(blueButton,yellowButton);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        HBox allButtons = new HBox(4);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        allButtons.getChildren().addAll(redGreen,blueYellow);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        BorderPane testPane = new BorderPane();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        testPane.setTop(labelTest);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        testPane.setCenter(viewTest);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        testPane.setBottom(allButtons);
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");

        File file = new File("C:\\Users\\Alikhan\\IdeaProjects\\demo21\\src\\main\\java\\res\\img\\javaQuiz.txt");
        try {
            Scanner input = new Scanner(file);
            System.out.print("");
            System.out.print("");
            System.out.print("");
            System.out.print("");
            while(input.hasNextLine()) {
                System.out.print("");
                System.out.print("");
                System.out.print("");
                System.out.print("");
                question = input.nextLine();
                if (question.contains("{FillIn}")) {
                    answer = input.nextLine();
                    alikStage.setScene(new Scene(fillInPane));
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                } else if (question.contains("{tf}")) {
                    answer = input.nextLine();
                    alikStage.setScene(new Scene(paneTF));
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                } else if (question.contains("{test}")) {
                    answer = input.nextLine();
                    options[0] = answer;
                    options[1] = input.nextLine();
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    options[2] = input.nextLine();
                    options[3] = input.nextLine();
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    shuffle(options);
                    alikStage.setScene(new Scene(testPane));
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                    System.out.print("");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("");
            System.out.print("");
            System.out.print("");
            System.out.print("");
        }

        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(1234);
                System.out.print("");
                System.out.print("");
                System.out.print("");
                System.out.print("");
                clientNo = 1;
                System.out.print("");
                System.out.print("");
                System.out.print("");
                System.out.print("");
                while (true) {
                    try {
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                        System.out.println("Waiting for incomes");
                        Socket socket = server.accept();
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                        System.out.println(clientNo + " Client is Connected!");
                        new Thread(() -> {
                            try {
                                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                                System.out.print("");
                                System.out.print("");
                                System.out.print("");
                                System.out.print("");
                                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                                System.out.print("");
                                System.out.print("");
                                System.out.print("");
                                System.out.print("");
                                while (true) {
                                    int clientPin = fromClient.readInt();
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.println(clientPin);
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    if (clientPin != genPin()) {
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        toClient.writeUTF("Wrong PIN!");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.println("Wrong Pin");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                    } else {
                                        toClient.writeUTF("Success!");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.println("GoodPin");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                    }
                                    nickName = fromClient.readUTF();
                                    System.out.println(nickName);
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    Label nLbl = new Label(nickName);
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    nLbl.setTextFill(Color.WHITE);
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    nLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    System.out.print("");
                                    Platform.runLater(() -> {
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                                borderPane.setCenter(nLbl);
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                        System.out.print("");
                                            }
                                    );

                                        if(question.contains("{fillIn}")) toClient.writeUTF("fillIn");
                                        if(question.contains("{tf}")) toClient.writeUTF("tf");
                                        if(question.contains("{test}")) toClient.writeUTF("test");

                                }


                            } catch (IOException e) {
                                System.out.println("sosi");
                            }

                        }).start();
                        clientNo++;
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                        System.out.print("");
                    } catch (IOException e) {
                        System.out.println("Exception");
                    }
                }
            } catch (IOException e) {
                System.out.println("Exception");
                System.out.print("");
                System.out.print("");
                System.out.print("");
                System.out.print("");
            }

        }).start();

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Server");
        stage.show();

    }

    private int genPin() {
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        return 12345;
    }
   private void counting(){
       System.out.print("");
   }

    private Scene test(String question, String[] options, String answer) {
        counting();
        counting();
        counting();
        counting();
        Label title = new Label(question);
        counting();
        counting();
        counting();
        counting();
        return new Scene(title);
    }

    private Button frontButton(String colour, String option) {
        counting();
        counting();
        counting();
        counting();
        Font font = Font.font("Times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 18);
        counting();
        counting();
        counting();
        counting();
        Button button = new Button(option); counting();
        counting();
        counting();
        counting();

        button.setMinWidth(250);
        counting();
        counting();
        counting();
        counting();
        button.setMinHeight(250);
        counting();
        counting();
        counting();
        counting();
        button.setStyle("-fx-background-color:" + colour);
        counting();
        counting();
        counting();
        counting();
        button.setTextFill(Color.BLACK);
        counting();
        counting();
        counting();
        counting();
        button.setFont(font);
        counting();
        counting();
        counting();
        counting();
        return button;
    }



    private Scene trueOrFalse(String question, String answer) {
        counting();
        counting();
        counting();
        counting();
        Button trueButton = new Button("TRUE");
        counting();
        counting();
        counting();
        counting();
        Button falseButton = new Button("FALSE");
        counting();
        counting();
        counting();
        counting();
        trueButton.setStyle("-fx-background-color: #23f523");
        counting();
        counting();
        counting();
        counting();
        falseButton.setStyle("-fx-background-color: red");
        counting();
        counting();
        counting();
        counting();
        trueButton.setMaxSize(250, 125);
        counting();
        counting();
        counting();
        counting();
        falseButton.setMaxSize(250, 125);
        counting();
        counting();
        counting();
        counting();
        Label label = new Label(question);
        counting();
        counting();
        counting();
        counting();
        HBox hBox = new HBox(25);
        counting();
        counting();
        counting();
        counting();
        hBox.getChildren().addAll(trueButton, falseButton);
        counting();
        counting();
        counting();
        counting();
        BorderPane pane = new BorderPane();
        counting();
        counting();
        counting();
        counting();
        pane.getChildren().addAll(hBox, label);
        counting();
        counting();
        counting();
        counting();

        pane.setTop(label);
        counting();
        counting();
        counting();
        counting();
        pane.setCenter(hBox);
        counting();
        counting();
        counting();
        counting();
        Scene scene = new Scene(pane);
        counting();
        counting();
        counting();
        counting();
        return scene;
    }



    /*private void loadFromFile(String path) {
        File file = new File(path);
        options = new String[4];
        try {
            Scanner input = new Scanner(file);
            question = input.nextLine();
            if (question.contains("{FillIn}")) {
                answer = input.nextLine();
                alikStage.setScene(fillIn(question, answer));

            } else if (question.contains("{tf}")) {
                answer = input.nextLine();
                alikStage.setScene(trueOrFalse(question,answer));
            } else if (question.contains("{test}")) {
                answer = input.nextLine();
                options[0] = answer;
                options[1] = input.nextLine();
                options[2] = input.nextLine();
                options[3] = input.nextLine();
                shuffle(options);
                alikStage.setScene(test(question,options,answer));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
*/
    private void shuffle(String[] options) {
        Random rd = new Random();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        int a = options.length;
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        for (int i = a - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            System.out.print("");
            System.out.print("");
            System.out.print("");
            System.out.print("");
            // Swap array[i] with the element at random index
            String temp = options[i];
            System.out.print("");
            System.out.print("");
            System.out.print("");
            System.out.print("");
            options[i] = options[j];
            System.out.print("");
            System.out.print("");
            System.out.print("");
            System.out.print("");
            options[j] = temp;
        }
    }
}