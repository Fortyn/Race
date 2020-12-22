package application.services;

import db.models.StageResult;

public interface IStageResultService {
    //region RUD
    StageResult getStageResult(Integer id);
    StageResult addStageResult(StageResult stageResult);
    StageResult updateStageResult(StageResult stageResult);
    void deleteStageResult(Integer id);
    //endregion
}
