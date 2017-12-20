package gui;

import application.Animation0;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static application.Constants.H;
import static application.Constants.W;

public class Main extends Application {

    public GraphicsContext graphicsContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        final URL url = getClass().getResource("gui.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        final AnchorPane anchor = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        BorderPane root = controller.root;
        Canvas canvas = new Canvas(W, H);
        graphicsContext = canvas.getGraphicsContext2D();
        Pane layerPane = new Pane();
        layerPane.getChildren().addAll(canvas);
        canvas.widthProperty().bind(layerPane.widthProperty());
        root.setCenter(layerPane);
        final Scene scene = new Scene(anchor, W, H);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test FXML");
        primaryStage.show();

        Animation0 anim = new Animation0(this);
        anim.start();
    }
}
