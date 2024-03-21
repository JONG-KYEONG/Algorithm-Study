import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2573 {
    static int map[][];
    static int seaCnt[][];
    static int n, m;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Queue<Ice> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        seaCnt = new int[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)
                    q.add(new Ice(i,j,0));
            }
        }

//        countSeaCnt();
        System.out.println(melt());


    }

    public static int melt(){
        int tmp[][] = new int[n][m];
        int preCnt = 0;
        while(!q.isEmpty()){
            Ice ice = q.poll();
            if(ice.cnt>preCnt){
                preCnt = ice.cnt;
                for(int i = 0; i < n; i++)
                    map[i] = tmp[i].clone();
                if(isSepar())
                    return preCnt;

            }
            int cnt = 0;
            for(int i = 0 ; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] == 0)
                        cnt++;
                }
            }
            tmp[ice.x][ice.y] = map[ice.x][ice.y] - cnt;
            if(tmp[ice.x][ice.y] <= 0){
                tmp[ice.x][ice.y] = 0;
            }
            else {
                q.add(new Ice(ice.x, ice.y, ice.cnt + 1));
            }

        }
        return 0;
    }

    public static boolean isSepar(){
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++)
            arr[i] = map[i].clone();
        int sep = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 0){
                    sep++;
                    arr[i][j] = 0;
                    Queue<int[]> tmpq = new LinkedList<>();
                    tmpq.add(new int[]{i, j});
                    while(!tmpq.isEmpty()){
                        int [] tmp = tmpq.poll();
                        for(int c = 0 ; c < 4; c++) {
                            int nx = tmp[0] + dx[c];
                            int ny = tmp[1] + dy[c];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                                if(arr[nx][ny]!= 0){
                                    arr[nx][ny] = 0;
                                    tmpq.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        if(sep>1)
            return true;
        else
            return false;
    }


    static class Ice{
        int x;
        int y;
        int cnt;
        Ice(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
