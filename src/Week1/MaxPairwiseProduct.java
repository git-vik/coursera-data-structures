package Week1;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {

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