import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2839 {
    public static void main(String[] args){
        boolean [] arr = new boolean [10001];

        for(int i = 1; i <= 10000; i++){
            int tmp = i;
            int y = i/1000;
            tmp = tmp - y*1000;
            int z = tmp/100;
            tmp = tmp - z*100;
            int a = tmp/10;
            int b = tmp%10;
            if(i+y+z+a+b <= 10000){
                arr[i+y+z+a+b] = true;
            }
            else
                break;
        }

        for(int i = 1; i <= 10000; i++){
            if(!arr[i])
                System.out.println(i);
        }


    }
}
