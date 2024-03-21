import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek1920 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        HashSet<Integer> sh = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sh.add(Integer.parseInt(st.nextToken()));
        }


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            if(sh.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1 + "\n");
            }
            else{
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb);


    }

}
