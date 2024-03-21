import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lesson arr[] = new Lesson[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Lesson lesson = new Lesson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = lesson;
        }

        Arrays.sort(arr, (l1, l2) -> l1.s == l2.s ? l1.t - l2.t : l1.s - l2.s);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0].t);

        for(int i = 1; i < arr.length; i++){
            if (pq.peek() <= arr[i].s){
                pq.poll();
            }
            pq.add(arr[i].t);
        }

        System.out.println(pq.size());

    }

    static class Lesson{
        int s;
        int t;
        Lesson(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
}
