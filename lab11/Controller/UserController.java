package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.Userr;
import com.example.lab11.Service.UserrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserrService userrService;

    @GetMapping("/get")
    public ResponseEntity getUser(){

        return ResponseEntity.status(200).body(userrService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid Userr userr, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userrService.addUser(userr);
        return ResponseEntity.status(200).body(new ApiResponce("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid Userr userr,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Boolean isupdated=userrService.updateUser(id,userr);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        Boolean isdeleted=userrService.deleteUser(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }


}
