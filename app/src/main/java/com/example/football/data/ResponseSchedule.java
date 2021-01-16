package com.example.football.data;

import java.util.List;

public class ResponseSchedule {
    @SerializedName("events")
    private List<com.football.data.Schedule> schedules;

    public List<com.football.data.Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<com.football.data.Schedule> schedules) {
        this.schedules = schedules;
    }
}
