import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baek2295 {
    static ArrayList<Integer> sum;
    static int arr [];
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(sum);

        find();

    }

    public static void find(){
        for(int i = N - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                int gap = arr[i] - arr[j];
                if(hasGap(gap)) {
                    System.out.println(arr[i]);
                    return;
                }

            }
        }
    }

    public static boolean hasGap(int gap){
        int s = 0;
        int t;
        int e = sum.size() - 1;

        while(s<e){
            t = (s + e)/2;
            if(sum.get(t) > gap){
                e = t - 1;
            }
            else if(sum.get(t) < gap){
                s = t + 1;
            }
            else if(sum.get(t) == gap){
                return true;
            }

        }
        return false;
    }
}
