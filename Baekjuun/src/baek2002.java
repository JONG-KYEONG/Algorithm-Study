import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baek2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            hm.put(br.readLine(),i);
        }
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            arr[i] = hm.get(tmp);
        }

        int cnt = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[i] > arr[j]){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
