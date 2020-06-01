package com.company;

import javax.swing.*;
import java.awt.*;

public class PentaFractalDesgin extends JPanel {


    //              Name: Marcus J Cameron (mc17)
    //              Date: 2020-03-04
    //              Project Name: PentaFractalDesgin
    //              Course: ISC4U1
    //              About: Using recursions to draw a Penta Fractal Desgin

    JFrame window = new JFrame();


    public static void main(String[] args) {

        JPanel Fractal = new PentaFractalDesgin();
    }


    PentaFractalDesgin(){
//

        setFocusable(true);

        // Set up window
        window.setContentPane(this);
        window.setTitle(" Penta Fractal Desgin ");
        window.setSize(600,600 );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        paint();
        repaint();

    }

    // image drawing fr
    public void paint() {
        //  init the first level
        Point point = new Point(300,300);
        CreatePentaFractal(point, 5,300);
    }

    public void CreatePentaFractal(Point middelPoint,int numSides,  int sideLength){

        Point pentaPoints[] = new Point[numSides + 1];
        int angle = 360 / numSides ;

        for (int i = 0; i <= pentaPoints.length - 1; i++){
            double radians = Math.toRadians(angle * i);
            Point point = new Point(((int)(Math.cos(radians) * sideLength) + middelPoint.x),((int)(Math.sin(radians) * sideLength) + middelPoint.y));
            pentaPoints[i] = point;
        }

        fractal(pentaPoints, sideLength);
    }

    public void fractal(Point points[], int n){


        drawShape(points);



        if (n <= 0){

        }else {
//            System.out.print(points.length);
            Point newPentaPoints[] = new Point[points.length ];
            for (int i = 0; i <= points.length - 2; i++) {



                int slopeY = points[i + 1].y - points[i].y;
                int slopeX = points[i + 1].x - points[i].x;

                newPentaPoints[i] = new Point((int)(slopeX * 0.75 + points[i].x), ((int)(slopeY * 0.75 + points[i].y)));

//                System.out.print(newPentaPoints[i]);

            }
            int slopeY = points[0].y - points[points.length - 1].y;
            int slopeX = points[0].x - points[points.length - 1].x;

            newPentaPoints[points.length - 1] = new Point((int)(slopeX * 0.75 + points[points.length - 1].x), ((int)(slopeY * 0.75 + points[points.length - 1].y)));
//            System.out.print("\n\n");


            fractal(newPentaPoints, n - 15);
        }
    }

    public void drawShape(Point Points[]){
        Graphics g = this.getGraphics(); // getting the drawing component


        for (int i = 0; i <= Points.length - 2; i++) {

//                System.out.println(i);

                g.drawLine(Points[i].x, Points[i].y, Points[i + 1].x, Points[i + 1].y);
            }

            g.drawLine(Points[0].x, Points[0].y, Points[Points.length - 1].x, Points[Points.length - 1].y);
        }

}

