package application.controllers;

import application.services.IStageQualificationService;
import db.models.StageQualification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qualification")
public class StageQualificationController {
    private final IStageQualificationService stageQualificationService;
    public StageQualificationController(IStageQualificationService stageQualificationService){
        this.stageQualificationService = stageQualificationService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StageQualification> getAll() {
        return stageQualificationService.getAll();
    }
    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageQualification getStageQualification(@RequestParam(name = "id") Integer id){
        return stageQualificationService.getStageQualification(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageQualification addStageQualification(@RequestBody StageQualification stageQualification){
        return stageQualificationService.addStageQualification(stageQualification);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageQualification updateStageQualification(@RequestBody StageQualification stageQualification){
        return stageQualificationService.updateStageQualification(stageQualification);
    }
    @DeleteMapping()
    public void deleteStageQualification(@RequestParam(name = "id") Integer id){
        stageQualificationService.deleteStageQualification(id);
    }
    //endregion
}
