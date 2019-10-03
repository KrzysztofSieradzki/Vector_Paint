package model.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    private Color color;

    public Shape(Color color) { this.color = color; }

    public Shape() { color = Color.AQUA; }

    public abstract void draw(GraphicsContext gc);

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public abstract String convertToData();

}
