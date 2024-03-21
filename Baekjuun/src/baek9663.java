import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek9663 {
    static int n;
    static int arr[];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int [n];
        back(0);
        System.out.println(sum);
    }

    public static void back(int depth){
        if(depth==n){
            sum++;
            return;
        }
        for(int i = 0; i < n; i++){
            arr[depth] = i;
            if(Possible(depth))
                back(depth+1);
        }
    }

    public static boolean Possible(int col){
        for(int i=0; i<col; i++){
            if(arr[col]==arr[i]){
                return false;
            }
            if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
