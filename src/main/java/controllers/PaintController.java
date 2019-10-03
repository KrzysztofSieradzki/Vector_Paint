package controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;

import javafx.scene.paint.Color;
import model.Coordinates;
import model.CurrentSettings;
import model.shapes.Line;
import model.shapes.Oval;
import model.shapes.Rect;
import model.shapes.Shape;
import model.Tool;
import view.VectorCanvas;
import java.util.ArrayList;
import java.util.List;

public class PaintController {
    @FXML
    private Button buttonOvalTool;
    @FXML
    private Button buttonLineTool;
    @FXML
    private Button buttonRectangleTool;
    @FXML
    private VectorCanvas canvas;
    @FXML
    private ColorPicker colorPicker;

    private MouseHandler mouseHandler ;
    private Shape currentShape;
    private List<Shape> shapes = new ArrayList<>();
    private CurrentSettings settings = new CurrentSettings();
    public static final String BLUE_BACKGROUND = "-fx-background-color: blue;";

    @FXML
    private void initialize(){
        System.out.println("Startuje");
       mouseHandler = new MouseHandler(settings, new MouseHandler.OnShapeEventsListener() {
           @Override
           public void onShapeUpdated(Coordinates coo) {
               currentShape=createShape(coo);
               canvas.setCurrentShape(currentShape);
               canvas.refresh();
           }

           @Override
           public void onShapeCreated(Coordinates coo) {
               Shape shape = createShape(coo);
               shapes.add(shape);
               canvas.setShapes(shapes);
		currentShape = null;
                canvas.setCurrentShape(null);
               canvas.refresh();
           }
       });

        mouseHandler.setCanvasListener(canvas);
	colorPicker.setValue(settings.getColor());
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Color color =colorPicker.getValue();
                settings.setColor(color);
            }
        });
	refreshCurrentTool();
    }
    @FXML
    private void setOvalTool(ActionEvent event){
        settings.setCurrentTool(Tool.OVAL);

       refreshCurrentTool();

    }
    @FXML
    private void setLineTool(ActionEvent event){
        settings.setCurrentTool(Tool.LINE);

      refreshCurrentTool();
    }
    @FXML
    private void setRectTool(ActionEvent event){
        settings.setCurrentTool(Tool.RECT);

        refreshCurrentTool();
    }

	private void refreshCurrentTool() {
        switch (settings.getCurrentTool()) {
            case OVAL:
                buttonOvalTool.setStyle(BLUE_BACKGROUND);
                buttonLineTool.setStyle(null);
                buttonRectangleTool.setStyle(null);
                break;
            case LINE:
                buttonOvalTool.setStyle(null);
                buttonLineTool.setStyle(BLUE_BACKGROUND);
                buttonRectangleTool.setStyle(null);
                break;
            case RECT:
                buttonOvalTool.setStyle(null);
                buttonLineTool.setStyle(null);
                buttonRectangleTool.setStyle(BLUE_BACKGROUND);
                break;
        }
    }

    private Shape createShape(Coordinates coo) {
        switch(settings.getCurrentTool()){
           default:
            case RECT:
                return  createRectangle(coo);

            case LINE:
                return createLine(coo);
            case OVAL:
                return createOval(coo);
        }
    }

    private Shape createOval(Coordinates coo) {
        int x =coo.x1;
        int y = coo.y1;
        int width = coo.x2 - x;
        int height = coo.y2 - y;

        return new Oval(settings.getColor(),x,y,width,height);
    }

    private Shape createLine(Coordinates coo) {
        int x =coo.x1;
        int y = coo.y1;
        int width = coo.x2;
        int height = coo.y2;

        return new Line(settings.getColor(),x,y,width,height);
    }

    private Shape createRectangle(Coordinates coo) {
        int x =coo.x1;
        int y = coo.y1;
        int width = coo.x2 - x;
        int height = coo.y2 - y;

        return new Rect(settings.getColor(),x,y,width,height);
    }


}
