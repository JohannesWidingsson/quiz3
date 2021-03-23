package quiz;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person implements Serializable {

    // Vi har flyttat över switchPlayer/startGame från denna klassen till Game klassen.
    // Vi ska städa undan lite i kod, och flytta över till Game, vi ska endast ha newPlayer och-
    // - konstrucktor , get,set metoder och variablerna som är privata för att skydda de.
    // Tanken är att Game klassen ska vara motor mekanismen i quiz spelet.
    // Rensa i main klassen. Så lite kod så möjligt.


    private int score = 0;
    private int playedGames = 0;


    Quiz quiz = new Quiz();

    //Scanner scanPlayer = new Scanner(System.in);

    LinkedList<Player> playerList = new LinkedList<>();

    public Player(String name, int age, String eMail, int score, int playedGames) {
        super(name, age, eMail);
        this.score = score;
        this.playedGames = playedGames;

    }

    public Player() {
    }

    public Player(String name, int age, String eMail) {
        super(name, age, eMail);
    }

    public void newPlayer() {

        Scanner scanPlayer = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name = scanPlayer.nextLine(); // lagras namnet
        // playerList.addFirst(name); //Trong hamnar på element 0
        System.out.println("Ålder: ");
        int age = scanPlayer.nextInt(); // lagras åldern
        //playerList.add(age);
        scanPlayer.nextLine();

        while (true) {
            System.out.println("E-mejl: ");
            String eMail = scanPlayer.nextLine(); //lagras email

            if (eMail.contains("@")) {
                playerList.add(new Player(name,age,eMail, score, playedGames));
                break;
            }
            System.out.println("Försök igen!");
        }

    }
    }



    void writePlayer() throws Exception, NotSerializableException, WriteAbortedException {

        FileOutputStream fos = new FileOutputStream("C:\\Users\\johannes\\Desktop\\Array\\array\\src\\quiz\\Files\\players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();

        System.out.println("Writeplayer success");

    }

    void readPlayer() throws Exception { // if (questList.length() <= )

        FileInputStream fis = new FileInputStream("C:\\Users\\johannes\\Desktop\\Array\\array\\src\\quiz\\Files\\players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<Player>) ois.readObject();
        ois.close();
        System.out.println("readPlayer success");

    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", playedGames=" + playedGames +
                ", quiz=" + quiz +
                ", playerList=" + playerList +
                '}';
    }

    public int getScore() {
        return score;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }
}