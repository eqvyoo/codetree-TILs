import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        long answer = 0;
        long ldr;
        long mbr;
        long rest;
        Scanner sc = new Scanner(System.in);
        rest = sc.nextLong();
        long[] cust = new long[(int)rest];
        for (int i = 0; i < rest; i++){
            cust[i] = sc.nextLong();
        }
        ldr = sc.nextLong();
        mbr = sc.nextLong();

        for (int i = 0; i < rest; i++){
            if (cust[i] < ldr)
                answer += 1;
            else if ((cust[i] - ldr) % mbr == 0)
                answer += (cust[i] - ldr) / mbr + 1 ;
            else
                answer += (cust[i] - ldr) / mbr + 2;
        }
        System.out.println(answer);
    }
}