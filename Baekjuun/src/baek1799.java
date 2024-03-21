import java.io.*;
import java.util.*;

public class baek1799 {
    static int n, N;
    static int map[][];
    static int arrX[];
    static int arrY[];
    static int blackMax = 0;
    static int whiteMax = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        N = n*n;
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrX = new int[N+1];
        arrY = new int[N+1];

        getBlackMax(0,0, 0);
        getWhiteMax(0,1, 0);

        System.out.println(blackMax + whiteMax);
    }

    public static void getBlackMax(int depth, int x, int y) {
        if(x >= n){
            y++;
            if(y%2 == 0){
                x = 0;
            }
            else{
                x = 1;
            }
        }

        if(y >= n){
            blackMax = Math.max(blackMax,depth);
            return;
        }


        arrX[depth] = x;
        arrY[depth] = y;
        if(isPossible(depth)){
            getBlackMax(depth + 1,x + 2, y);
        }
        getBlackMax(depth, x + 2, y);
    }

    public static void getWhiteMax(int depth, int x, int y){
        if(x >= n){
            y++;
            if(y%2 == 0){
                x = 1;
            }
            else{
                x = 0;
            }
        }

        if(y >= n){
            whiteMax = Math.max(whiteMax,depth);
            return;
        }

        arrX[depth] = x;
        arrY[depth] = y;
        if(isPossible(depth)){
            getWhiteMax(depth + 1,x + 2, y);
        }
        getWhiteMax(depth, x + 2, y);
    }

    public static boolean isPossible(int cnt){
        if(map[arrY[cnt]][arrX[cnt]] == 0)
            return false;

        for(int i = 0 ; i < cnt; i++){
            int disX = Math.abs(arrX[i]-arrX[cnt]);
            int disY = Math.abs(arrY[i]-arrY[cnt]);
            if(disX==disY)
                return false;
        }
        return true;
    }
}