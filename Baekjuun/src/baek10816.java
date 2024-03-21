import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek10816 {
    static int arr1 [];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int result = upperBound(tmp) - lowerBound(tmp);
            sb.append(result + " ");
        }

        System.out.println(sb);


    }

    public static int lowerBound(int idx){
        int l = 0;
        int h = arr1.length;
        int m;

        while(l<h){
            m = (l+h) / 2;
            if (arr1[m] >= idx){
                h = m;
            }
            else{
                l = m + 1;
            }
        }
        return l;

    }
    public static int upperBound(int idx){
        int l = 0;
        int h = arr1.length;
        int m;
        while(l<h){
            m = (l+h) / 2;
            if (arr1[m] > idx){
                h = m;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }
}
