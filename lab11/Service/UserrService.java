package com.example.lab11.Service;

import com.example.lab11.Model.Userr;
import com.example.lab11.Repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserrService {

    private final UserRepository userRepository;

    public List<Userr> getUser(){
        return userRepository.findAll();
    }

    public void addUser(Userr user){
        userRepository.save(user);
    }
    public Boolean updateUser(Integer id,Userr userr) {
        Userr u = userRepository.getById(id);
        if (u == null) {
            return false;
        }

        u.setName(userr.getName());
        u.setEmail(userr.getEmail());
        u.setPassword(userr.getPassword());
        u.setAge(userr.getAge());
        u.setRole(userr.getRole());

        userRepository.save(u);

        return true;
    }

    public Boolean deleteUser(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else
            return false;

    }


}
