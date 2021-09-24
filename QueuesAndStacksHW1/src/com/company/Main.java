package com.company;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Main {

    public static void main(String[] args) {

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        Queue<Stack> sandingAndPolishing = new Queue<Stack>();
        Stack<Float> bucketOne = new Stack<Float>();
        Stack<Float> bucketTwo = new Stack<Float>();
        Stack<Float> bucketThree = new Stack<Float>();
        Stack<Float> tempBasket;

        sandingAndPolishing.enqueue(bucketOne);
        sandingAndPolishing.enqueue(bucketTwo);
        sandingAndPolishing.enqueue(bucketThree);

        for (int i = 0; i < 20; i++) {
            bucketOne.push((float) StdRandom.uniform(0.5, 1.0));
        }
        for (int i = 0; i < 15; i++) {
            bucketTwo.push((float) StdRandom.uniform(1.0, 1.5));
        }
        for (int i = 0; i < 10; i++) {
            bucketThree.push((float) StdRandom.uniform(1.5, 2.0));
        }

        float FinishingTime = 0;
        int numberOfRods = 0;
        int removedBaskets = 0;
        float secToMin;
        int n;
        int totalNumberOfRods = 0;
        float finalFinishingTime = 0;


        while (removedBaskets < 75 && numberOfRods <= 100) {
            if (sandingAndPolishing.peek().isEmpty()) {
                System.out.println("Execution stopped. Empty bin found");
                break;

            }
            tempBasket = sandingAndPolishing.dequeue();
            System.out.println("Removed bucket size = " + tempBasket.size());
            removedBaskets++;

            numberOfRods = tempBasket.size();
            while (!tempBasket.isEmpty()) {
                FinishingTime += tempBasket.pop();
            }

            secToMin = FinishingTime / (float) 60;
            totalNumberOfRods += numberOfRods;
            //Basket One
            n = Math.round(20 * secToMin);
            System.out.println("Number new of rods in basket 1: " + n);
            for (int i = 0; i < n; i++) {
                bucketOne.push((float) StdRandom.uniform(0.5, 1.0));
            }
            System.out.println("The size of bucket 1 now is: " + bucketOne.size());

            //Basket 2
            n = Math.round(15 * secToMin);
            System.out.println("Number of new rods in basket 2: " + n);
            for (int i = 0; i < n; i++) {
                bucketTwo.push((float) StdRandom.uniform(1.0, 1.5));
            }
            System.out.println("The size of bucket 2 now is: " + bucketTwo.size());

            //Basket 3
            n = Math.round(10 * secToMin);
            System.out.println("Number of new rods in basket 3: " + n);

            for (int i = 0; i < n; i++) {
                bucketThree.push((float) StdRandom.uniform(1.5, 2.0));
            }
            System.out.println("The size of bucket 3 now is: " + bucketThree.size());

            sandingAndPolishing.enqueue(tempBasket);
            StdDraw.filledRectangle(20.0, 0.0, 5, bucketOne.size());
            StdDraw.filledRectangle(40.0, 0.0, 5, bucketTwo.size());
            StdDraw.filledRectangle(60.0, 0.0, 5, bucketThree.size());
            StdDraw.show();
            StdDraw.pause(50);
            StdDraw.clear();


            finalFinishingTime += FinishingTime;
            FinishingTime = 0;
            System.out.println("-----------------------------------------------------------------------");

        }
        System.out.println("Number of buckets removed : " + removedBaskets);
        System.out.println("Total Finishing time: " + finalFinishingTime + "seconds or " + finalFinishingTime/60 + " minutes.");
        System.out.println("Rod count: " + numberOfRods);
        System.out.println("The total number of rods = " + totalNumberOfRods);
        System.out.println("Number of rods finished per minute: " + (totalNumberOfRods / finalFinishingTime)*60);
    }
}
