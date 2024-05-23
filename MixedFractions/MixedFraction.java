package MixedFractions;
class MixedFraction {
    int num,denom,quotient,remainder;
    public MixedFraction(int num,int denom){
        this.num=num;
        this.denom=denom;
    }
    public void getMixedFraction(){
        quotient=num/denom;
        remainder=num%denom;
        System.out.println("The mixed fraction of "+num+"/"+denom+" is : "+quotient+" "+remainder+"/"+denom);
    }
}
class ImproperFraction{
    public static void main(String s[]){
        MixedFraction f1=new MixedFraction(7,4);
        MixedFraction f2=new MixedFraction(12,10);
        MixedFraction f3=new MixedFraction(20,3);
        f1.getMixedFraction();
        f2.getMixedFraction();
        f3.getMixedFraction();
//        MixedFraction f4=new MixedFraction(7,4);
    }
}
