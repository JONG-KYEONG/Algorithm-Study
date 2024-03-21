import jdk.jfr.Unsigned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2417 {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        System.out.println(search());
    }
    static public long search(){
        int s = 0;
        int t = 32;
        int m;

        while(s<t){
            m = (s + t) / 2;
            long tmp = (long) Math.pow(2, m);

            if(tmp == N){
            }
            else if(tmp > N){
                t = m - 1;
            }
            else{
                s = m + 1;
            }

        }
        return (long) Math.pow(2, s);
    }
}
