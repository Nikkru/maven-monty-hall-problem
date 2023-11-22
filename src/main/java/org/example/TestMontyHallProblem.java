package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class TestMontyHallProblem {
    private final static String PRIZE = "car";
    private final static String NO_PRIZE = "goat";
    private final static int NUMBER_CHECKS = 1000;
    static String[] doors = new String[]{PRIZE, NO_PRIZE, NO_PRIZE};
    private static Map<Integer, Boolean> testResult = new HashMap<>();
    private static Random random = new Random();

    private static int choice(String[] arrayDoors) {
        return random.nextInt(arrayDoors.length);
    }

    void testChoiceFromThreeDoors() {
        long countTrue = 0;
        long countFalls = 0;
        for (int i = 0; i < NUMBER_CHECKS; i++) {
            int didChoice = choice(doors);
            if (doors[didChoice] == PRIZE) {
                countTrue++;
            }
            testResult.put(i, doors[didChoice] == PRIZE);
        }
//        for (int i = 0; i < testResult.size(); i++) {
//            System.out.println(i + " " + testResult.get(i));
//        }
        countFalls = testResult.size() - countTrue;
        int gcd = ArithmeticUtils.gcd((int)countTrue / 100, (int)countFalls / 100);
        System.out.println("Из " + NUMBER_CHECKS + " попыток угадать одно из трех: удачные - " + countTrue);
        System.out.println("Из " + NUMBER_CHECKS + " попыток угадать одно из трех: неудачные - " + countFalls);
        System.out.println("Вероятность верного решения в процентах " + countTrue*100 / 1000 + " %");
    }

    public void testMontyChoice() {
        long countTrue = 0;
        long countFalls = 0;
        for (int i = 0; i < NUMBER_CHECKS; i++) {
            int didChoice = choice(doors);
            String[] doorsTmp = new String[]{PRIZE, NO_PRIZE};
            didChoice = choice(doorsTmp);
            if (doors[didChoice] == PRIZE) {
                countTrue++;
            }
            testResult.put(i, doors[didChoice] == PRIZE);
        }
        countFalls = testResult.size() - countTrue;
        int gcd = ArithmeticUtils.gcd((int)countTrue / 100, (int)countFalls / 100);
        System.out.println("Из " + NUMBER_CHECKS + " попыток угадать одно из трех по методу Монти Холла: удачные - " + countTrue);
        System.out.println("Из " + NUMBER_CHECKS + " попыток угадать одно из трех по методу Монти Холла: неудачные - " + countFalls);
        System.out.println("Вероятность верного решения в процентах " + countTrue * 100 / 1000 + " %");
    }

//    public static void main(String[] args) {
//        testChoiceFromThreeDoors();
//        testMontyChoice();
//    }
}
