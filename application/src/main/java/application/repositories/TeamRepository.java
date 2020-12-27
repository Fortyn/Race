package application.repositories;

import application.projections.TeamResultProjection;
import db.models.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query(nativeQuery = true, value = "SELECT team.id as id," +
            " team.name as name," +
            " CAST(sum(sr.sum) AS INTEGER) as score," +
            " CONCAT(" +
            "   '[', " +
            "   array_to_string(array_agg(CONCAT(" +
            "   '{ " +
            "       \"name\":\"',sq.stage_number,'\", " +
            "       \"score\":',sr.sum," +
            "   '}'" +
            ")), ',')," +
            "   ']'" +
            " ) as \"stageScores\" " +
            "FROM public.team team\n" +
            "JOIN public.driver driver ON team.id = driver.team_id\n" +
            "JOIN public.stage_qualification sq ON sq.user_id = driver.id\n" +
            "JOIN (\n" +
            "\tSELECT sr.qual_id, sum(sr.tanso+sr.cuiso) \n" +
            "\tFROM public.stage_result sr\n" +
            "\tGROUP BY sr.qual_id\n" +
            "\tORDER BY sr.qual_id\n" +
            ") sr ON sq.id = sr.qual_id\n" +
            "GROUP BY team.id")
    List<TeamResultProjection> getTeamResults();
}
