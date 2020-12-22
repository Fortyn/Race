package application.services;

import application.models.TeamResult;
import db.models.Team;

import java.util.List;

public interface ITeamService {
    //region CRUD
    Team getTeam(Integer id);
    Team addTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeam(Integer id);
    //endregion

    List<TeamResult> getTeamResults();
}
