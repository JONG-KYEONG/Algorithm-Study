import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2644 {
    static int n, f, s, k;
    static boolean arr[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = true;
        }
        System.out.println(bfs2644());
    }

    public static int bfs2644(){
        visited[f] = true;
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(f,0));
        while (!q.isEmpty()){
            Num num = q.poll();
            if(num.x == s){
                return num.dis;
            }
            for(int i = 1; i < n+1; i++){
                if(arr[num.x][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(new Num(i, num.dis + 1));
                }
            }
        }
        return -1;
    }

    static class Num{
        int x;
        int dis;
        Num(int x, int dis){
            this.x = x;
            this.dis = dis;
        }
    }
}
