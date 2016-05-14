
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @brief This class represents View
 *
 */
class View extends JComponent {

    // model
    private  Model model;
    // Slices
    private Slices slices;
    // content dimention
    private int contentWidth;
    private int contentHeight;

    /**
     * @brief function get ellipse major radios
     * @return ellipse major radios
     */
    public int getEllipseMajorR()
    {
        return model.getEllipseMajorR();
    }

    /**
     * @brief function set ellipse major radios
     * @param  ellipse major radios value
     */
    public void setEllipseMajorR(int ellipseMajorR)
    {
        model.setEllipseMajorR(ellipseMajorR);
    }

    /**
     * @brief function get ellipse minor radios
     * @return get ellipse minor radios
     */
    public int getEllipseMinorR()
    {
        return model.getEllipseMinorR();
    }

    /**
     * @brief function set ellipse minor radios
     * @param  ellipse minor radios value
     */
    public void setEllipseMinorR(int ellipseMinorR)
    {
        model.setEllipseMinorR(ellipseMinorR);
    }

    /**
     * @brief function get origin drawing x coordinate
     * @param  drawing element x coordinate
     */
    private int getOriginX()
    {
        return  contentWidth / 4;
    }

    /**
     * @brief function get origin drawing y coordinate
     * @param  drawing element y coordinate
     */
    private int getOriginY()
    {
        return  contentHeight / 2;
    }

    /**
     * @brief function set content height
     * @param height value
     */
    public void setContentHeight(int h)
    {
        contentHeight = h;
    }

    /**
     * @brief function set content width
     * @param  width value
     */
    public void setContentWidth(int w)
    {
        contentWidth = w;
    }

    /**
     * @brif View class ctor
     * @param Slices should be drawing
     */
    public View(Slices slices)
    {
        this.slices = slices;
        Controller controller = new Controller();
        controller.addView(this);

        this.model = new Model();
        controller.addModel(model) ;

        addMouseListener(controller);
        addMouseMotionListener(controller);

        // default value for ellipse
        model.setEllipseMajorR(300);
        model.setEllipseMinorR(100);
    }

    /**
     * @brif function call as delegate function for rendering
     * @param Graphics value
     */
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D e = new Ellipse2D.Double(getOriginX(), getOriginY(),
                                           model.getEllipseMajorR(),
                                           model.getEllipseMinorR());

        model.setEllipseCenterX(e.getCenterX());
        model.setEllipseCenterY(e.getCenterY());
        drawPie(g2);
    }

    /**
     * @brief function draw pie chart
     * @param Graphics value
     */
    public void drawPie(Graphics2D g)
    {
        // slices total value
        int total = slices.getSlicesTotalValue();

        //get angleX/angleY from model
        double angleX = model.getAngleX();
        double angleY = model.getAngleY();

        int currentValue = 0;
        double startAngle = 0;
        double accumulativeAngle = 0;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.6f));
        for (int i = 0; i < slices.getSize(); ++i) {
            SliceData slice = slices.getSliceData(i);
            startAngle = model.calculateStartAngle(currentValue, total, (int)angleX);
            double arcAngle = model.calculateDrawingAngle(slice.getValue(), total);
            drawSlice(startAngle, arcAngle, slice.getColor(), g);
            drawBorder(accumulativeAngle, arcAngle, angleX, g);
            accumulativeAngle += arcAngle;
            currentValue += slice.getValue();
        }
    }

    /**
     * @brief function draw border of pie chart
     * @param start drawing angle
     * @param angle for drawing
     * @param rotating angle
     * @param Graphics
     */
    private void drawBorder(double startAngle, double angle, double angleX, Graphics2D g)
    {
        int alfa = (int)Math.floor(angle + 0.5) + 1;
        int size = 2 * alfa;
        int [] x = new int[size];
        int [] y = new int[size];
        model.calculatePolygon((int)Math.floor(startAngle + 0.5), alfa, angleX, x, y);
        g.fillPolygon(new Polygon(x, y, x.length));
    }

    /**
     * @brief function draw slice of pie chart
     * @param start drawing angle
     * @param angle for drawing
     * @param slice color
     * @param Graphics
     */
    private void drawSlice(double startAngle, double angle, Color color, Graphics2D g)
    {
        g.setColor(color);
        g.fillArc(getOriginX(), getOriginY(), model.getEllipseMajorR(), model.getEllipseMinorR(),
                (int)Math.floor(startAngle + 0.5), (int)Math.floor(angle + 0.5));
    }

} // class View

