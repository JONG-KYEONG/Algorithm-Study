import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek1525 {
    static int dx [] = {-1, 0, 1, 0};
    static int dy [] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0){
                    sb.append("9");
                }
                else {
                    sb.append(tmp);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        q.add(sb.toString());
        m.put(sb.toString(),0);

        while(!q.isEmpty()){
            String temp = q.poll();
            int zero = temp.indexOf("9");
            int x = zero % 3;
            int y = zero / 3;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = ny * 3 + nx;

                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3){
                    StringBuilder nsb = new StringBuilder(temp);
                    char tmp = nsb.charAt(next);
                    nsb.setCharAt(zero,tmp);
                    nsb.setCharAt(next,'9');
                    String ns = nsb.toString();
                    if(!m.containsKey(ns)){
                        m.put(ns,m.get(temp)+1);
                        q.add(ns);
                    }
                }
            }
        }

        if(m.containsKey("123456789")){
           System.out.println(m.get("123456789"));
        }
        else{
            System.out.println(-1);
        }
    }
}
