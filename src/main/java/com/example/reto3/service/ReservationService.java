package com.example.reto3.service;

import com.example.reto3.entities.Reservation;
import com.example.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){return reservationRepository.getAll();}
    public Optional<Reservation> getReservation(int id){return reservationRepository.getReservation(id);}
    public Reservation save(Reservation a){
        if(a.getIdReservation()==null){
            return reservationRepository.save(a);
        } else{
            Optional<Reservation> e = reservationRepository.getReservation(a.getIdReservation());
            if (e.isPresent()){
                return a;
            } else {
                return reservationRepository.save(a);
            }
        }
    }

    public Reservation update(Reservation a){
        if(a.getIdReservation()!= null){
            Optional<Reservation> q = reservationRepository.getReservation(a.getIdReservation());
            if (q.isPresent()){
                if (a.getDevolutionDate() != null){
                    q.get().setDevolutionDate(a.getDevolutionDate());
                }
                if (a.getStatus() != null){
                    q.get().setStatus(a.getStatus());
                }
                if (a.getStartDate() != null){
                    q.get().setStartDate(a.getStartDate());
                }
                reservationRepository.save(q.get());
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
        Optional<Reservation> a = reservationRepository.getReservation(id);
        if (a.isPresent()){
            reservationRepository.delete(a.get());
            flag =true;
        }
        return flag;
    }
}


