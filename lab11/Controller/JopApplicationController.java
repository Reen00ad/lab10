package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.JopApplication;
import com.example.lab11.Model.JopPost;
import com.example.lab11.Service.JopApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jopapplication")
@RequiredArgsConstructor
public class JopApplicationController {

    private final JopApplicationService jopApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJopapplication(){
        return ResponseEntity.status(200).body(jopApplicationService.getJopApplication());
    }


    @PostMapping("/add")
    public ResponseEntity addJopapplication(@RequestBody @Valid JopApplication jopApplication, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isadded=jopApplicationService.addJopApplication(jopApplication);
        if(isadded){
        return ResponseEntity.status(200).body(new ApiResponce("jop application added"));
    }return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJopapplication(@PathVariable Integer id){
        Boolean isdeleted=jopApplicationService.deleteJopApplication(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("jop application deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    }
