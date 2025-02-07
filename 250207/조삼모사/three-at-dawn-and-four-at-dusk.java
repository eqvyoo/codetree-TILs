import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] works;
    static int[] am;
    static int[] pm;
    static int[] visited;
    static int[] comb = new int[2];
    static int amSum;
    static int pmSum;

    // 1. 백트래킹으로 n/2개만 선택하는 함수
    static void choose(int k, int num){
        if (k == n/2){
            calcDiff();
            return;
        }
        for (int i = num; i < n; i++){
            visited[i] = 1;
            am[k] = i;
            choose(k+1, i+1);
            visited[i] = 0;
        }

    }

    // 2. 점수 차이 계산하는 함수
    static void calcDiff(){
        amSum = 0;
        pmSum = 0;

        int num = 0;

        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                pm[num] = i;
                num++;
            }
        }

        chooseTwo(0,0);
        ans = Math.min(ans, Math.abs(amSum - pmSum));

    }
    // 3. 두개의 좌표만 선택
    static void chooseTwo(int k, int num){
        if(k == 2){
            calcScore();
            return;
        }

        for (int i = num; i< n/2; i++){
            comb[k] = i;
            chooseTwo(k+1, i+1);
        }
    }
    
    // 4. 선택 된 좌표들의 점수를 답(sum)에 갱신하는 함수
    static void calcScore(){
        amSum += works[am[comb[0]]][am[comb[1]]] + works[am[comb[1]]][am[comb[0]]];
        pmSum += works[pm[comb[0]]][pm[comb[1]]] + works[pm[comb[1]]][pm[comb[0]]];
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        works = new int[n][n];
        
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                works[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        am = new int[n/2];
        pm = new int[n/2];
        visited = new int[n];

        choose(0,0);
        
        System.out.println(ans);


        }
    }