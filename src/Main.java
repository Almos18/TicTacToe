import javax.swing.*;

public class Main {
    static char[][] field = new char[3][3];
    public static void main(String[] args)
    {
        String input;
        char player = 'O';
        boolean stopRound = false;
        String display;

        while (!stopRound)
        {
            player = 'O';
            display = "";
            input = JOptionPane.showInputDialog(null, "Where would O like to move? " +
                    "(Enter two numbers within the range 0-2)");
            validateInput(input, player);
            displayField(display);
            display = "";
            if(!checkWin())
            {
                player = 'X';
            input = JOptionPane.showInputDialog(null, "Where would X like to move? " +
                    "(Enter two numbers within the range 0-2)");
            validateInput(input, player);

            checkWin();
            displayField(display);
            }

            stopRound = checkWin();

        }
        JOptionPane.showMessageDialog(null, "The winner is " + player);
    }
    public static void displayField(String display)
        {
            StringBuilder displayBuilder = new StringBuilder(display);
            for (int i = 0; i<3; i++)
            {
                for (int j=0; j<3; j++)
                {
                    displayBuilder.append(field[j][i]).append(" ");
                }
                displayBuilder.append("\n");
            }
            display = displayBuilder.toString();
            JOptionPane.showMessageDialog(null, display);
        }

    public static void validateInput(String input, char player)
    {
        boolean valid = false;
        int x;
        int y;

        while(!valid)
        {
            valid = true;



            if (input.length()>2) {
                JOptionPane.showMessageDialog(null, "The input is too long");
                valid = false;
            }

            if ((Character.getNumericValue(input.charAt(0)) > 2) || Character.getNumericValue(input.charAt(1)) > 2) {
                JOptionPane.showMessageDialog(null, "Out of bounds, " +
                        "enter two numbers within the range 0-2");
                valid = false;
            }

            if(!valid)
            {
                input = JOptionPane.showInputDialog(null, "Please enter where you would like to go");
            }

        }
        x=Character.getNumericValue(input.charAt(0));
        y=Character.getNumericValue(input.charAt(1));
        field[x][y] = player;
    }

    public static boolean checkWin()
    {
        boolean checkHorizontals;
        boolean checkVerticals;
        boolean checkDiagonals;
        checkVerticals = ((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == 'X') ||
                ((field[0][0] == 'O') && (field[0][1] == 'O') && (field[0][2] == 'O') ||
                (field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == 'X') ||
                ((field[1][0] == 'O') && (field[1][1] == 'O') && (field[1][2] == 'O') ||
                ((field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == 'X') ||
                (field[2][0] == 'O') && (field[2][1] == 'O') && (field[2][2] == 'O')))));

        checkHorizontals = ((field[0][0] == 'X') && (field[1][0] == 'X') && (field[2][0] == 'X') ||
                ((field[0][1] == 'O') && (field[1][1] == 'O') && (field[2][1] == 'O') ||
                (field[0][2] == 'X') && (field[1][2] == 'X') && (field[2][2] == 'X') ||
                ((field[0][0] == 'O') && (field[1][0] == 'O') && (field[2][0] == 'O') ||
                ((field[0][1] == 'X') && (field[1][1] == 'X') && (field[2][1] == 'X') ||
                (field[0][2] == 'O') && (field[1][2] == 'O') && (field[2][2] == 'O')))));

        checkDiagonals = ((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X') ||
                ((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O') ||
                (field[2][0] == 'X') && (field[1][1] == 'X') && (field[0][2] == 'X') ||
                ((field[2][0] == 'O') && (field[1][1] == 'O') && (field[0][2] == 'O'))));

       return checkVerticals || checkHorizontals || checkDiagonals;


    }
}