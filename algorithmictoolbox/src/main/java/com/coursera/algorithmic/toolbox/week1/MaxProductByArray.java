package com.coursera.algorithmic.toolbox.week1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class MaxProductByArray {


    public static void main(String in[]) {

        ArrayScannerForProduct arrayScannerForProduct = new ArrayScannerForProduct(System.in);
        int totalCount = arrayScannerForProduct.nextInt();
        int[] totalNumbers = new int[totalCount];

        // Adding user inputs into array
        for(int i=0; i<totalCount; i++) {
            totalNumbers[i] = arrayScannerForProduct.nextInt();
        }

        // Calling function to execute business logic for the function
        System.out.println(getMaxPairwiseProductFast(totalNumbers));
    }

    /**
     * Retrieving two max elements from an array.
     * Product of two elements
     * @param totalNumbers
     * @return
     */
    static long getMaxPairwiseProductFast(int[] totalNumbers) {
        int sizeOfN = totalNumbers.length;

        // Retrieving first maximum element from the array
        int max_index1 = -1;
        for (int i = 0; i < sizeOfN; i++) {
            if ((max_index1 == -1) || (totalNumbers[i] > totalNumbers[max_index1]))
                max_index1 = i;
        }

        // Retrieving second maximum element from the array
        int max_index2 = -1;
        for (int j = 0; j < sizeOfN; j++) {
            if ((j != max_index1) && ((max_index2 == -1) || (totalNumbers[j] > totalNumbers[max_index2])))
                max_index2 = j;
        }

        return (long)totalNumbers[max_index1] * totalNumbers[max_index2];
    }


    /**
     * This is slowest method.
     * @param totalNumbers
     * @return
     */
    private static long getMaxProductFromArray(int[] totalNumbers) {
        long max_product = 0;
        int n = totalNumbers.length;
        try {
            for (int first = 0; first < n; ++first) {
                for (int second = first + 1; second < n; ++second) {
                    max_product = max(max_product, (long)totalNumbers[first] * (long)totalNumbers[second]);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return max_product;
    }
    static class ArrayScannerForProduct {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        ArrayScannerForProduct(InputStream stream) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.getMessage();
            }
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            return stringTokenizer.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }
}
