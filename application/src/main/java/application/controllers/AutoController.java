package application.controllers;

import application.services.IAutoService;
import db.models.Auto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auto")
public class AutoController {
    private final IAutoService autoService;
    public AutoController(IAutoService autoService){
        this.autoService = autoService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Auto getAuto(@RequestParam(name = "id") Integer id){
        return autoService.getAuto(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Auto addAuto(@RequestBody Auto auto){
        return autoService.addAuto(auto);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Auto updateAuto(@RequestBody Auto auto){
        return autoService.updateAuto(auto);
    }
    @DeleteMapping()
    public void deleteAuto(@RequestParam(name = "id") Integer id){
        autoService.deleteAuto(id);
    }
    //endregion
}
