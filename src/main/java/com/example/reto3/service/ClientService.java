package com.example.reto3.service;

import com.example.reto3.entities.Client;
import com.example.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){return clientRepository.getAll();}
    public Optional<Client> getClient(int id){return clientRepository.getClient(id);}
    public Client save(Client a){
        if(a.getIdClient()==null){
            return clientRepository.save(a);
        } else{
            Optional<Client> e = clientRepository.getClient(a.getIdClient());
            if (e.isPresent()){
                return a;
            } else {
                return clientRepository.save(a);
            }
        }
    }

    public Client update(Client a){
        if(a.getIdClient()!= null){
            Optional<Client> q = clientRepository.getClient(a.getIdClient());
            if (q.isPresent()){
                if (a.getEmail() != null){
                    q.get().setEmail(a.getEmail());
                }
                if (a.getName() != null){
                    q.get().setName(a.getName());
                }
                if (a.getPassword() != null){
                    q.get().setPassword(a.getPassword());
                }
                if (a.getAge() != null){
                    q.get().setAge(a.getAge());
                }
                clientRepository.save(q.get());
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
        Optional<Client> a = clientRepository.getClient(id);
        if (a.isPresent()){
            clientRepository.delete(a.get());
            flag =true;
        }
        return flag;
    }
}


