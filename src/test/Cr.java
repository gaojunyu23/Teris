package test;
import java.util.Arrays;
public class Cr {
	public static void main(String[] args) {
		int[]a = {23,54,87,24,456,75,126,76,1,22};
		System.out.println(Arrays.toString(charu(a)));
	}
	public static int[]charu(int[] ary){
		
		for (int i = 1; i < ary.length; i++) {
			int temp = ary[i];
			int j = i - 1;
			while(temp < ary[j]){
				ary[j+1] = ary[j];
				j--;
				if(j == -1){
					break;
				}
			}
			ary[j+1] = temp;
		}
		return ary;
	}
}
