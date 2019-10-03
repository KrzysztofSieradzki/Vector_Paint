package model.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Rect(Color color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public void draw(GraphicsContext gc) {
       gc.setFill(getColor());
       gc.fillRect(x,y,width,height);
    }

    @Override
    public String toString() {
        return "Rect{" +
                "x= " + x +
                ", y= " + y +
                ", width= " + width +
                ", height= " + height +
                '}';
    }
	@Override
	public String convertToData() {
        return String.format("Rect;%d;%d;%d;%d;%s", x, y, width, height, getColor().toString());
    }
}
