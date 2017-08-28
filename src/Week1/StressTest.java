package Week1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class StressTest {
    static int getMaxPairwiseProduct1(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }


    static BigInteger getMaxPairwiseProduct2(int[] numbers) {

        BigInteger result = BigInteger.valueOf(0);
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                BigInteger multiplycn = BigInteger.valueOf(numbers[i]).multiply(BigInteger.valueOf(numbers[j]));
                if (  multiplycn.compareTo(result) == 1 ) {
                    result = multiplycn;
                }
            }
        }
        return result;
    }


    static BigInteger getMaxPairwiseProduct3(int[] numbers) {
        // Buggy : Doesn't considers condition when largest number is present multiple times
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

    static BigInteger getMaxPairwiseProduct5(int[] numbers) {
        int n = numbers.length;
        int max_index1 = -1;
        for (int a = 0; a < n; a++){
            if( max_index1 == -1 ){
                max_index1 = a;
            }else if( numbers[a] > numbers[max_index1] ){
                max_index1 = a;
            }
        }


        int max_index2 = -1;
        for( int b = 0; b < n; b++ ){
            if( ( b != max_index1 ) && (( max_index2 == -1 ) || ( numbers[b] > numbers[max_index2] )) ){
                max_index2 = b;
            }
        }


        return BigInteger.valueOf(numbers[max_index1]).multiply(BigInteger.valueOf(numbers[max_index2]));

    }

    static int getMaxPairwiseProduct4(int[] numbers) {
        int n = numbers.length;

//        int max_index1 = -1;
//        for (int i = 0; i < n ; i++) {
//            if( ( max_index1 == -1 ) || ( numbers[i] > numbers[max_index1] ) ){
//                max_index1 = i;
//            }
//        }
//
//        int max_index2 = -1;
//        for (int j = 0; j < n ; j++) {
//            if( ( ( max_index1 == -1 ) || ( numbers[j] > numbers[max_index2] ) ) && (numbers[j] != numbers[max_index2]) ){
//                max_index2 = j;
//            }
//        }

        // Buggy (doesn't considers two same largest numbers)
//        int largestNumber = 0;
//        for (int number : numbers) {
//            if (number > largestNumber) {
//                largestNumber = number;
//            }
//        }
//
//        int secondLargestNumber = 0;
//        for (int number : numbers) {
//            if((number > secondLargestNumber) && (number < largestNumber)){
//                secondLargestNumber = number;
//            }
//        }
//
//        return largestNumber * secondLargestNumber;

        int max_index1 = -1;
        for (int a = 0; a < n; a++){
            if( max_index1 == -1 ){
                max_index1 = a;
            }else if( numbers[a] > numbers[max_index1] ){
                max_index1 = a;
            }
        }


        int max_index2 = -1;
        for( int b = 0; b < n; b++ ){
            if( ( b != max_index1 ) && (( max_index2 == -1 ) || ( numbers[b] > numbers[max_index2] )) ){
                max_index2 = b;
            }
        }


        return numbers[max_index1] * numbers[max_index2];

    }

    public static void main(String[] args) {
        while(true){
            Random random = new Random();
            int n = random.nextInt(30) + 2;
            System.out.println(n + "\n");
            int[] numbers = new int[n];
            for (int a = 0; a < n; a++){
                int randomNum = ThreadLocalRandom.current().nextInt(1, 900);
                numbers[a] = randomNum;
                System.out.print(numbers[a] + " ");
            }
            System.out.println("\n");
            int a = getMaxPairwiseProduct4(numbers);
            BigInteger b = getMaxPairwiseProduct5(numbers);

            if( b.compareTo(BigInteger.valueOf(a)) != 0 ){ // Both are equal
                System.out.println("Wrong Answer: " + a + " " + b + "\n");
                break;
            }else{
                System.out.println("OK \n");
            }

        }

//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//
//        System.out.println(getMaxPairwiseProduct3(numbers));
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