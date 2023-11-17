import javax.swing.*;

public class Main {
    static char[][] field = new char[3][3];
    public static void main(String[] args)
    {
        String input;
        char player = 'O';
        boolean winner = false;

        while(!winner) {
            input = JOptionPane.showInputDialog(null,"Where would O like to move? (Enter two numbers within the range 0-2)");
            setValue(input, player);
            player = 'X';

            input = JOptionPane.showInputDialog(null, "Where would X like to move? (Enter two numbers within the range 0-2)");
            setValue(input, player);
            player = 'O';

            winner = checkWin();
            System.out.println(winner);

            StringBuilder displayField = new StringBuilder();

            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    displayField.append(field[i][j]).append(" ");
                }
                displayField.append("\n");
            }
            JOptionPane.showMessageDialog(null, displayField.toString());
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

        while((x > 2 || x < 0) || (y > 2 || y < 0))
        {
            input = JOptionPane.showInputDialog(null,"Out of bounds, enter two numbers within the range 0-2");
            x=Character.getNumericValue(input.charAt(0));
            y=Character.getNumericValue(input.charAt(1));
        }

        while(field[x][y] == 'X' || field[x][y] == 'O')
        {
            input = JOptionPane.showInputDialog(null,"The space is already occupied, please enter another");
            x=Character.getNumericValue(input.charAt(0));
            y=Character.getNumericValue(input.charAt(1));
        }


        field[x][y] = player;
    }

    public static boolean checkWin() {

        boolean checkHorizontals;
        boolean checkVerticals;
        boolean checkDiagonals;
        checkVerticals = ((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == 'X') ||
                ((field[0][0] == 'O') && (field[0][1] == 'O') && (field[0][2] == 'O') ||
                (field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == 'X') ||
                ((field[1][0] == 'O') && (field[1][1] == 'O') && (field[1][2] == 'O') ||
                (field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == 'X') ||
                (field[2][0] == 'O') && (field[2][1] == 'O') && (field[2][2] == 'O'))));

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

       return (checkVerticals || checkHorizontals || checkDiagonals);

    }
}