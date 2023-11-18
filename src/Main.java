import javax.swing.*;

public class Main {
    static char[][] field = new char[3][3];
    public static void main(String[] args)
    {
        String input;
        char player = 'O';
        boolean stopRound = false;
        String display = "";

        while (!stopRound)
        {
            player = 'O';
            display = "";
            input = JOptionPane.showInputDialog(null, "Where would O like to move? " +
                    "(Enter two numbers within the range 0-2)");
            setValue(input, player);
            displayField(display);
            display = "";
            stopRound = checkWin();

            if(!stopRound)
            {
                player = 'X';
            input = JOptionPane.showInputDialog(null, "Where would X like to move? " +
                    "(Enter two numbers within the range 0-2)");
            setValue(input, player);

            checkWin();
            }

            stopRound = checkWin();

            displayField(display);
            }
        JOptionPane.showMessageDialog(null, display + "The winner is " + player);
        }

        public static void displayField(String display)
        {
            for (int i=0; i<3; i++)
            {
                for (int j=0; j<3; j++)
                {
                    display += (field[i][j] + " ");
                }
                display += ("\n");
            }
            JOptionPane.showMessageDialog(null, display);
        }

    public static void setValue(String input, char player)
    {
        int x=Character.getNumericValue(input.charAt(0));
        int y=Character.getNumericValue(input.charAt(1));

        while((x > 2 || x < 0) || (y > 2 || y < 0))
        {
            input = JOptionPane.showInputDialog(null,"Out of bounds, " +
                    "enter two numbers within the range 0-2");
            x=Character.getNumericValue(input.charAt(0));
            y=Character.getNumericValue(input.charAt(1));
        }

        while(field[x][y] == 'X' || field[x][y] == 'O')
        {
            input = JOptionPane.showInputDialog(null,"The space is already occupied, " +
                    "please enter another");
            x=Character.getNumericValue(input.charAt(0));
            y=Character.getNumericValue(input.charAt(1));
        }
        field[x][y] = player;
    }

    public static boolean checkWin() {

        boolean checkHorizontals;
        boolean checkVerticals;
        boolean checkDiagonals;
        checkVerticals = (((Character.isLetter(field[0][0])) && (Character.isLetter(field[0][1])) &&
                (Character.isLetter(field[0][2]))) ||
                ((Character.isLetter(field[1][0])) && (Character.isLetter(field[1][1])) &&
                (Character.isLetter(field[1][2]))) ||
                ((Character.isLetter(field[2][0])) && (Character.isLetter(field[2][1])) &&
                (Character.isLetter(field[2][2]))));

        checkHorizontals = ((field[0][0] == 'X') && (field[1][0] == 'X') && (field[2][0] == 'X') ||
                ((field[0][0] == 'O') && (field[1][0] == 'O') && (field[2][0] == 'O') ||
                (field[0][1] == 'X') && (field[1][1] == 'X') && (field[2][1] == 'X') ||
                ((field[0][1] == 'O') && (field[1][1] == 'O') && (field[2][1] == 'O') ||
                (field[0][2] == 'X') && (field[1][2] == 'X') && (field[2][2] == 'X') ||
                (field[0][2] == 'O') && (field[1][2] == 'O') && (field[2][2] == 'O'))));

        checkDiagonals = ((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X') ||
                ((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O') ||
                (field[2][0] == 'X') && (field[1][1] == 'X') && (field[0][2] == 'X') ||
                ((field[2][0] == 'O') && (field[1][1] == 'O') && (field[0][2] == 'O'))));

       return checkVerticals || checkHorizontals || checkDiagonals;


    }
}