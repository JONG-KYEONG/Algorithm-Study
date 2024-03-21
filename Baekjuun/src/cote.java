import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean check [] = new boolean[N+1];
        String arr [] = new String[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < M; i++){
            arr[i] = st.nextToken();
        }

        HashSet<Integer> large = new HashSet<>();
        HashSet<Integer> small = new HashSet<>();

        for(int i = 0 ; i < M; i++){
            Queue<Integer> lq = new LinkedList<>();
            Queue<Integer> rq = new LinkedList<>();
            char sign = 0;
            boolean isRight = false;

            for(int j = 0; j < arr[i].length(); j++){
                char tmp = arr[i].charAt(j);
                if(tmp == '=' || tmp == '>' || tmp == '<') {
                    sign = tmp;
                    isRight = true;
                }
                else{
                    if(isRight){
                        rq.add(Integer.parseInt(String.valueOf(tmp)));
                    }
                    else{
                        lq.add(Integer.parseInt(String.valueOf(tmp)));
                    }
                }
            }

            if(sign == '='){
                while(!lq.isEmpty()){
                    check[lq.poll()] = true;
                }
                while(!rq.isEmpty()){
                    check[rq.poll()] = true;
                }
            }
            else if(sign == '<'){
                while(!lq.isEmpty()){
                    int tmp = lq.poll();
                    if(!check[tmp]){
                        if(large.contains(tmp)){
                            large.remove(tmp);
                            check[tmp] = true;
                        }
                        else if(!small.contains(tmp)) {
                            small.add(tmp);
                        }
                    }
                }
                while(!rq.isEmpty()){
                    int tmp = rq.poll();
                    if(!check[tmp]){
                        if(small.contains(tmp)){
                            small.remove(tmp);
                            check[tmp] = true;
                        }
                        else if(!large.contains(tmp)) {
                            large.add(tmp);
                        }
                    }
                }
            }
            else {
                while(!rq.isEmpty()){
                    int tmp = rq.poll();
                    if(!check[tmp]){
                        if(large.contains(tmp)){
                            large.remove(tmp);
                            check[tmp] = true;
                        }
                        else if(!small.contains(tmp)) {
                            small.add(tmp);
                        }
                    }
                }
                while(!lq.isEmpty()){
                    int tmp = lq.poll();
                    if(!check[tmp]){
                        if(small.contains(tmp)){
                            small.remove(tmp);
                            check[tmp] = true;
                        }
                        else if(!large.contains(tmp)) {
                            large.add(tmp);
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(!check[i])
                System.out.print(i + " ");
        }
    }
}
