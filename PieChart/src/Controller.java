

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Controller extends MouseAdapter
{
    private double lastAngleX;
    private double lastAngleY;

    private View view;
    private Model model;

    public void addView(View view)
    {
        this.view = view;
    }

    public void addModel(Model model)
    {
        this.model = model;
    }

    /// dump out x/y for debugging purposes
    @Override
    public void mousePressed(MouseEvent e)
    {
        Point p = e.getPoint();
        lastAngleX = e.getX();
        lastAngleY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        double curAngleX = e.getX();
        double curAngleY = e.getX();

        double deltaAngleX = curAngleX - lastAngleX;
        double deltaAngleY = curAngleY - lastAngleY;

        //update angle values in model
        model.updateAngleX(deltaAngleX);
        model.updateAngleY(deltaAngleY);

        view.repaint();

        lastAngleX = curAngleX;
        lastAngleY = curAngleY;
    }
}