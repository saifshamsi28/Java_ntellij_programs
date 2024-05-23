package RationalNumbers;
class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public Rational add(Rational other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational divide(Rational other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    public String getFraction(){
        return (numerator+"/"+denominator);
    }
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class Main {
    public static void main(String[] args) {
        int n1=500,n2=1000;
        Rational num1 = new Rational(n1, n2);
        System.out.print("The Rational number of "+n1+"/"+n2+" is: ");
        System.out.println(num1.toString());  // Output: 1/2
        int n3=3,n4=4;
        Rational num2 = new Rational(n3, n4);
        // System.out.println(num2.toString());  // Output: 2/3

        Rational sum = num1.add(num2);
        System.out.print("The addition of fraction "+num1.getFraction()+" and "+n3+"/"+n4+" is : ");
        System.out.println(sum.toString());   // Output: 7/6

        Rational difference = num1.subtract(num2);
        System.out.print("The difference of fraction "+num1.getFraction()+" and "+n3+"/"+n4+" is : ");
        System.out.println(difference.toString());   // Output: 1/6

        Rational product = num1.multiply(num2);
        System.out.print("The multiplication of fraction "+num1.getFraction()+" and "+n3+"/"+n4+" is : ");
        System.out.println(product.toString());   // Output: 1/3

        Rational quotient = num1.divide(num2);
        System.out.print("The division of fraction "+num1.getFraction()+" and "+n3+"/"+n4+" is : ");
        System.out.println(quotient.toString());   // Output: 3/2
    }
}


