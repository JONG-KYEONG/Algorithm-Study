import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1759 {
    static int L;
    static int C;
    static char code[];
    static char arr [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        makeCode(0,0);



    }

    public static void makeCode(int x, int cnt){

        if(cnt == L){
            if(check()){
                System.out.println(code);
            }
            return;
        }

        for(int i = x; i < C; i++){
            code[cnt] = arr[i];
            makeCode(i+1,cnt+1);
        }
    }

    public static boolean check(){
        int j = 0;
        int m = 0;

        for (int i = 0; i < L; i++){
            if(code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u')
                m++;
            else
                j++;
        }
        if(m>=1 && j >=2)
            return true;
        else
            return false;

    }
}
