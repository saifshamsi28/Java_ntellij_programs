package SaifJavaPrograms;
public class VarArgs {
    //public static int sum(int...arr){  // this can take at least zero arguments
    // int ans=0;
    public static int sum(int x,int...arr){  // at least one argument must be given
        int ans=x;
        for(int i:arr){
            ans+=i;
        }
        return ans;
    }
    public static void main(String[] args) {

        // System.out.println("Sum of nothing is : "+sum()); // it will print zero if "sum()" of line 2 is
        // running but if you use this with "sum()" of line number 4 it will give error.
        // 4
        System.out.println("Sum of 5 and 6 is : "+sum(5,6));
        System.out.println("Sum of 5,3 and 6 is : "+sum(5,3,6));
        System.out.println("Sum of 5,2,7 and 6 is : "+sum(5,2,7,6));
        System.out.println("Sum of 5,8,9,3 and 6 is : "+sum(5,8,9,3,6));
    }
}
