import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[] dp = new int[n+1]; // 다 0으로 초기화.
        for(int i = 1; i <= n; i++){
            int t = sc.nextInt();
            int p = sc.nextInt();
            dp[i] = Math.max(dp[i],dp[i-1]);
            if (i+t-1 <= n)
                dp[i+t-1] = Math.max(dp[i+t-1], dp[i-1] + p);
        }
        for (int i : dp){
            ans = Math.max(ans, i);
        }
        System.out.println(ans);

    }
}