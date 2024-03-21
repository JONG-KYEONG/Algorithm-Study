import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        for(int cnt = 0; cnt < str.length(); cnt++) {
            char x = str.charAt(cnt);
            if(x == 'c' && cnt+1 <str.length()){
                char x2 = str.charAt(cnt+1);
                if(x2 == '='){
                    cnt++;
                }
                else if(x2 == '-'){
                    cnt++;
                }
            }
            else if (x == 'd' && cnt+1 <str.length()) {
                char x2 = str.charAt(cnt+1);
                if(x2 == 'z'  && cnt+2 <str.length()){
                    char x3 = str.charAt(cnt+2);
                    if(x3 == '='){
                        cnt += 2;
                    }
                }
                else if(x2 == '-'){
                    cnt++;
                }
            }
            else if ((x == 'l' || x == 'n') && cnt+1 <str.length()) {
                char x2 = str.charAt(cnt+1);
                if(x2 == 'j'){
                    cnt++;
                }
            }
            else if ((x == 's' || x == 'z') && cnt+1 <str.length()) {
                char x2 = str.charAt(cnt+1);
                if(x2 == '='){
                    cnt++;
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
