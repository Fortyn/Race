package application.services.implementation;

import application.repositories.TeamRepository;
import application.services.ITeamService;
import db.models.Team;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TeamService implements ITeamService {
    private final TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    @Override
    public Team getTeam(Integer id) {
        return teamRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Team addTeam(Team team) {
        if(team.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        if(!teamRepository.existsById(team.getId())) throw new NoSuchElementException("No value present");
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
