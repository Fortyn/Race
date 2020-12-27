package application.services;

import db.models.StageQualification;

import java.util.List;

public interface IStageQualificationService {

    List<StageQualification> getAll();
    //region CRUD
    StageQualification getStageQualification(Integer id);
    StageQualification addStageQualification(StageQualification stageQualification);
    StageQualification updateStageQualification(StageQualification stageQualification);
    void deleteStageQualification(Integer id);
    //endregion
}
