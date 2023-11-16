import java.util.Scanner;

public class Main {
    static char[][] field = new char[3][3];

    public static void main(String[] args)
    {
        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Where would you like to move? (Enter two numbers between 0 and 2)");
        input = scanner.nextLine();
        setValue(input);
        /*for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.println(field[i][j]);
            }
        }*/



    }

    public static void setValue(String input)
    {
        int x = input.charAt(0);
        int y = input.charAt(1);
       // field
    }
}