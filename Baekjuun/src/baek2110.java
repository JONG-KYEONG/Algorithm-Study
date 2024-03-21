import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2110 {
    static int N, M;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(1, arr[N-1]-arr[0] + 1) - 1);
    }

    public static int binarySearch(int low, int high){
        int mid;

        while (low < high){
            mid = (low + high) / 2;
            int rcnt = locateRouter(mid);

            if(rcnt < M){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static int locateRouter(int dis){
        int cnt = 1;
        int preIdx = 0;

        for(int i = 1; i < N; i++){
            int check = arr[i] - arr[preIdx];

            if(check>=dis){
                preIdx = i;
                cnt++;
            }
        }

        return cnt;
    }

}
