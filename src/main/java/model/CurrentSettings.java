package model;

import javafx.scene.paint.Color;

public class CurrentSettings {
    private Tool tool = Tool.LINE;
    private Color color = Color.AQUA;

    public Tool getCurrentTool() {
        return tool;
    }

    public void setCurrentTool(Tool tool) {
        this.tool = tool;
    }

    public void setColor(Color color) {
        this.color=color;
    }

    public Color getColor() {
        return color;
    }
}
