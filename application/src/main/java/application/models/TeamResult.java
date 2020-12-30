package application.models;

import application.projections.TeamResultProjection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TeamResult {

    private List<StageScore> parse(String stageScores) {
        try {
            final var mapper = new ObjectMapper();
            return mapper.readValue(stageScores, new TypeReference<>() {
            });
        } catch (Exception ignore) {
            ignore.printStackTrace();
            return List.of();
        }

    }

    public static class StageScore {
        private String name;
        private Integer score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    private final Integer id;
    private final String name;
    private final Integer totalScore;
    private final List<StageScore> stages;

    private TeamResult(Integer id, String name, Integer totalScore, String stageScores) {
        this.id = id;
        this.name = name;
        this.totalScore = totalScore;
        this.stages = parse(stageScores);
    }

    public TeamResult(TeamResultProjection projection) {
        this(projection.getId(), projection.getName(), projection.getScore(), projection.getStageScores());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public List<StageScore> getStages() {
        return stages;
    }
}
