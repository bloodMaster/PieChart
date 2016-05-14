
import java.awt.*;
import java.util.Random;

/**
 * @brief This class represents single slice data of pie chart
 *
 */
public class SliceData
{
    private int value;
    private Color color;

    /**
     * @brief ctor of SliceData value
     * @param slice value
     */
    public SliceData(int value)
    {
        Random numGen = new Random();
        int R =  numGen.nextInt(256);
        int G = numGen.nextInt(256);
        int B = numGen.nextInt(256);
        this.setColor(new Color(R,G,B));
        this.value = value;
    }

    /**
     * @brief function set color value
     * @param color value
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * @brief function get sliceData value
     * @return sliceData value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @brief function get collor
     * @return sliceData color
     */
    public Color getColor()
    {
        return color;
    }

} // class SliceData

