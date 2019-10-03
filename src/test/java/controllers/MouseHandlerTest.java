package controllers;

import model.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MouseHandlerTest {



    /*
    @Test
    public  void coordinatesFromTopLeftToBottomRight(){
        MouseHandler.OnShapeEventsListener listener =
                mock(MouseHandler.OnShapeEventsListener.class);

        MouseHandler handler = new MouseHandler(settings, listener);

        //given
        handler.startX=0;
        handler.startY=0;
        handler.endX=2;
        handler.endY=2;

        //when
        Coordinates coo = handler.createCoordinates();

        //then
        assertEquals(0,coo.x1);
        assertEquals(0,coo.y1);
        assertEquals(2,coo.x2);
        assertEquals(2,coo.y2);
    }

    @Test
    public  void coordinatesFromTopRightToBottomLeft(){
        MouseHandler.OnShapeEventsListener listener =
                mock(MouseHandler.OnShapeEventsListener.class);
        MouseHandler handler = new MouseHandler(settings, listener);

        //given
        handler.startX=5;
        handler.startY=0;
        handler.endX=0;
        handler.endY=5;

        //when
        Coordinates coo = handler.createCoordinates();

        //then
        assertEquals(0, coo.x1);
        assertEquals(0, coo.y1);
        assertEquals(5, coo.x2);
        assertEquals(5, coo.y2);
    }

    @Test
    public  void coordinatesFromBottonRightToTopLeft(){
        MouseHandler.OnShapeEventsListener listener =
                mock(MouseHandler.OnShapeEventsListener.class);
        MouseHandler handler = new MouseHandler(settings, listener);

        //given
        handler.startX=5;
        handler.startY=5;
        handler.endX=0;
        handler.endY=0;

        //when
        Coordinates coo = handler.createCoordinates();

        //then
        assertEquals(0, coo.x1);
        assertEquals(0, coo.y1);
        assertEquals(5, coo.x2);
        assertEquals(5, coo.y2);
    }*/

}