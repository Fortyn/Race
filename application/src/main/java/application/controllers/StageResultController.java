package application.controllers;

import application.services.IStageResultService;
import db.models.StageResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result")
public class StageResultController {
    private final IStageResultService stageResultService;
    public StageResultController(IStageResultService stageResultService){
        this.stageResultService = stageResultService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StageResult> getAll() {
        return stageResultService.getAll();
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageResult getStageResult(@RequestParam(name = "id") Integer id){
        return stageResultService.getStageResult(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageResult addStageResult(@RequestBody StageResult stageResult){
        return stageResultService.addStageResult(stageResult);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StageResult updateStageResult(@RequestBody StageResult stageResult){
        return stageResultService.updateStageResult(stageResult);
    }

    @DeleteMapping()
    public void deleteDriver(@RequestParam(name = "id") Integer id){
        stageResultService.deleteStageResult(id);
    }
    //endregion
}
