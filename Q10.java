// by Mohammad Mahdi Malmasi




import java.util.ArrayList;
import java.util.Scanner;




class Player
{
    String name;
    long price;
    long speed;
    long finishing;
    long defence;
    boolean isInTeam = false;




    public Player(String name, long...details)
    {
        this.name = name;
        price = details[0];
        speed = details[1];
        finishing = details[2];
        defence = details[3];
    }
}


class Team
{
    String name;
    long money; 
    ArrayList<Player> teamPlayers;

    long wins = 0;
    long draws = 0;
    long looses = 0;



    public Team(String name, long money)
    {
        this.name = name;
        this.money = money;
        this.teamPlayers = new ArrayList<>();
    }
}



public class Q10
{
    static String[] inputs;
    static Scanner in = new Scanner(System.in);
    static String whatToDo;

    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Team> teams = new ArrayList<>();



    public static void main(String[] args) 
    {
        boolean end = false;

        while (!end)
        {
            readInputs();
            if (inputs.length == 0)
                continue;

            
            switch(whatToDo)
            {
                case "new":

                    if (inputs[1].equals("player"))
                        players.add(new Player(inputs[2], Long.parseLong(inputs[3]), Long.parseLong(inputs[4]), 
                                                          Long.parseLong(inputs[5]), Long.parseLong(inputs[6])));

                    else
                        teams.add(new Team(inputs[2], Long.parseLong(inputs[3])));

                break;


                case "buy":
                    buyPlayer();
                break;


                case "sell":
                    sellPlayer();
                break;


                case "match":
                    match();
                break;


                case "rank":
                    rank();
                break;


                case "end":
                    end = true;
                break;


                default:
                    continue;
            }
        }
    }



    private static void readInputs()
    {
        inputs = in.nextLine().split(" ");
        whatToDo = inputs[0];
    }


    private static void buyPlayer()
    {
        int playerId = Integer.parseInt(inputs[1]);
        playerId--;
        int teamId = Integer.parseInt(inputs[2]);
        teamId--;

        if (playerId < 0 || playerId > players.size()-1)
        {
            System.out.println("player with the id " + (playerId+1) + " doesnt exist");
            return;
        }

        if (teamId < 0 || teamId > players.size()-1)
        {
            System.out.println("team with the id " + (teamId+1) + " doesnt exist");
            return;
        }

        if (teams.get(teamId).money < players.get(playerId).price)
        {
            System.out.println("the team cant afford to buy this player");
            return;
        }

        if (players.get(playerId).isInTeam)
        {
            System.out.println("player already has a team");
            return;
        }

        teams.get(teamId).teamPlayers.add(players.get(playerId));
        players.get(playerId).isInTeam = true;
        teams.get(teamId).money -= players.get(playerId).price;
        System.out.println("player added to the team succesfully");
    }


    private static void sellPlayer()
    {
        int playerId = Integer.parseInt(inputs[1]);
        playerId--;
        int teamId = Integer.parseInt(inputs[2]);
        teamId--;


        if (teamId < 0 || teamId > players.size()-1)
        {
            System.out.println("team doesnt exist");
            return;
        }

        boolean check = false;
        for (Player player: teams.get(teamId).teamPlayers)
            if (players.indexOf(player) == playerId)
            {
                check = true;
                break;
            }
        if (!check)
        {
            System.out.println("team doesnt have this player");
            return;
        }

        teams.get(teamId).teamPlayers.remove(players.get(playerId));
        teams.get(teamId).money += players.get(playerId).price;
        players.get(playerId).isInTeam = false;
        System.out.println("player sold succesfully");
    }


    static void match()
    {
        int team1Id = Integer.parseInt(inputs[1]);
        team1Id--;
        int team2Id = Integer.parseInt(inputs[2]);
        team2Id--;



        if (team1Id < 0 || team1Id > players.size()-1
            ||
            team2Id < 0 || team2Id > players.size()-1)
        {
            System.out.println("team doesnt exist");
            return;
        }


        if (teams.get(team1Id).teamPlayers.size() < 11
            ||
            teams.get(team2Id).teamPlayers.size() < 11)
        {
            System.out.println("the game can not be held due to loss of the players");
            return;
        }


        long team1Power = 0;
        for (int i = 0; i < 11; i++)
        {
            team1Power += teams.get(team1Id).teamPlayers.get(i).speed;
            team1Power += teams.get(team1Id).teamPlayers.get(i).finishing;
        }

        long team2Power = 0;
        for (int i = 0; i < 11; i++)
        {
            team2Power += teams.get(team2Id).teamPlayers.get(i).speed;
            team2Power += teams.get(team2Id).teamPlayers.get(i).defence;
        }


        if (team1Power > team2Power)
        {
            teams.get(team1Id).money += 1000;
            teams.get(team1Id).wins += 1;

            teams.get(team2Id).looses += 1;
        }
        else if (team1Power < team2Power)
        {
            teams.get(team2Id).money += 1000;
            teams.get(team2Id).wins += 1;

            teams.get(team1Id).looses += 1;
        }
        else 
        {
            teams.get(team1Id).draws += 1;
            teams.get(team2Id).draws += 1;
        }
    }


    private static void rank()
    {
        Team[] leaderborads = teams.toArray(new Team[0]);
        Team holdToSwap;

        for (int i = 0; i < leaderborads.length; i++)
            for (int j = i+1; j < leaderborads.length; j++)
            {
                if (leaderborads[j].wins > leaderborads[i].wins)
                {
                    holdToSwap = leaderborads[i];
                    leaderborads[i] = leaderborads[j];
                    leaderborads[j] = holdToSwap;
                }
                else if (leaderborads[j].looses < leaderborads[i].looses)
                {
                    holdToSwap = leaderborads[j];
                    leaderborads[j] = leaderborads[i];
                    leaderborads[i] = holdToSwap;
                }
                else if (teams.indexOf(leaderborads[j]) < teams.indexOf(leaderborads[i]))
                {
                    holdToSwap = leaderborads[i];
                    leaderborads[i] = leaderborads[j];
                    leaderborads[j] = holdToSwap;
                }
            }

        
        for (int i = 0; i < leaderborads.length; i++)
            System.out.println((i+1) + ". " + leaderborads[i].name);
    }
}