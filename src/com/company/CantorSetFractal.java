import java.applet.Applet;
import java.awt.*;

public class CantorSetFractal extends Applet {

    //              Name: Marcus J Cameron (mc17)
    //              Date: 2020-03-03
    //              Project Name: Cantor Set
    //              Course: ISC4U1
    //              About: Using recursions to draw a Cantor Set Fractal

    // image drawing fr
    public void paint(Graphics g) {
        //  init the first level
        int x[] = {100,700};
        int y[] = {10,40};

        // starting the cantor set
        cantor(x, y, 7);

    }

    // cantor set init function
    public void cantor(int x[], int y[], int n){
        // init the number of  levels
        cantorLevel(x, y, n - 1, n - 1);
    }

    public void cantorLevel(int x[], int y[], int n, int levels){

        // the top left point of the rectangle passed in the function
        int px = x[0];
        int py = y[0];

        int width = x[1] - x[0]; // the width of the rectangle
        int height =y[1] - y[0]; // the height of the rectangle
        int spacing = 10; // the spacing between each level

        Graphics g = getGraphics(); // getting the drawing component
        g.setColor(new Color(50 + n * 30, n * 35, n * 40)); // setting the color of each level
        g.fillRect(px, py, width, height); // drawing the rectangle passed through the function

        if(n < 1){ // base case


        }else{
            // finding the top left corner of the next level left rectangle
            Point p1 = new Point(x[0], (spacing * (levels - n + 2)) + height *  (levels - n + 1) );
            // finding the bottom right corner of the next level left rectangle
            Point p2 = new Point(x[0] + (width / 3), ((spacing * (levels - n + 2)) + height *  (levels - n + 2)));

            int x2[] = {p1.x, p2.x};
            int y2[] = {p1.y, p2.y };
            cantorLevel(x2, y2, n - 1, levels); // setting up the next cantor for the left side

            // finding the top left corner of the next level right rectangle
            Point p3 = new Point(x[0] + (width / 3) * 2, (spacing * (levels - n + 2)) + height *  (levels - n + 1) );
            // finding the bottom right corner of the next level right rectangle
            Point p4 = new Point(x[0] + width, ((spacing * (levels - n + 2)) + height *  (levels - n + 2)));

            int x3[] = {p3.x, p4.x};
            int y3[] = {p3.y, p4.y };
            cantorLevel(x3, y3, n - 1, levels); // // setting up the next cantor for the right side

        }

    }
}
