package application.services.implementation;

import application.repositories.StageResultRepository;
import application.services.IStageResultService;
import db.models.StageResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StageResultService implements IStageResultService {
    private final StageResultRepository stageResultRepository;
    public StageResultService(StageResultRepository stageResultRepository){
        this.stageResultRepository = stageResultRepository;
    }

    @Override
    public List<StageResult> getAll() {
        return StreamSupport.stream(stageResultRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public StageResult getStageResult(Integer id) {
        return stageResultRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public StageResult addStageResult(StageResult stageResult) {
        if(stageResult.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return stageResultRepository.save(stageResult);
    }

    @Override
    public StageResult updateStageResult(StageResult stageResult) {
        if(!stageResultRepository.existsById(stageResult.getId())) throw new NoSuchElementException("No value present");
        return stageResultRepository.save(stageResult);
    }

    @Override
    public void deleteStageResult(Integer id) {
        stageResultRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
