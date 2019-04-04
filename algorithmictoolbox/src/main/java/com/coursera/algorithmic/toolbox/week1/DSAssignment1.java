package com.coursera.algorithmic.toolbox.week1;

import java.util.Scanner;

public class DSAssignment1 {

    static int sumOfTwoInt(int first_digit, int second_digit) {
        return first_digit+ second_digit;
    }

    public static void main(String in[]) {
        Scanner scanner = new Scanner(System.in);
        int first_digit = scanner.nextInt();
        int second_digit = scanner.nextInt();
        System.out.println(sumOfTwoInt(first_digit, second_digit));
    }
}
