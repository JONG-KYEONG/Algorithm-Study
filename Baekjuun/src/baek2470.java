import java.io.*;
import java.util.*;

public class baek2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = N-1;

        int v1 = -1;
        int v2 = -1;
        int min = Integer.MAX_VALUE;

        while (i < j){
            int sum = arr[i] + arr[j];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                v1 = i;
                v2 = j;
            }
            if(sum > 0){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println(arr[v1] + " " + arr[v2]);

    }
}
