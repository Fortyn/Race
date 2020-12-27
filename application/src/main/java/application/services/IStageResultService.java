package application.services;

import db.models.StageResult;

import java.util.List;

public interface IStageResultService {

    List<StageResult> getAll();
    //region RUD
    StageResult getStageResult(Integer id);
    StageResult addStageResult(StageResult stageResult);
    StageResult updateStageResult(StageResult stageResult);
    void deleteStageResult(Integer id);
    //endregion
}
