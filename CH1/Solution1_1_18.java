package CH1;

public class Solution1_1_18 {
    public static int mystery(int a, int b) {
       if (b == 0)     return 0;
       if (b % 2 == 0) return mystery(a+a, b/2);
       return mystery(a+a, b/2) + a;
    }
    
    public static int mystery2(int a, int b) {
        if (b == 0)     return 1;
        if (b % 2 == 0) return mystery2(a*a, b/2);
        return mystery2(a*a, b/2) * a;
     }
    
    public static void main(String[] args) {
    	int res1 = mystery(2, 25);
    	int res2 = mystery(3, 11);
    	int res3 = mystery2(2, 25);
    	int res4 = mystery2(3, 11);
    	System.out.println(res1);
    	System.out.println(res2);
    	System.out.println(res3);
    	System.out.println(res4);
    }
    
}
