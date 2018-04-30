package test;

import java.util.Arrays;
/**
 * Êý×é-Ã°ÅÝÅÅÐò
 * @author Mitsui No.14
 *
 */
public class Mp {
	public static void main(String[] args) {
		int[] arry = {23,45,1,34,67,43,78,232,454,241};
		for (int i = 0; i < arry.length; i++) {
			for (int j = 0; j < arry.length - i - 1; j++) {
				if(arry[j] > arry[j+1]){
					int t = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arry));
	}
}
