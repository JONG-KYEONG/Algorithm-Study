import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1654 {
    static Long M;
    static int N;
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];

        for(int i = 0 ; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(1, arr[N-1], M));
    }
    public static long binarySearch(long low, long high, long value){
        long mid;
        while(low <= high){
            mid = (low + high) / 2;
            long cnt = getCnt(mid);

            if(cnt >= value){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low - 1;
    }
    public static long getCnt(long len){
        long cnt = 0;
        for(int i = 0 ; i < N ; i++){
            cnt += arr[i] / len;
        }
        return cnt;
    }
}
