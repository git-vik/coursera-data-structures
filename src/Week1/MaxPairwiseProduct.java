package Week1;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        // First Solution

//        int result = 0;
//        int n = numbers.size();
//        for (int i = 0; i < n; ++i) {
//            for (int j = i + 1; j < n; ++j) {
//                if (numbers[i] * numbers[j] > result) {
//                    result = numbers[i] * numbers[j];
//                }
//            }
//        }
//        return result;


        // Second Solution



//        BigInteger result = BigInteger.valueOf(0);
//        int n = numbers.length;
//        for (int i = 0; i < n; ++i) {
//            for (int j = i + 1; j < n; ++j) {
//                BigInteger multiplycn = BigInteger.valueOf(numbers[i]).multiply(BigInteger.valueOf(numbers[j]));
//                if (  multiplycn.compareTo(result) == 1 ) {
//                    result = multiplycn;
//                }
//            }
//        }
//        return result;


        // Third Solution


        int largestNumber = 0;
        for (int number : numbers) {
            if (number > largestNumber) {
                largestNumber = number;
            }
        }

        int secondLargestNumber = 0;
        for (int number : numbers) {
            if((number > secondLargestNumber) && (number < largestNumber)){
                secondLargestNumber = number;
            }
        }

        return BigInteger.valueOf(largestNumber).multiply(BigInteger.valueOf(secondLargestNumber));


        // Fourth Solution


        // int n = numbers.length;

        // int max_index1 = -1;
        // for (int i = 0; i < n ; i++) {
        //     if( ( max_index1 == -1 ) || ( numbers[i] > numbers[max_index1] ) ){
        //         max_index1 = i;
        //     }
        // }

        // int max_index2 = -1;
        // for (int j = 0; j < n ; j++) {
        //     if( (( max_index1 == -1 ) || ( numbers[j] > numbers[max_index2] )) && numbers[j] != numbers[max_index2] ){
        //         max_index2 = j;
        //     }
        // }

        // return numbers[max_index1] * numbers[max_index2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}