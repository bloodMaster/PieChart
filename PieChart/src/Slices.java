
/**
 * @brief This class represents slices
 *
 */
public class Slices
{
    private SliceData[] sliceData;
    private int[] values;

    /**
     * @brief ctor if Slices class
     * @param arithmetic values of generating slices
     */
    public Slices(int[] values)
    {
        this.values = values;
        generateSlices();
    }

    /**
     * @grief function get generated slice size
     * @return size of generated slice
     */
    public int getSize()
    {
        return values.length;
    }

    /**
     * @brief function get sum slices total value
     * @return total value of slice
     */
    public int getSlicesTotalValue()
    {
        int total = 0;
        for ( int i = 0; i < sliceData.length; ++i ) {
            total += sliceData[i].getValue();
        }
        return total;
    }

    /**
     *  @brief function get SliceData from give index
     *  @param  index value
     *  @return return SliceData
     *  @todo need to check out of bound case
     */
    public SliceData getSliceData(int i)
    {
       return sliceData[i];
    }

    /**
     *  @brief function generate sliceData
     *  @note need to call only in ctor
     */
    private void generateSlices()
    {
        sliceData = new SliceData[values.length];
        for ( int i = 0; i < values.length; ++i ) {
            sliceData[i] = new SliceData(values[i]);
        }
    }

} // class Slices

