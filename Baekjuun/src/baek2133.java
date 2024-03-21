import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[n+1];

        for(int i = 2; i <= n; i = i + 2){
            if(i > 4)
                break;
            if(i == 2)
                dp[i] = 3;
            else if(i==4)
                dp[i] = 11;
        }

        if(n%2 != 0){
            System.out.println(0);
        }
        else{
            for(int i = 6; i <= n; i = i + 2){
                dp[i] = 3 * dp[i-2] + 2 * dp[i-4] + 2;
            }
            System.out.println(dp[n]);
        }


    }
}
