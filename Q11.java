// by Arad Firoozkuhi





import java.util.Scanner;
public class Q11 {

     static boolean isPrime(int n){
        if(n<=1)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return false;
        int nSqrt= (int) Math.floor(Math.sqrt(n));
        for(int i=3;i<=nSqrt;i+=2)
            if(n%i==0)
                return false;
            return true;
    }
     static String toBase(int inp,int newBase){
            return Integer.toString(inp,newBase);
    }
     static boolean isPalindrome(String in){
        char[] arr=in.toCharArray();
        for(int i=0;i<in.length()/2;i++)
            if(arr[i]!=arr[in.length()-i-1])
                return false;
            return true;
    }
     static boolean isShakh(int input,int shakhDegree){
        return isPrime(input)&&isPalindrome(toBase(input,shakhDegree));

    }

    public static void main(String[] args) {
	// write your code here
        int count=0;
        int input1,input2;
        Scanner sc=new Scanner(System.in);
        input1=sc.nextInt();
        input2=sc.nextInt();
        int i=2;
        while (count<input1){
            if(isShakh(i,input2))
                count++;
            i++;
        }
        System.out.print(i-1);
    }
}
