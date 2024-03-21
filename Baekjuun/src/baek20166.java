import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek20166 {
    static String map[][];
    static String arr[];
    static int dx []= {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy []= {0, -1, -1, -1, 0, 1, 1, 1};
    static int N, M, K, maxLen;
    static StringBuilder sb = new StringBuilder();
    static Map<String,Integer> hm = new HashMap<>();
//    static Map<String,Integer> m = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        arr = new String[K];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M; j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }

        maxLen = 0;
        for(int i = 0; i < K; i++){
            String ss = br.readLine();
            hm.put(ss,0);
            arr[i] = ss;
            maxLen = Math.max(maxLen,ss.length());
        }
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                bfs(j, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : arr)
        {
            sb.append(hm.get(s)).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        Queue<M> q = new LinkedList<>();
        q.add(new M(x,y,map[y][x]));

        while (!q.isEmpty()){
            M m = q.poll();
            if(m.ss.length()>maxLen){
                continue;
            }
            if(hm.containsKey(m.ss)) {
                hm.put(m.ss, hm.get(m.ss) + 1);
            }

            for(int i = 0; i < 8; i++){
                int nx = (m.x + dx[i]) % M;
                int ny = (m.y + dy[i]) % N;
                if(nx<0) nx += M;
                if(ny<0) ny += N;

                q.add(new M(nx, ny, m.ss + map[ny][nx]));
            }
        }
    }

    static class M {
        int x;
        int y;
        String ss;
        M(int x, int y, String ss){
            this.x = x;
            this.y = y;
            this.ss = ss;
        }
    }
}
