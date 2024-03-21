    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class baek10815 {
        static int N, M;
        static int arr[];
        static StringBuilder sb1 = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M ; i++){
                binarySearch(0, N - 1, Integer.parseInt(st.nextToken()));
            }
            System.out.println(sb1);

        }

        public static void binarySearch(int low, int high, int value){
            int mid;

            while (low <= high){
                mid = (low + high) / 2;

                if (arr[mid] == value){
                    sb1.append(1 + " ");
                    return;
                }
                else if (arr[mid] > value){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            sb1.append(0 + " ");
        }
    }
