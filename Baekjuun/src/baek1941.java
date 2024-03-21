import java.io.*;
import java.util.*;

public class baek1941 {

    static String arr[][] = new String[5][5];
    static boolean visited[][] = new boolean[5][5];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 5; i ++){
            String tmp = br.readLine();
            for(int j = 0 ;j < 5; j++){
                arr[i][j] = String.valueOf(tmp.charAt(j));
            }
        }
        makePri(0,0);
        System.out.println(sum);
    }
    public static boolean checkPrincess(){
        boolean [][] tmp = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            tmp[i] = visited[i].clone();
        }

        int totalS = 0;
        int connect = 0;
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tmp[i][j]) {
                    x = i;
                    y = j;
                    if(arr[i][j].equals("S"))
                        totalS++;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        while(!q.isEmpty()){
            Point point = q.poll();
            x = point.x;
            y = point.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                    if(tmp[nx][ny]){
                        tmp[nx][ny] = false;
                        q.add(new Point(nx, ny));
                        connect++;
                    }
                }
            }
        }

        if(totalS >= 4 && connect == 7)
            return true;
        else
            return false;
    }

    public static void makePri(int depth, int f){
        if(depth == 7){
            if(checkPrincess())
                sum++;
        }
        else{
            for(int i = f; i < 25; i++){
                visited[i/5][i%5] = true;
                makePri(depth+1, i+1);
                visited[i/5][i%5] = false;
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
