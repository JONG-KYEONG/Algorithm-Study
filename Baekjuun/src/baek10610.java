import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        int size = N.length();
        int arr [] = new int[size];

        int sum = 0;
        Boolean hasZero = false;

        for(int i = 0; i < size; i++){
            int tmp = Integer.parseInt(String.valueOf(N.charAt(i)));
            sum += tmp;
            arr[i] = tmp;
            if(tmp == 0)
                hasZero = true;

        }

        Arrays.sort(arr);

        if(hasZero && sum % 3 == 0){
            for(int i = size - 1; i >= 0; i--){
                sb.append(arr[i]);
            }
        }
        else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
