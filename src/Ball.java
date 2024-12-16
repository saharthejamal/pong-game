import javafx.scene.shape.Circle;

public class Ball {
    private Circle shape;
    private double dx = 3, dy = 3; // Speed and direction

    public Ball(double x, double y, double radius) {
        shape = new Circle(x, y, radius);
    }

    public void move() {
        shape.setCenterX(shape.getCenterX() + dx);
        shape.setCenterY(shape.getCenterY() + dy);
    }

    public void bounceX() {
        dx = -dx;
    }

    public void bounceY() {
        dy = -dy;
    }

    public Circle getShape() {
        return shape;
    }
}