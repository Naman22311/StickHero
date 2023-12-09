package com.ap.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




// Singleton Design pattern is used here
public class GameRegistry implements Serializable {
    private List<Game> games = new ArrayList<Game>();

    private static GameRegistry singleton = null;

    private GameRegistry()
    {
    }
    public static synchronized GameRegistry getInstance()
    {
        if (singleton == null)
            singleton = new GameRegistry();
        return singleton;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void registerGame(Game game) {
        singleton.games.add(game);
    }

}