public class TowersOfHanoi {

    static public void move(int n, char source, char destination, char helper) {
        if (n == 1) {
            StdOut.printf("Move one disc from peg %c to peg %c\n", source, destination);
        }
        else {
            move(n - 1, source, helper, destination);
            move(1, source, destination, helper);
            move(n - 1, helper, destination, source);
        }
    }

    static public void main(String[] unused) {
        move(4, 'A', 'B', 'C');
    }

}
