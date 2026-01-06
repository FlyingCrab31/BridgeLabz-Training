
import java.util.Scanner;

class Solution {

    public int differenceOfSums(int n, int m) {
        int sumOfNonDivisible = 0;
        int sumOfDivisible = 0;
        for(int i = 1 ; i <= n ; i++){
            if(i % m != 0) sumOfNonDivisible += i;
            else if(i % m == 0) sumOfDivisible += i;
        }
        int res = sumOfNonDivisible - sumOfDivisible;
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.differenceOfSums(n, m));
    }
}