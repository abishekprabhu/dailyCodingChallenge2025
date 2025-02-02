package Projects;

import java.util.*;

class Player{
    private String name;
    private double score;
    private int rank;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gamesDrawn;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.rank = 0;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.gamesDrawn = 0;
    }

    public String getName(){
        return this.name;
    }


    public void setScore(double score){
        this.score = score;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void setGamesPlayed(int gamesPlayed){
        this.gamesPlayed = gamesPlayed;
    }

    public void setGamesWon(int gamesWon){
        this.gamesWon = gamesWon;
    }

    public void setGamesLost(int gamesLost){
        this.gamesLost = gamesLost;
    }

    public void setGamesDrawn(int gamesDrawn){
        this.gamesDrawn = gamesDrawn;
    }

    public Double getScore(){
        return this.score;
    }

    public int getRank(){
        return this.rank;
    }

    public int getGamesPlayed(){
        return this.gamesPlayed;
    }

    public int getGamesWon(){
        return this.gamesWon;
    }

    public int getGamesLost(){
        return this.gamesLost;
    }

    public int getGamesDrawn(){
        return this.gamesDrawn;
    }
}

public class ChessTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================================================");
        System.out.println("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        //Number of Players
        List<Player> players = new ArrayList<>();
        System.out.println("===================================================================");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter the name of player" + (i + 1) + ": ");
            String name = scanner.next();
            Player player = new Player(name);
            players.add(player);
        }
        //Match History
        Map<Player, Set<String>> matchHistory = new HashMap<>();
        for (Player player : players) {
            matchHistory.put(player, new HashSet<>());
        }

        //Randomally generating the match history
        Random random = new Random();
        int round = 1;

        //check the players is odd
        int length = players.size();
        while (length-- > 1) {
            System.out.println("===================================================================");
            System.out.println("Round " + round + " of the tournament");
            List<Player> roundPlayers = new ArrayList<>(players);
            roundPlayers.sort((a, b) -> Double.compare(a.getScore(), b.getScore())); //sort the players based on the score;
            Stack<Player> unmatched = new Stack<>();

            //match among the players in the round and update the match history
            // points tie = 1 ; win = 2; loss = 0;
            for (int i = 0; i < roundPlayers.size(); i++) {
                Player player1 = roundPlayers.get(i);
                for (int j = i + 1; j < roundPlayers.size(); j++) {
                    Player player2 = roundPlayers.get(j);
                    if (!matchHistory.get(player1).contains(player2.toString()) && !matchHistory.get(player2).contains(player1.toString())) {
                        int result = random.nextInt(3);
                        if (result == 0) {
                            player1.setScore(player1.getScore() + 1);
                            player1.setGamesDrawn(player1.getGamesDrawn() + 1);
                            player2.setScore(player2.getScore() + 1);
                            player2.setGamesDrawn(player2.getGamesDrawn() + 1);
                        } else if (result == 1) {
                            player1.setScore(player1.getScore() + 2);
                            player1.setGamesWon(player1.getGamesWon() + 1);
                            player2.setScore(player2.getScore() + 0);
                            player2.setGamesLost(player2.getGamesLost() + 1);
                        } else {
                            player1.setScore(player1.getScore() + 0);
                            player1.setGamesLost(player1.getGamesLost() + 1);
                            player2.setScore(player2.getScore() + 2);
                            player2.setGamesWon(player2.getGamesWon() + 1);
                        }
                        player1.setGamesPlayed(player1.getGamesPlayed() + 1);
                        player2.setGamesPlayed(player2.getGamesPlayed() + 1);
                        matchHistory.get(player1).add(player2.toString());
                        matchHistory.get(player2).add(player1.toString());
                    }
                    // } else {
                    //     // unmatched.push(player2);
                    //     player2.setScore(player2.getScore() + 1);
                    //     System.out.println(player2.getName() + " gets 1 bonus point for not having a match in this round");
                    // }
                }
            }
            //unmatched to give 1 bonus point;
            // if (!unmatched.isEmpty()) {
            //     for (Player player : unmatched) {
            //         player.setScore(player.getScore() + 1);
            //         unmatched.pop();
            //         System.out.println("===================================================================");
            //         System.out.println(player.getName() + " gets 1 bonus point for not having a match in this round");
            //     }
            // }
            System.out.println("===================================================================");
            //Scores after the round
            System.out.println("Scores after round " + round);
            for (Player player : players) {
                System.out.println(player.getName() + " : " + player.getScore());
            }

            round++;
        }
        System.out.println("===================================================================");
        System.out.println("The tournament has ended");
        //Ranking the players
        players.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setRank(i + 1);
        }

        //Displaying the final result
        System.out.println("Final Results");
        for(Player player : players){
            System.out.println("===================================================================");
            System.out.println(player.getName() + " : " + player.getScore() + " points, " + player.getRank() + " rank, " + player.getGamesPlayed() + " games played, " + player.getGamesWon() + " games won, " + player.getGamesLost() + " games lost, " + player.getGamesDrawn() + " games drawn");
            System.out.println("===================================================================");
        }
    }
}
