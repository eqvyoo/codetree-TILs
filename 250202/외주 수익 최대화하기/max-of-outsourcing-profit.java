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
            // 휴가 기간 내에 진행 불가능이라면, pass
            if (i+t-1 > n)
                continue;
            else {
                if (i<t && t <= n){
                    dp[i+t-1] = Math.max(dp[i+t-1], p);
                }
                if (i >= t)//가능한 것들 중,, 겹치지 않게.
                    dp[i+t-1] = Math.max(dp[i+t-1], p + dp[i-t]);
            }
        }
        for (int i : dp){
            ans = Math.max(ans, i);
        }
        System.out.println(ans);

    }
}