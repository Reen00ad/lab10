package com.example.lab11.Service;

import com.example.lab11.Model.JopPost;
import com.example.lab11.Model.Userr;
import com.example.lab11.Repositry.JopPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JopPostService {

    private final JopPostRepository jopPostRepository;

    public List<JopPost> getJopPost(){
        return jopPostRepository.findAll();
    }

    public void addJopPost(JopPost jopPost){
        jopPostRepository.save(jopPost);
    }

    public Boolean updateJopPost(Integer id, JopPost jopPost) {
        JopPost j = jopPostRepository.getById(id);
        if (j == null) {
            return false;
        }

        j.setTitle(jopPost.getTitle());
        j.setDescription(jopPost.getDescription());
        j.setLocation(jopPost.getLocation());
        j.setSalary(jopPost.getSalary());
        j.setPostingdate(jopPost.getPostingdate());

        jopPostRepository.save(j);

        return true;
    }

    public Boolean deleteJopPost(Integer id){
        if(jopPostRepository.existsById(id)){
            jopPostRepository.deleteById(id);
            return true;
        }else
            return false;
    }


}
