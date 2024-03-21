import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            long f = pq.poll();
            long s = pq.poll();
            pq.add(f+s);
            pq.add(f+s);
        }

        long sum = 0;

        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}
