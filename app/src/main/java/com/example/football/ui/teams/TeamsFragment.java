package com.example.football.ui.teams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.football.R;
import com.example.football.api.APIInstance;
import com.example.football.api.APIService;
import com.example.football.data.ListTeamAdapter;
import com.example.football.data.ResponseTeam;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_teams, container, false);
        final ProgressBar teamsProgressBar = root.findViewById(R.id.teams_progress_bar);

        teamsProgressBar.setIndeterminate(true);
        teamsProgressBar.setVisibility(View.VISIBLE);

        APIService apiService = APIInstance.getRetrofitInstance().create(APIService.class);

        Call<ResponseTeam> call = apiService.getTeams();

        call.enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                teamsProgressBar.setVisibility(View.GONE);

                ListView teamListView = root.findViewById(R.id.teams_list_view);
                ListTeamAdapter listTeamAdapter = new ListTeamAdapter(getContext(), response.body().getTeams());

                teamListView.setAdapter(listTeamAdapter);
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable throwable) {
                teamsProgressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}