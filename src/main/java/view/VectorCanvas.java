package view;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import model.shapes.Shape;

import java.util.List;

public class VectorCanvas extends TextField {
    private final Canvas canvas;
    private List<Shape> shapes;
    private Shape currentShape;

    public VectorCanvas() {
     setFocused(false);   
canvas = new Canvas(getWidth(), getHeight());
        getChildren().add(canvas);
        widthProperty().addListener(e -> canvas.setWidth(getWidth()));
        heightProperty().addListener(e -> canvas.setHeight(getHeight()));
    }
    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        refresh();

        // gc.setFill(Color.RED);
        //gc.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
//        gc.setStroke(new Color(10,10,20,255));
        // Paint your custom image here:
//        gc.drawImage(someImage, 0, 0);
    }

    public void refresh() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, getWidth(), getHeight());

        if(shapes!=null){
        for(Shape shape : shapes){
          //  gc.setFill(shape.getColor());
            shape.draw(gc);
        }}
        if(currentShape!=null){
            currentShape.draw(gc);
        }
    }

    public void setShapes(List<Shape> shapes) { this.shapes = shapes; }

    public void setCurrentShape(Shape currentShape) { this.currentShape = currentShape; }
}

