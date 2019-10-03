package controllers;

import com.sun.istack.internal.NotNull;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Coordinates;

import model.CurrentSettings;
import model.Tool;
import view.VectorCanvas;

public class MouseHandler {


    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;


    @NotNull
    private OnShapeEventsListener listener;
    @NotNull
    private CurrentSettings settings;

    public MouseHandler(CurrentSettings settings, OnShapeEventsListener listener) {
        this.listener = listener;
        this.settings = settings;
    }

    public void setCanvasListener(VectorCanvas canvas){
        canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
                startX = (int) event.getX();
                startY = (int) event.getY();
            }
        });
        canvas.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
                endX = (int) event.getX();
                endY = (int) event.getY();
                Coordinates coo =createCoordinates();
                listener.onShapeCreated(coo);

            }
        });

        canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endX = (int) event.getX();
                endY = (int) event.getY();
                Coordinates coo =createCoordinates();
                listener.onShapeUpdated(coo);
            }
        });
    }

    protected Coordinates createCoordinates() {

        if(settings.getCurrentTool()== Tool.LINE){
            return new Coordinates(startX,startY,endX,endY);
        }
        int x1 = Math.min(startX,endX);
        int y1 = Math.min(startY,endY);
        int x2 = Math.max(startX,endX);
        int y2 = Math.max(startY,endY);
        return new Coordinates(x1,y1,x2,y2);
    }




    public interface OnShapeEventsListener{

        void onShapeCreated(Coordinates coo);
        void onShapeUpdated(Coordinates coo);
    }

}
