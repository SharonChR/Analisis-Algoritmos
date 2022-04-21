/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsetsum;

import java.util.Arrays;

/**
 *
 * @author Sharon
 */
class DynamicSum {

    static int maxSum = 0;
    static int arrSize = 0;

    // variable to store
    // states of dp
    static int[][] dp; 
    static boolean[][] visit; 
    
    public static int metodo(int i, int s, int arr[], int n){
        maxSum = Math.abs(Arrays.stream(arr).sum()) *5;
        arrSize = arr.length *2;
        
        dp = new int[arrSize][maxSum];
        visit = new boolean[arrSize][maxSum];
        
        return SubsetCnt(i, s, arr, n) -1 ;
    }

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
        int arr1[] = {1, -2, 2, -3, 5, 6, 12, 10, -4, -69, 8, -35, 86, 94, -55, 82, -93, -87, -51, -53};
        int n = arr1.length  ;

        System.out.println(metodo(0, 0, arr1, n)-1);
    }
}
