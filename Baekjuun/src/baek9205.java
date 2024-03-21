import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek9205 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][3];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<BeerFest> q = new LinkedList<>();
            q.add(new BeerFest(startX,startY));

            boolean happy = false;
            while (!q.isEmpty()){
                BeerFest beerFest = q.poll();
                int enddis = Math.abs(endX - beerFest.x) + Math.abs(endY - beerFest.y);
                if(enddis <= 1000){
                    happy = true;
                    sb.append("happy" + "\n");
                    break;
                }
                for(int i = 0; i < n; i++){
                    int dis = Math.abs(arr[i][0] - beerFest.x) + Math.abs(arr[i][1] - beerFest.y);
                    if(dis <= 1000){
                        if(arr[i][2] == 0){
                            arr[i][2] = 1;
                            q.add(new BeerFest(arr[i][0], arr[i][1]));
                        }

                    }
                }
            }
            if(!happy)
                sb.append("sad" + "\n");
        }
        System.out.println(sb);
    }

    static class BeerFest{
        int x;
        int y;
        BeerFest(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
