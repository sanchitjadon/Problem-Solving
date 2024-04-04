class Main {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public static int divTermCount(int a, int b, int c, int num) {
        return ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b))
                - (num / lcm(b, c))
                - (num / lcm(a, c))
                + (num / lcm(a, lcm(b, c))));
    }
    // Function to find the nth term divisible by a, b or c
    // by using binary search
    public static int findNthTerm(int a, int b, int c, int n) {

        // Set low to 1 and high to max (a, b, c) * n
        int low = 1, high = Integer.MAX_VALUE, mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            // If the current term is less than n then we need to increase low to mid + 1
            if (divTermCount(a, b, c, mid) < n)
                low = mid + 1;
            // If current term is greater than equal to  n then high = mid
            else
                high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int a = 2, b = 3, c = 5, n = 10;
        System.out.println(findNthTerm(a, b, c, n));
    }
}
