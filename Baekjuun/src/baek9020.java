import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek9020 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++){
            findA(arr[i]);
        }

    }

    public static void findA(int x){
        int x1 = x/2;
        int x2 = x/2;
        while (x1>0){
            if(isPrime(x1) && isPrime(x2)) {
                System.out.println(x1 + " " + x2);
                return;
            }
            else {
                x1--;
                x2++;
            }
        }

    }

    public static boolean isPrime(int x){
        for(int i = 2; i < x; i++){
            if(x%i == 0)
                return false;
        }
        return true;
    }
}
