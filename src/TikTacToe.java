import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TikTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TikTacToe(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800,800);
    frame.getContentPane().setBackground(Color.red);
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);

    textfield.setBackground(new Color(25, 25, 25));
    textfield.setForeground(new Color(25, 0, 255));
    textfield.setFont(new Font("Serif", Font.BOLD, 75));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Tic-Tac-Toe");
    textfield.setOpaque(true);

    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0,0,800,100);

    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color(150, 150, 150));

    for(int i=0; i<9; i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }

    title_panel.add(textfield);
    frame.add(textfield, BorderLayout.NORTH);
    frame.add(button_panel);

    firstTurn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++){
            if (e.getSource()==buttons[i]){
                if(player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }

        }
    }

    public void firstTurn(){
        if(random.nextInt(2)==0){
            player1_turn= true;
            textfield.setText("X turn");
        }
        else {
            player1_turn= false;
            textfield.setText("O turn");
        }
    }

    public void check(){
        //check if tie
        if(
                (buttons[0].getText()=="O"|| buttons[0].getText()=="X" ) &&
                        (buttons[1].getText()=="O"|| buttons[1].getText()=="X" ) &&
                        (buttons[2].getText()=="O"|| buttons[2].getText()=="X" ) &&
                        (buttons[3].getText()=="O"|| buttons[3].getText()=="X" ) &&
                        (buttons[4].getText()=="O"|| buttons[4].getText()=="X" ) &&
                        (buttons[5].getText()=="O"|| buttons[5].getText()=="X" ) &&
                        (buttons[6].getText()=="O"|| buttons[6].getText()=="X" ) &&
                        (buttons[7].getText()=="O"|| buttons[7].getText()=="X" ) &&
                        (buttons[8].getText()=="O"|| buttons[8].getText()=="X" )
        ) {
            tie(0,1, 2, 3, 4 , 5, 6, 7, 8);
        }

        //check X wins conditions
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xwins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xwins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xwins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xwins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xwins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xwins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xwins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xwins(2,4,6);
        }
        // O wins
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            owins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            owins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            owins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            owins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            owins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            owins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            owins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            owins(2,4,6);
        }



    }



    public void xwins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    for(int i =0; i<9; i++){
        buttons[i].setEnabled(false);
        }
    textfield.setText("X wins!");

    }
    public void owins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i =0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins!");

    }

    public void tie(int a, int b, int c, int d, int e, int f, int g, int h, int j){
        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);
        buttons[d].setBackground(Color.red);
        buttons[e].setBackground(Color.red);
        buttons[f].setBackground(Color.red);
        buttons[g].setBackground(Color.red);
        buttons[h].setBackground(Color.red);
        buttons[j].setBackground(Color.red);
        for(int i =0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Tie!");

    }


}
