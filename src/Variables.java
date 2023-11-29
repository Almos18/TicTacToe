import javax.swing.*;

public class Variables
{
    private char[][] field = new char[3][3];
    private char player = 'O';
    private int turn = 0;
    private boolean keepGoing = true;
    private JFrame jFrameWindow;
    private JButton btn00 = new JButton(), btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;

    public Variables()
    {
        setField(field);
        setPlayer(player);
        setTurn(turn);
        setKeepGoing(keepGoing);
    }

    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isKeepGoing() {
        return keepGoing;
    }

    public void setKeepGoing(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    public JFrame getjFrameWindow() {
        return jFrameWindow;
    }

    public void setjFrameWindow(JFrame jFrameWindow) {
        this.jFrameWindow = jFrameWindow;
    }

    public JButton getBtn00()
    {
        return btn00;
    }

    public void setBtn00(JButton btn00)
    {
        this.btn00 = btn00 = new JButton();
    }

    public JButton getBtn01() {
        return btn01;
    }

    public void setBtn01(JButton btn01) {
        this.btn01 = btn01;
    }

    public JButton getBtn02() {
        return btn02;
    }

    public void setBtn02(JButton btn02) {
        this.btn02 = btn02;
    }

    public JButton getBtn10() {
        return btn10;
    }

    public void setBtn10(JButton btn10) {
        this.btn10 = btn10;
    }

    public JButton getBtn11() {
        return btn11;
    }

    public void setBtn11(JButton btn11) {
        this.btn11 = btn11;
    }

    public JButton getBtn12() {
        return btn12;
    }

    public void setBtn12(JButton btn12) {
        this.btn12 = btn12;
    }

    public JButton getBtn20() {
        return btn20;
    }

    public void setBtn20(JButton btn20) {
        this.btn20 = btn20;
    }

    public JButton getBtn21() {
        return btn21;
    }

    public void setBtn21(JButton btn21) {
        this.btn21 = btn21;
    }

    public JButton getBtn22() {
        return btn22;
    }

    public void setBtn22(JButton btn22) {
        this.btn22 = btn22;
    }
}
