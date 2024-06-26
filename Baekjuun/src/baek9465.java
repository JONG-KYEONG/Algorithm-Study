import java.io.*;
import java.util.*;

public class baek9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int dp[][] = new int[2][n];
            int arr[][] = new int[2][n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(n>=2) {
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
            }

            for(int i = 2; i < n; i++){
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + arr[1][i];
            }

            sb.append(Math.max(dp[0][n-1], dp[1][n-1]) + "\n");
        }
        System.out.print(sb);
    }
}
