Q2:Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
We can start from either array, but we can switch between arrays only through its common elements.

For example,

Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }  
The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100 
The maximum sum is 199
  
  Sution :

public class MaxSumPath {
    public static int maxSumPath(int[] array1, int[] array2) {
        int index1 = 0, index2 = 0;
        int sum1 = 0, sum2 = 0;
        int maxSum = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                maxSum += Math.max(sum1, sum2) + array1[index1];
                sum1 = 0;
                sum2 = 0;
                index1++;
                index2++;
            } else if (array1[index1] < array2[index2]) {
                sum1 += array1[index1++];
            } else {
                sum2 += array2[index2++];
            }
        }

        while (index1 < array1.length) {
            sum1 += array1[index1++];
        }

        while (index2 < array2.length) {
            sum2 += array2[index2++];
        }

        maxSum += Math.max(sum1, sum2);

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] array2 = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        System.out.println("Maximum sum path: " + maxSumPath(array1, array2));
    }
}
