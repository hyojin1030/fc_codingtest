package algorithm;

public class Factorial {
    public int factorial(int n) {
        if(n > 1) {
            return n * this.factorial(n-1);
        } else {
            return 1;
        }
    }

    public int factorial2(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * this.factorial2(n-1);
        }
    }

    public int factorial3(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        }
        return this.factorial3(data-1) + this.factorial3(data-2) + this.factorial3(data-3);
    }

    public int factorial4(int data) {
        if (data <= 1) {
            return data;
        }

        return this.factorial4(data-1) + this.factorial4(data-2);
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial4(10));
    }
}
