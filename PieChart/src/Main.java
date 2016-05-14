
import javax.swing.*;
import java.util.Scanner;

/**
 * @brief Entry point of app
 *
 */
public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Pie Chart size :");
        int size = s.nextInt();
        int [] a = new int[size];
        System.out.println("Enter value for every drawing pie value :");
        for( int i=0; i < size; ++i ){
            a[i] = s.nextInt();
        }
        Slices slices = new Slices(a);
        // Create main window
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        View view = new View(slices);
        view.setContentHeight(500);
        view.setContentWidth(500);
        frame.getContentPane().add(view);
        frame.setVisible(true);
    }
}


