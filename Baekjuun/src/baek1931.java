import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1]==o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        int cnt = 0;
        int endT = 0;

        for(int i = 0; i < n; i++){
            if(endT <= arr[i][0]) {
                endT = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
