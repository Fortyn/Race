package application.controllers;

import application.models.TeamResult;
import application.services.ITeamService;
import db.models.Team;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final ITeamService teamService;
    public TeamController(ITeamService teamService){
        this.teamService = teamService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Team getTeam(@RequestParam(name = "id") Integer id){
        return teamService.getTeam(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Team addTeam(@RequestBody Team team){
        return teamService.addTeam(team);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Team updateTeam(@RequestBody Team team){
        return teamService.updateTeam(team);
    }
    @DeleteMapping()
    public void deleteTeam(@RequestParam(name = "id") Integer id){
        teamService.deleteTeam(id);
    }
    //endregion

    @GetMapping("/scores")
    public List<TeamResult> getTeamResults(){
        return teamService.getTeamResults();
    }

}
