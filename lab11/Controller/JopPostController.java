package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.JopPost;
import com.example.lab11.Model.Userr;
import com.example.lab11.Service.JopPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/joppost")
@RequiredArgsConstructor
public class JopPostController{

    private final JopPostService jopPostService;


    @GetMapping("/get")
    public ResponseEntity getJoppost(){
        return ResponseEntity.status(200).body(jopPostService.getJopPost());
    }


    @PostMapping("/add")
    public ResponseEntity addJoppost(@RequestBody  @Valid JopPost jopPost, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jopPostService.addJopPost(jopPost);
        return ResponseEntity.status(200).body(new ApiResponce("jop post added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJoppost(@PathVariable Integer id, @RequestBody @Valid JopPost jopPost, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Boolean isupdated=jopPostService.updateJopPost(id,jopPost);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("jop post updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
}


     @DeleteMapping("/delete/{id}")
     public ResponseEntity deleteJoppost(@PathVariable Integer id){
        Boolean isdeleted=jopPostService.deleteJopPost(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("jop post deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
     }


}
