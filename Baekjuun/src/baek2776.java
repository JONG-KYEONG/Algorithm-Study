import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baek2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> hs = new HashSet<>();

            for(int j = 0; j < N; j++) {
                hs.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                if(hs.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1 + "\n");
                }
                else {
                    sb.append(0 + "\n");
                }

            }
        }

        System.out.println(sb);
    }
}
