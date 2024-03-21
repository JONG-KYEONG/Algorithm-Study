import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class baek1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long sum = 0;

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minuos = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            plus.add(arr[i]);
        }
        boolean hasZero = false;

        while(!plus.isEmpty()){
            if(plus.peek()<1){
                if(plus.peek()==0) {
                    hasZero = true;
                    plus.poll();
                }
                else {
                    minuos.add(plus.poll());
                }

            }
            else if(plus.peek()==1){
                sum += plus.poll();
            }
            else {
                int first = plus.poll();
                if(plus.peek()!=null){
                    if(plus.peek()>1){
                        sum += first * plus.poll();
                    }
                    else {
                        sum += first;
                    }
                }
                else {
                    sum += first;
                }

            }
        }

        while(!minuos.isEmpty()){
            int first = minuos.poll();
            if(minuos.peek()!=null){
                sum += first * minuos.poll();
            }
            else {
                if(!hasZero)
                    sum += first;
            }
        }

        System.out.println(sum);
    }
}
