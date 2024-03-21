import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baek2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String tmp = br.readLine();
        int [] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(String.valueOf(tmp.charAt(i)));
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            while(K > 0 && !dq.isEmpty() && dq.getLast() < arr[i]){
                dq.removeLast();
                K--;
            }
            dq.addLast(arr[i]);
        }

        while (dq.size() > K){
            sb.append(dq.removeFirst());
        }

        System.out.println(sb);
    }
}
