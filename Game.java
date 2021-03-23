package quiz;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Game implements Serializable {

    Quiz quiz = new Quiz();
    Player player = new Player();
    Main main = new Main();
    // Ändra switchPlayer till startGame



    public void startGame() throws Exception{

        Scanner scanPlayer = new Scanner(System.in);

        //readPlayer();
        System.out.println("* * * * * * * * * * * *");
        System.out.println("Nu börjar spelet!");
        System.out.println("* * * * * * * * * * * *");
        new Time("game-thread").start();

        int idCounter = 0;


        for (int i = 0; i < quiz.questionList.size(); i ++) {
            Collections.shuffle(quiz.questionList);
            idCounter++;
            System.out.println("Gör dig redo " + player.playerList.get(0).getName());
            System.out.println(idCounter + ". " + quiz.questionList.get(i).getQuestion());
            //tiden startar på spelare 1

            String userInput = scanPlayer.nextLine();

            // Vad gör 'equalsIgnoreCase'?
            if (userInput.equalsIgnoreCase(quiz.questionList.get(i).getAnswer())) {
                System.out.println("Du svarade rätt! :) \n");
                //playerList.get(0).score++;

            } else {
                System.out.println("Du svarade fel :( \n");
            }
            Collections.shuffle(quiz.questionList);
            System.out.println("Gör dig redo " + player.playerList.get(1).getName());
            System.out.println(idCounter + ". " + quiz.questionList.get(i).getQuestion());
            //tiden startar för spelare 2
            String userInput2 = scanPlayer.nextLine();

            if (userInput2.equalsIgnoreCase(quiz.questionList.get(i).getAnswer())) {
                System.out.println("Du svarade rätt! :) \n");
                //playerList.get(1).score++;
            } else {
                System.out.println("Du svarade fel :( \n");
            }

        }




        // Grattis ****** vann!
        // Player 1: 2/3 rätt Tid: 7.3s
        // Player 2: 3/3 rätt Tid: 6.3s

       //System.out.println("Score for player 1: " + playerList.get(0).score + "/" + playerList.size());
        // System.out.println("Score for player 2: " + playerList.get(1).score);

    }




    void menuSwitch() {
        Scanner input = new Scanner(System.in);
       /* public SimpleThread (String str){
            super(str);
        new Time("Thread1 ").start();
        new Time("Thread2 ").start();*/

        while (true) {
            try {
                main.startMenu();
                int nr = input.nextInt();

                switch (nr) {
                    case 1:

                        player.newPlayer();
                        player.writePlayer();
                        player.readPlayer();
                        //Start time
                        startGame();
                        //End time
                        break;
                    case 2:
                        System.out.println("-------------------");
                        System.out.println("Lista av frågor");
                        System.out.println("-------------------");
                        quiz.readQuestion();
                        quiz.showList();
                        break;
                    case 3:
                        //quiz.readQuestion();
                        quiz.addQuestion();
                        quiz.writeQuestion();
                        break;
                    case 4:
                        quiz.readQuestion();
                        quiz.removeQuestion();
                        quiz.writeQuestion();
                        break;
                    case 5:
                        quiz.readQuestion();
                        quiz.editQuestion();
                        quiz.writeQuestion();
                        break;
                    case 0:
                        quiz.writeQuestion();
                        System.exit(0);
                    default:
                        System.out.println("Ange endast siffror mellan 0 och 5");
                        break;
                }
                quiz.pause();
            } catch (InputMismatchException e) {
                System.out.println("Ange endast siffror mellan 0 och 5");
                input.next();
                quiz.pause();
            } /*catch (NotSerializableException e) {
                System.out.println("Hello");
                //input.next();

            }*/catch (Exception e){
                e.printStackTrace();
            }
        }
    }




}
