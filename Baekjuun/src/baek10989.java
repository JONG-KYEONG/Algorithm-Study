import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int [10001];

        for(int i = 0 ; i < N ; i++){
            int T = Integer.parseInt(br.readLine());
            arr[T]++;
        }

        for(int i = 0 ; i < 10001; i++){
            for(int j = 0; j < arr[i]; j++){
                sb.append(i+"\n");
            }
        }
        System.out.print(sb);

    }
}
