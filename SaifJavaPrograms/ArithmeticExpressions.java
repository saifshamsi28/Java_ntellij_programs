package SaifJavaPrograms;

public class ArithmeticExpressions {
    public static void main(String[] args) {
        String exp="256+34-8*16/2+9";
        String []plusarr=exp.split("\\+");
int num=1;
        for(String a:plusarr){
            String []minusarr=a.split("\\-");
            for(String b:minusarr){
                String []mularr=b.split("\\*");
                for (String c:mularr){
                    String []divarr=c.split("\\/");

                    for (String d:divarr){
                        System.out.print(d+" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
