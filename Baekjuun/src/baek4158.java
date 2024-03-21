import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0)
                break;

            Map<Integer, Integer> m = new HashMap<>();

            for(int i = 0 ; i < N; i++){
                m.put(Integer.parseInt(br.readLine()), 0);
            }

            int cnt = 0;

            for(int i = 0; i < M; i++){
                if(m.containsKey(Integer.parseInt(br.readLine()))){
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
