package application.services;

import db.models.Team;

public interface ITeamService {
    //region CRUD
    Team getTeam(Integer id);
    Team addTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeam(Integer id);
    //endregion
}
