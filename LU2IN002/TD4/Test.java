import java.util.Arrays;

public class Test{
	public static void main(String[] args){
		int[] t1 = {1,2,3};
		int[] t2 = {1,2,3};
		int[] t3 = t1;
		System.out.println(Arrays.equals(t1,t2));
		System.out.println(t1==t2);
		System.out.println(t1==t3);
	}
}
