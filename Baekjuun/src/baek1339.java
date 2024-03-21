import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            for(int j = 0; j < arr[i].length(); j++){
                char c = arr[i].charAt(j);
                int cnt = (int) Math.pow(10, arr[i].length() - j );
                if(hm.containsKey(c)){
                    hm.put(c,hm.get(c) + cnt);
                }
                else {
                    hm.put(c, cnt);
                }
            }
        }

        List<Character> al = new ArrayList<>(hm.keySet());

        al.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hm.get(o2).compareTo(hm.get(o1));
            }
        });

        for(int i = 0, j = 9; i < hm.size(); i++, j--){
            hm.put(al.get(i), j);
        }

        int sum = 0;

        for(int i = 0; i < N; i++){
            String s = "";
            for(int j = 0; j < arr[i].length(); j++){
                s = s + hm.get(arr[i].charAt(j));
            }
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);

    }
}
