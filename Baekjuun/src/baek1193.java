import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int i;

        for(i = 1; i < 5000000; i++){
            sum += i;
            if(sum >= N)
                break;
        }

        int x = 1;
        int y = i;
        int di = sum - N;
        for(int j = 0; j < di; j++){
            x++;
            y--;
        }
        if(i%2 != 0)
            System.out.println(x + "/" + y);
        else
            System.out.println(y + "/" + x);
    }
}
