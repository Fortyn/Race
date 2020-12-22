package application.services;

import db.models.StageQualification;

public interface IStageQualificationService {
    //region CRUD
    StageQualification getStageQualification(Integer id);
    StageQualification addStageQualification(StageQualification stageQualification);
    StageQualification updateStageQualification(StageQualification stageQualification);
    void deleteStageQualification(Integer id);
    //endregion
}
