import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            long dp[] = new long[n+1];
            for(int i = 0 ; i <= n; i++){
                if(i==6)
                    break;
                if(i<=3){
                    dp[i] = 1;
                }
                else{
                    dp[i] = 2;
                }
            }

            if(n<=5){
                sb.append(dp[n] + "\n");
            }
            else{
                for(int i = 6; i <= n; i++){
                    dp[i] = dp[i-1] + dp[i-5];
                }
                sb.append(dp[n] + "\n");
            }
        }
        System.out.print(sb);
    }
}
