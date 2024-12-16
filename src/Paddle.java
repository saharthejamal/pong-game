import javafx.scene.shape.Rectangle;

public class Paddle {
    private Rectangle shape;

    public Paddle(double x, double y, double width, double height) {
        shape = new Rectangle(x, y, width, height);
    }

    public void move(double dx) {
        shape.setX(shape.getX() + dx);
    }

    public Rectangle getShape() {
        return shape;
    }
}