import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1010 {
    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B));




    }

    public static long pow(long A, long exponent) {

        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if(exponent == 1) {
            return A % C;
        }

        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        long temp = pow(A, exponent / 2);

        if(exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }

}
