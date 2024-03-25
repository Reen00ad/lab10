package com.example.lab11.Service;

import com.example.lab11.Model.JopApplication;
import com.example.lab11.Model.JopPost;
import com.example.lab11.Repositry.JopApplicationRepository;
import com.example.lab11.Repositry.JopPostRepository;
import com.example.lab11.Repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JopApplicationService {

    private final JopApplicationRepository jopApplicationRepository;
    private final UserRepository userRepository;
    private final JopPostRepository jopPostRepository;

    public List<JopApplication> getJopApplication(){
        return jopApplicationRepository.findAll();
    }

    public Boolean addJopApplication(JopApplication jopApplication){
        if(userRepository.existsById(jopApplication.getUserid())&&jopPostRepository.existsById(jopApplication.getJoppostid())){
        jopApplicationRepository.save(jopApplication);
        return true;}
        else
            return false;
    }
    public Boolean deleteJopApplication(Integer id){
        if(jopApplicationRepository.existsById(id)){
            jopApplicationRepository.deleteById(id);
            return true;
        }else
            return false;
    }


}
