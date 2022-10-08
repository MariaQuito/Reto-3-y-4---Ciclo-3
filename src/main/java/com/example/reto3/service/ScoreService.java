package com.example.reto3.service;

import com.example.reto3.entities.Score;
import com.example.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){return scoreRepository.getAll();}
    public Optional<Score> getScore(int id){return scoreRepository.getScore(id);}
    public Score save(Score a){
        if(a.getId()==null){
            return scoreRepository.save(a);
        } else{
            Optional<Score> e = scoreRepository.getScore(a.getId());
            if (e.isPresent()){
                return a;
            } else {
                return scoreRepository.save(a);
            }
        }
    }

    public Score update(Score a){
        if(a.getId()!= null){
            Optional<Score> q = scoreRepository.getScore(a.getId());
            if (q.isPresent()){
                if (a.getStars() != null){
                    q.get().setStars(a.getStars());
                }
                scoreRepository.save(q.get());
                return q.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Score> a = scoreRepository.getScore(id);
        if (a.isPresent()){
            scoreRepository.delete(a.get());
            flag =true;
        }
        return flag;
    }
}


