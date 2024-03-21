import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int C = Integer.parseInt(br.readLine());

            Map<String, Integer> m = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                m.put(st.nextToken(), j);
            }

            Map<Integer, Integer> m2 = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                m2.put(j, m.get(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            String arr [] = new String[C];
            for(int j = 0; j < C; j++) {
                arr[j] = st.nextToken();
            }
            String tmp [] = new String[C];
            for(int j = 0; j < C; j++) {
                int nw = m2.get(j);
                tmp[nw] = arr[j];
            }

            for(int j = 0; j < C; j++) {
                sb.append(tmp[j]);
                if(j != C-1){
                    sb.append(" ");
                }
                else {
                    sb.append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
