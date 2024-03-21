import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek1697 {
    static int n, k;
    static int arr[] = new int [100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(findBfs(n));
    }

    public static int findBfs(int n){
        int cnt = Integer.MAX_VALUE;
        Queue<Numb> q = new LinkedList<>();
        q.add(new Numb(n, 0));
        while(!q.isEmpty()){
            Numb numb = q.poll();
            if(numb.x == k){
                if(numb.cnt < cnt){
                    cnt = numb.cnt;
                    continue;
                }
            }
            int min = numb.x - 1;
            int plu = numb.x + 1;
            int mul = numb.x * 2;
            if(min >= 0 && min <= 100000) {
                if (arr[min] == 0) {
                    arr[min] = numb.cnt + 1;
                    q.add(new Numb(min, arr[min]));
                } else if (arr[min] > numb.cnt + 1) {
                    arr[min] = numb.cnt + 1;
                    q.add(new Numb(min, arr[min]));
                }
            }

            if(plu >= 0 && plu <= 100000) {
                if (arr[plu] == 0) {
                    arr[plu] = numb.cnt + 1;
                    q.add(new Numb(plu, arr[plu]));
                } else if (arr[plu] > numb.cnt + 1) {
                    arr[plu] = numb.cnt + 1;
                    q.add(new Numb(plu, arr[plu]));
                }
            }

            if(mul >= 0 && mul <= 100000) {
                if (arr[mul] == 0) {
                    arr[mul] = numb.cnt + 1;
                    q.add(new Numb(mul, arr[mul]));
                } else if (arr[mul] > numb.cnt + 1) {
                    arr[mul] = numb.cnt + 1;
                    q.add(new Numb(mul, arr[mul]));
                }
            }
        }
        return cnt;
    }

    static class Numb{
        int x;
        int cnt;
        Numb(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

}
