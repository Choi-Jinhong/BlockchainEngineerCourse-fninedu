package Day_0528;

public class ForGuGu_07 {
    public static void main(String[] args) {
        for(int dan = 2; dan <= 4; dan++){
            System.out.println("*** " + dan + "단 ***");
            for(int i = 1; i <= 9; i++)
                System.out.println(dan + " X " + i + " = " + dan*i);
            System.out.println("");
        }
    }
}
