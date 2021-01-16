package com.example.football.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTeam {
    @SerializedName("teams")
    private List<com.ronald.football_app.data.Team> teams;

    public List<com.ronald.football_app.data.Team> getTeams() {
        return teams;
    }

    public void setTeams(List<com.ronald.football_app.data.Team> teams) {
        this.teams = teams;
    }
}
