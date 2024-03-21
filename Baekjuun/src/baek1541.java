import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1541 {
    static String arr [];
    static int arr2 [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        arr = new String[50];
        arr2 = new int[50];


        int cnt = 0;
        for(int i = 0; i < st.length(); i++){
            if(st.charAt(i) == '+' || st.charAt(i) == '-') {
                cnt++;
                arr[cnt] = String.valueOf(st.charAt(i));
                cnt++;
            }
            else{
                if(arr[cnt] == null) {
                    arr[cnt] = String.valueOf(st.charAt(i));
                }
                else {
                    arr[cnt] = arr[cnt] + st.charAt(i);
                }
            }
        }

//        for(int i = 0; i < cnt; i++){
//            if(arr[i].equals("+")){
//                arr2[ccnt - 1] = arr2[ccnt - 1] + Integer.parseInt(arr[i + 1]);
//                ccnt--;
//                idx++;
//            }
//
//            idx++;
//            ccnt++;
//        }


//        for(int i = 0; i <= cnt; i++){
//            System.out.print(arr[i]);
//        }
//        System.out.println();

        int ccnt = 0;
        int idx = 0;
        while(idx <= cnt){
            if(arr[idx].equals("+")){
                arr2[ccnt - 1] = arr2[ccnt - 1] + Integer.parseInt(arr[idx + 1]);
                ccnt--;
                idx++;
            }
            else if (arr[idx].equals("-")){
                arr2[ccnt] = Integer.parseInt(arr[idx + 1]);
                idx++;
            }
            else{
                arr2[ccnt] = Integer.parseInt(arr[idx]);
            }

            idx++;
            ccnt++;
        }

        int sum = arr2[0];
        for(int i = 1; i < ccnt; i++){
            sum -= arr2[i];
        }


        System.out.println(sum);

    }
}
