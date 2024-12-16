import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    private Ball ball;
    private Paddle paddle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        ball = new Ball(200, 200, 10);
        paddle = new Paddle(150, 450, 100, 20);

        // Add shapes to the pane
        root.getChildren().addAll(ball.getShape(), paddle.getShape());

        // Game loop
        Scene scene = new Scene(root, 400, 500);
        scene.setFill(Color.BLACK);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT: paddle.move(-15); break;
                case RIGHT: paddle.move(15); break;
            }
        });

        // Animation timer
        javafx.animation.AnimationTimer timer = new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.move();
                checkCollisions();
            }
        };
        timer.start();

        primaryStage.setTitle("Pong Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkCollisions() {
        // Ball hits walls
        if (ball.getShape().getCenterX() <= 0 || ball.getShape().getCenterX() >= 400) {
            ball.bounceX();
        }
        if (ball.getShape().getCenterY() <= 0) {
            ball.bounceY();
        }

        // Ball hits paddle
        if (ball.getShape().getBoundsInParent().intersects(paddle.getShape().getBoundsInParent())) {
            ball.bounceY();
        }

        // Ball falls below paddle (game over condition)
        if (ball.getShape().getCenterY() > 500) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}