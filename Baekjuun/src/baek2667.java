import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class baek2667 {
    static int n;
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int sum = 0;
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    sum++;
                    al.add(bfs(i, j));
                }
            }
        }

        Collections.sort(al);

        System.out.println(sum);
        for(int i = 0; i < al.size(); i++)
            System.out.println(al.get(i));

    }

    public static int bfs(int x, int y){
        int cnt = 1;
        Queue<Cood> q = new LinkedList<>();
        q.add(new Cood(x,y));
        map[x][y] = 2;

        while (!q.isEmpty()){
            Cood cood = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = cood.x + dx[i];
                int ny = cood.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny <n){
                    if(map[nx][ny]==1){
                        map[nx][ny] = 2;
                        q.add(new Cood(nx,ny));
                        cnt++;
                    }
                }
            }
        }


        return cnt;
    }

    static class Cood{
        int x;
        int y;
        Cood(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
