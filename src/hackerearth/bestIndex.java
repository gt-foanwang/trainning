package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bestIndex {

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n;i++){
            int rowcount = rowCount(n-i);
            max = Math.max(max,countMumber(i, rowcount, arr));
        }
        System.out.println("max:"+ max);
    }
    public int rowCount(int totallen){
        int index = 1;
        for(int i = 1;i < totallen; i++){
            int area = (1+i)*i/2;
            if (area == totallen){
                index = i;
                break;
            }
            if (area > totallen){
                index = i-1;
                break;
            }
        }
        return  (1+index)*index/2;
    }

    public  int countMumber(int startIndex, int rowCount, int[] input){
        int count = 0;
        for(int i = 0; i < rowCount ;i++){
            count+=input[i+startIndex];
        }
        return count;
    }
}
