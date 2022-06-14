import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {

    private Button [][] buttons = new Button[8][8];
    GridPane layout  = new GridPane();

    @Override
    public void start(Stage stage) throws IOException {


        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(0, 10, 0, 10));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new Button(" ");
                layout.add(buttons[i][j], i, j);
            }
        }
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            World pyWorld = new World.Builder()
                    .alien(new Position(5,5))
                    .dandelion(new Position(0, 4))
                    .toadstool(new Position(4, 4))
                    .grass(new Position(4, 0))
                    .wolf(new Position(7, 7))
                    .sheep(new Position(0, 0))
                    .build(8, 8);

            @Override
            public void run() {
                pyWorld.makeTurn();
                Platform.runLater(() -> {
                    String result =  " ";
                    for (int wY = 0; wY < pyWorld.getWorldY(); wY++) {
                        for (int wX = 0; wX < pyWorld.getWorldX(); wX++) {
                            Organism org = pyWorld.getOrganismFromPosition(new Position(wX, wY));
                            if (org != null) {
                                result = org.getSign();
                            } else {
                                result = pyWorld.getSeparator();
                            }

                            Button button = buttons[wX][wY];
                            button.setText(result);
                        }
                    }
                });
            }
        };
        timer.schedule(task, 3000, 3000 );

        Scene scene = new Scene(layout, 800, 600);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }

}