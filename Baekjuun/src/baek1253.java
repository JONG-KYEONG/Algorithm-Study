import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;

        for(int i = 0; i < N; i++){
            int s = 0;
            int t = N - 1;

            while(true){
                if(s==i)
                    s++;
                else if(t==i)
                    t--;

                if(s >= t) break;

                int sum = arr[s] + arr[t];

                if(sum==arr[i]){
                    result++;
                    break;
                }
                else if(sum>arr[i]){
                    t--;
                }
                else {
                    s++;
                }
            }
        }

        System.out.println(result);

    }
}
