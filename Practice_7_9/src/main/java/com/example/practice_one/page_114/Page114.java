package com.example.practice_one.page_114;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Page114 {
    public static void show(){

        Stage stage = new Stage();
        stage.setTitle("Паровоз");

        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 300);

        for (int i = 0; i < 5; i++) {
            Circle wheel = new Circle(70 + i * 60, 220, 30);
            wheel.setFill(Color.BLACK);
            root.getChildren().add(wheel);
        }

        Rectangle rectangle = new Rectangle(35, 100, 225, 100);
        rectangle.setFill(Color.BLACK);
        root.getChildren().add(rectangle);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(250);
        rectangle1.setY(10);
        rectangle1.setWidth(100);
        rectangle1.setHeight(190);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.GRAY);
        root.getChildren().add(rectangle1);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(270);
        rectangle2.setY(30);
        rectangle2.setWidth(60);
        rectangle2.setHeight(70);
        rectangle2.setFill(Color.WHITE);
        rectangle2.setStroke(Color.BLACK);
        root.getChildren().add(rectangle2);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setX(350);
        rectangle3.setY(135);
        rectangle3.setWidth(20);
        rectangle3.setHeight(20);
        rectangle3.setFill(Color.BLACK);
        root.getChildren().add(rectangle3);

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(110);
        ellipse.setCenterY(35);
        ellipse.setRadiusX(19);
        ellipse.setRadiusY(12);
        ellipse.setFill(Color.TRANSPARENT);
        ellipse.setStroke(Color.BLACK);
        root.getChildren().add(ellipse);

        Ellipse ellipse1 = new Ellipse();
        ellipse1.setCenterX(135);
        ellipse1.setCenterY(30);
        ellipse1.setRadiusX(13);
        ellipse1.setRadiusY(11);
        ellipse1.setFill(Color.TRANSPARENT);
        ellipse1.setStroke(Color.BLACK);
        root.getChildren().add(ellipse1);

        Ellipse ellipse3 = new Ellipse();
        ellipse3.setCenterX(154);
        ellipse3.setCenterY(25);
        ellipse3.setRadiusX(11);
        ellipse3.setRadiusY(10);
        ellipse3.setFill(Color.TRANSPARENT);
        ellipse3.setStroke(Color.BLACK);
        root.getChildren().add(ellipse3);

        Ellipse ellipse4 = new Ellipse();
        ellipse4.setCenterX(170);
        ellipse4.setCenterY(25);
        ellipse4.setRadiusX(9);
        ellipse4.setRadiusY(9);
        ellipse4.setFill(Color.TRANSPARENT);
        ellipse4.setStroke(Color.BLACK);
        root.getChildren().add(ellipse4);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(70.0, 50.0,
                90.0, 200.0,
                110.0, 50.0);
        polygon.setFill(Color.BLACK);
        root.getChildren().add(polygon);

        stage.setScene(scene);
        stage.show();
    }
}

