import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek5014 {
    static int f,s,g,u,d;
    static int result;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int [f+1];

        result = floBfs();
        if(result == -1)
            System.out.println("use the stairs");
        else
            System.out.println(result);


    }
    public static int floBfs(){
        int min = Integer.MAX_VALUE;
        Queue<Flo> q = new LinkedList<>();
        q.add(new Flo(s,0));
        while (!q.isEmpty()){
            Flo flo = q.poll();
            if(flo.floor == g){
                min = Math.min(min,flo.cnt);
                continue;
            }
            int up = flo.floor + u;
            int down = flo.floor - d;
            if(up<=f) {
                if (arr[up] == 0) {
                    arr[up] = flo.cnt + 1;
                    q.add(new Flo(up, arr[up]));
                } else {
                    if (arr[up] > flo.cnt + 1) {
                        arr[up] = flo.cnt + 1;
                        q.add(new Flo(up, arr[up]));
                    }
                }
            }

            if(down>0) {
                if (arr[down] == 0) {
                    arr[down] = flo.cnt + 1;
                    q.add(new Flo(down, arr[down]));
                } else {
                    if (arr[down] > flo.cnt + 1) {
                        arr[down] = flo.cnt + 1;
                        q.add(new Flo(down, arr[down]));
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }
    static class Flo{
        int floor;
        int cnt;
        Flo(int floor, int cnt){
            this.floor = floor;
            this.cnt = cnt;
        }
    }
}
