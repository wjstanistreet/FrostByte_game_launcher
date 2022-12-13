package com.example.frostbyte_game_launcher.models;

public class InstallGameDTO {

    private long gameId;

    public InstallGameDTO(long gameId) {
        this.gameId = gameId;
    }

    public InstallGameDTO(){

    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }
}
