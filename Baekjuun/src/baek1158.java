import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean visited [] = new boolean[N];
        int arr[] = new int[N];

        int cnt = 0;
        int idx = 0;

        while(cnt <N){
            int check = 0;
            while(true){
                if(!visited[idx]){
                    if(check == K -1) {
                        visited[idx] = true;
                        arr[cnt] = idx + 1;
                        cnt++;
                        break;
                    }
                    else {
                        check++;
                        idx = (idx+1) % N;
                    }
                }
                else {
                    idx = (idx+1) % N;
                }
            }
        }

        System.out.print("<");
        for(int i = 0; i < N; i++){
            System.out.print(arr[i]);
            if(i != N-1)
                System.out.print(", ");
        }
        System.out.print(">");


    }
}
