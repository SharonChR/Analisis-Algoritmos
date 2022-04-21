/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsetsum;
/**
 *
 * @author Sharon
 */
class DynamicSum {

    static int maxSum = 30000;
    static int arrSize = 25000;

    // variable to store
    // states of dp
    static int[][] dp = new int[arrSize][maxSum];
    static boolean[][] visit = new boolean[arrSize][maxSum];

    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    static int SubsetCnt(int i, int s, int arr[], int n) {
        // Base cases
        if (i == n) {
            if (s == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // Returns the value if a state is already solved
        if (visit[i][s + arrSize]) {
            return dp[i][s + arrSize];
        }

        // If the state is not visited, then continue
        visit[i][s + arrSize] = true;

        // Recurrence relation
        dp[i][s + arrSize] = SubsetCnt(i + 1, s + arr[i], arr, n)
                + SubsetCnt(i + 1, s, arr, n);

        // Returning the value
        return dp[i][s + arrSize];
    }

    // Driver function
    public static void main(String[] args) {
        //int arr[] = {1,-2,2,-3,5};
        int arr1[] = {1, -2, 2, -3, 5, 6, 12, 10, -4, -69, 84, 75, -61, 22, 85, 102, -635, 586, 894, -6477, 964, 123, 555, -6412, -5555, 852, -963, -987, -951, -753};
        int n = arr1.length  ;

        System.out.println(SubsetCnt(0, 0, arr1, n)-1);
    }
}
