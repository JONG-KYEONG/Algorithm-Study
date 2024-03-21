import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<String,Boolean> hm= new HashMap<String,Boolean>();

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")){
                hm.put(name, true);
            }
            else if(state.equals("leave")){
                hm.remove(name);
            }
        }
        ArrayList<String> al = new ArrayList<String>(hm.keySet());

        Collections.sort(al, Collections.reverseOrder());
        for (int i = 0; i < al.size(); i++){
            sb.append(al.get(i));sb.append('\n');
        }

        System.out.println(sb);
    }
}
