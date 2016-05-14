
public class Model {

    // mouse moving x/y angle
    private double angleX = 0;
    private double angleY = 0;

    // ellipse Major/Minor Radians
    private int ellipseMajorR;
    private int ellipseMinorR;

    // ellipse center coordinate
    private double ellipseCenterX;
    private double ellipseCenterY;

    /**
     * @brief function get ellipse major radios
     * @return ellipse major radios value
     */
    public int getEllipseMajorR()
    {
        return ellipseMajorR;
    }

    /**
     * @brief function set ellipse major radios
     * @param ellipse major radios value
     */
    public void setEllipseMajorR(int ellipseMajorR)
    {
        this.ellipseMajorR = ellipseMajorR;
    }

    /**
     * @brief function get ellipse minor radios
     * @return ellipse minor radios value
     */
    public int getEllipseMinorR()
    {
        return ellipseMinorR;
    }

    /**
     * @brief function set ellipse minor radios
     * @param ellipse minor radios value
     */
    public void setEllipseMinorR(int ellipseMinorR)
    {
        this.ellipseMinorR = ellipseMinorR;
    }

    /**
     * @brief function get ellipse origin X coordinate
     * @return  ellipse origin X coordinate
     */
    public double getEllipseCenterX()
    {
        return ellipseCenterX;
    }

    /**
     * @brief function set ellipse origin X coordinate
     * @param  ellipse origin X coordinate
     */
    public void setEllipseCenterX(double ellipseCenterX)
    {
        this.ellipseCenterX = ellipseCenterX;
    }

    /**
     * @brief function get ellipse origin Y coordinate
     * @return  ellipse origin Y coordinate
     */
    public double getEllipseCenterY()
    {
        return ellipseCenterY;
    }

    /**
     * @brief function set ellipse origin Y coordinate
     * @param  ellipse origin Y coordinate
     */
    public void setEllipseCenterY(double ellipseCenterY)
    {
        this.ellipseCenterY = ellipseCenterY;
    }

    /**
     * @brief function update rotating delta value of X coordinate
     * @param  delta angle value of X coordinate
     */
    void updateAngleX(double deltaAngleX)
    {
        this.angleX += deltaAngleX;
    }

    /**
     * @brief function update rotating delta value of Y coordinate
     * @param  delta angle value of Y coordinate
     */
    void updateAngleY(double deltaAngleY)
    {
        this.angleY += deltaAngleY;
    }

    /**
     * @brief function get rotating delta value of X coordinate
     * @return delta angle value of X coordinate
     */
    double getAngleX()
    {
        return angleX;
    }

    /**
     * @brief function get rotating delta value of Y coordinate
     * @return delta angle value of Y coordinate
     */
    double getAngleY()
    {
        return angleY;
    }

    /**
     * @brief function calculate drawing Poligyon(border) coordinates
     * @param start angle
     * @param drawing angle
     * @param drawing angle
     * @param calculated borders coordinated (X)
     * @param calculated borders coordinated (Y)
     */
    public void calculatePolygon(int startAngle, int angle, double angleX, int[] x, int[] y)
    {
        int SIZE = x.length;
        int j = 0;
        for (int i = startAngle; i < startAngle + angle; ++i) {
            float x1 = (float) (Math.cos(-Math.toRadians(i + angleX)) * ellipseMajorR / 2) + (float) ellipseCenterX;
            float y1 = (float) (Math.sin(-Math.toRadians(i + angleX)) * ellipseMinorR / 2) + (float) ellipseCenterY;
            x[j] = (int) x1;
            x[SIZE - j - 1] = (int) x1;
            y[j] = (int) y1;
            y[SIZE - j - 1] = (int) y1 + 20;
            ++j;
        }
    }

    /**
     * @brief function calculate start angle of pie chart
     * @param current value for starting computation
     * @param total value of slice
     * @param rotating angle
     * @return starting angle
     */
    public double calculateStartAngle(double currentValue, int total, int angleX)
    {
        return ((currentValue * 360) / total) + angleX;
    }

    /**
     * @brief function calculate slice drawing angle
     * @param slice value
     * @param total value of slices
     * @return
     */
    public double calculateDrawingAngle(double sliceValue, int total)
    {
        return (sliceValue * 360) / total;
    }
}
