import java.io. *;
import java.util. *;

public class baek1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[K];
        boolean use[] = new boolean[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int put = 0;
        for(int i = 0; i < K; i++){
            int tmp = arr[i];

            if(!use[tmp]){
                if(put < N){
                    use[tmp] = true;
                    put++;
                }
                else{
                    ArrayList<Integer> al = new ArrayList<>();
                    for (int j = i; j < K; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용되는지 확인.
                        if (use[arr[j]] && !al.contains(arr[j])) {
                            al.add(arr[j]);
                        }
                    }

                    if(al.size() < N){
                        for(int j = 0; j < use.length; j++){
                            if(use[j] && !al.contains(j)){
                                use[j] = false;
                                break;
                            }
                        }
                    }
                    else{
                        int rm = al.get(al.size()-1);
                        use[rm] = false;
                    }

                    use[tmp] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
