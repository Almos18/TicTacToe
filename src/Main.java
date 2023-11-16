import java.util.Scanner;

public class Main {
    static char[][] field = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String input;
        char player = 'O';
        boolean winner = false;

        while(!winner) {
            System.out.println("Where would O like to move? (Enter two numbers between 0 and 2)");
            input = scanner.nextLine();
            setValue(input, player);
            player = 'X';

            System.out.println("Where would X like to move? (Enter two numbers between 0 and 2)");
            input = scanner.nextLine();
            setValue(input, player);

            winner = checkWin();
        }


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.print("\n");
        }



    }

    public static void setValue(String input, char player)
    {
        int x=Character.getNumericValue(input.charAt(0));
        int y=Character.getNumericValue(input.charAt(1));

            while(field[x][y] == 'X' || field[x][y] == 'O' )
            {
                System.out.println("The space is already occupied, please enter another");
                input = scanner.nextLine();
                x=Character.getNumericValue(input.charAt(0));
                y=Character.getNumericValue(input.charAt(1));
            }

        field[x][y] = player;
    }

    public static boolean checkWin() {

            if ((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == 'X')) {
                return true;
            }

            else if ((field[0][0] == 'O') && (field[0][1] == 'O') && (field[0][2] == 'O')) {
                return true;
            }

            else if ((field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == 'X')) {
                return true;
            }

            else if ((field[1][0] == 'O') && (field[1][1] == 'O') && (field[1][2] == 'O')) {
                return true;
            }

            else if ((field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == 'X')) {
                return true;
            }

            else if ((field[2][0] == 'O') && (field[2][1] == 'O') && (field[2][2] == 'O')) {
                return true;
            }


        return false;
    }
}