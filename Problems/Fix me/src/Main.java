import java.util.*;


/** Observable */
interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

/** Concrete Observable */
class RockstarGames implements Observable {

    public String releaseGame;
    private List<Observer> observers = new ArrayList<>();

    public void release(String releaseGame) {
        this.releaseGame = releaseGame;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Inform message to : " + observer);
            observer.update(releaseGame);
        }
    }
}


/** Observer */
interface Observer {

    public void update(String domain);
}
/** Concrete Observer */
class Gamer implements Observer{

    private String name;
    private String reaction;
    private RockstarGames rockstarGames;

    private Set<String> games = new HashSet<>();

    public Gamer(String name,String reaction, Set<String> games, RockstarGames rockstarGames) {
        this.reaction = reaction;
        this.games = games;
        this.name = name;
        this.rockstarGames = rockstarGames;
    }

    /** write your code here ... */

    public void buyGame(String game) {
        games.add(game);
        System.out.println(name + " says: " + reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(String domain) {
        buyGame(domain);
    }
}

/** Main Class */

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();
        Set<String> games = new HashSet<>();

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order", games, rockstarGames);
        Gamer peter = new Gamer("Peter Johnston", "Pinch me...", games, rockstarGames);
        Gamer helen = new Gamer("Helen Jack", "Jesus, it's new game from Rockstar!", games, rockstarGames);
        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        rockstarGames.release(game);

        scanner.close();
    }
}