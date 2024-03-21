import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baek1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(true){
            int f = pq.poll();
            int s;
            if(pq.isEmpty()){
                break;
            }
            else {
                s = pq.poll();
            }

            sum += f+s;
            pq.add(f+s);

        }
        System.out.println(sum);

    }
}
