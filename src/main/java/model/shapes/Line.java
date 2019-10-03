package model.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    public Line(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Line(Color color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.setStroke(getColor());
        gc.strokeLine(x,y,width,height);
    }
	@Override
	 public String convertToData() {
        return String.format("Line;%d;%d;%d;%d;%s", x, y, width, height, getColor().toString());
    }
}

