package br.com.simulator;

import javafx.util.Pair;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class SWSimulator {

    private static Robot robot;
    private static Map<String, Pair<Integer, Integer>> steps = new HashMap<>();
    private static final int CENARIO = 0;
    private static final int ANCIENT = 1;
    private static final int MASMORRA = 2;
    private static final int RIFT = 3;
    private static final int TOA = 4;
    private static final int SIEGE = 5;



    public static void main(String[] args) throws Exception {
        robot = new Robot();

        boolean running = true;

        record(CENARIO);

        while (running) {
//            showMouse();
            Thread.sleep(3000);
            mouseEvents();

//      Thread.sleep(1000);

//      System.out.println("Finish");
        }

    }

    private static void showMouse() {
        System.out.println("X: "+ MouseInfo.getPointerInfo().getLocation().x);
        System.out.println("Y: "+ MouseInfo.getPointerInfo().getLocation().y);
    }

    private static void record(int config) {
        switch (config) {
            case CENARIO:
                steps.put("step:" + 0, new Pair<>(825, 616));
                steps.put("step:" + 1, new Pair<>(745, 769));
                steps.put("step:" + 2, new Pair<>(683, 592));
                steps.put("step:" + 3, new Pair<>(310, 813));
                steps.put("step:" + 4, new Pair<>(1316, 669));
                break;
            case ANCIENT:
                steps.put("step:" + 0, new Pair<>(825, 616));
                steps.put("step:" + 1, new Pair<>(745, 769));
                steps.put("step:" + 2, new Pair<>(683, 592));
                steps.put("step:" + 3, new Pair<>(1316, 669));
                break;
            case MASMORRA:
                steps.put("step:" + 0, new Pair<>(825, 616));
                steps.put("step:" + 1, new Pair<>(965, 769));
                steps.put("step:" + 2, new Pair<>(677, 569));
                steps.put("step:" + 3, new Pair<>(924, 790));
                steps.put("step:" + 4, new Pair<>(1316, 669));
                break;
            case RIFT:
                steps.put("step:" + 0, new Pair<>(847, 652));
                steps.put("step:" + 1, new Pair<>(850, 789));
                steps.put("step:" + 2, new Pair<>(493, 584));
                break;
            case TOA:
                steps.put("step:" + 0, new Pair<>(847, 752));
                steps.put("step:" + 1, new Pair<>(847, 852));
                steps.put("step:" + 2, new Pair<>(684, 583));
                steps.put("step:" + 3, new Pair<>(1274, 726));
                break;
            case SIEGE:
                steps.put("step:" + 0, new Pair<>(1312, 640));
                steps.put("step:" + 1, new Pair<>(1210, 746));
                break;

        }
    }

    private static void mouseEvents() throws InterruptedException {
        for (int i = 0; i < steps.size(); i++) {
            String key = "step:" + i;
            System.out.println(steps.get(key));
            System.out.println("X: " + steps.get(key).getKey());
            System.out.println("Y: " + steps.get(key).getValue());

            click(steps.get(key).getKey(), steps.get(key).getValue());
            Thread.sleep(1000);
        }


    }

    private static void click(int x, int y) {

        robot.mouseMove(x, y);
        robot.delay(50);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

    }

}
