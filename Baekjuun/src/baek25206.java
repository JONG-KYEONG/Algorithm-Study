import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        float credit = 0;
        float grade = 0;

        for (int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            float c = Float.parseFloat(st.nextToken());
            String g = st.nextToken();

            switch (g){
                case "A+" : grade += 4.5F * c; credit += c; break;
                case "A0" : grade += 4.0F * c; credit += c; break;
                case "B+" : grade += 3.5F * c; credit += c; break;
                case "B0" : grade += 3.0F * c; credit += c; break;
                case "C+" : grade += 2.5F * c; credit += c; break;
                case "C0" : grade += 2.0F * c; credit += c; break;
                case "D+" : grade += 1.5F * c; credit += c; break;
                case "D0" : grade += 1.0F * c; credit += c; break;
                case "F" : grade += 0.0F; credit += c; break;
                case "P" : break;
            }
        }

        System.out.println(grade/credit);

    }
}
