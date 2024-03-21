import java.io.*;
import java.util.*;
public class baek1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ru[][] = new int [N][2];
        int bag[] = new int [K];
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ru[i][0] = Integer.parseInt(st.nextToken());
            ru[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i =0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ru, (o1, o2) -> {
            if(o2[0] == o1[0]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        long result = 0;
        int idx = 0;

        for(int i = 0; i < K; i++){
            while(idx < N && ru[idx][0] <= bag[i]){
                pq.add(ru[idx][1]);
                idx++;
            }
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);

    }

}
