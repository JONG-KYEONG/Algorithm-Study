import java.util. *;
import java.io. *;

public class baek15649 {
    static int arr[];
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        nm(0);
        System.out.print(sb);
    }

    public static void nm(int d){
        if(d==m) {
            for(int i = 0; i < m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            arr[d] = i;
            nm(d+1);
        }
    }
}
