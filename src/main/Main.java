package main;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        TextField a2_text = new TextField();
        TextField a1_text = new TextField();
        Label label_plus = new Label();
        Label label_difference = new Label();
        Label label_z1 = new Label("Z1 =");
        Label label_z2 = new Label("Z2 =");
        Button btn_plus = new Button("+");
        Button btn_difference = new Button("-");
        GridPane root = new GridPane();
        GridPane.setMargin(btn_plus, new Insets(10));
        GridPane.setMargin(btn_difference, new Insets(10));
        GridPane.setHalignment(label_z1, HPos.CENTER);
        GridPane.setHalignment(label_z2, HPos.CENTER);

        root.add(label_z1,0,0);
        root.add(label_z2,0,1);
        root.add(btn_plus,0,2);
        root.add(btn_difference,0,3);

        root.add(a1_text,1,0);
        root.add(a2_text,1,1);
        root.add(label_plus,1,2);
        root.add(label_difference,1,3);

        btn_plus.setOnAction(actionEvent -> {
            Expression Buf = new Expression(new Number(a1_text.getText()),new Number(a2_text.getText()),'+');
            label_plus.setText(Buf.process().toString());
        });
        btn_difference.setOnAction(actionEvent -> {
            Expression Buf = new Expression(new Number(a1_text.getText()), new Number(a2_text.getText()),'-');
            label_difference.setText(Buf.process().toString());
        });
        primaryStage.setTitle("Laba 2");
        primaryStage.setScene(new Scene(root, 200, 150));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
