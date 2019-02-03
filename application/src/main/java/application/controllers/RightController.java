package application.controllers;

import application.services.IRightService;
import db.models.Right;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/right")
public class RightController {
    private final IRightService rightService;
    public RightController(IRightService rightService){
        this.rightService = rightService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Right getRight(@RequestParam(name = "id") Long id){
        return rightService.getRight(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Right addRight(@RequestBody Right right){
        return rightService.addRight(right);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Right updateRight(@RequestBody Right right){
        return rightService.updateRight(right);
    }
    @DeleteMapping()
    public void deleteRight(@RequestParam(name = "id") Long id){
        rightService.deleteRight(id);
    }
    //endregion
}
