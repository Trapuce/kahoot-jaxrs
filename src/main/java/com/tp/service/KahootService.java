package com.tp.service;


import com.tp.dto.KahootDTO;
import com.tp.mappers.KahootMapper;
import com.tp.model.Kahoot;
import com.tp.model.User;
import com.tp.repository.impl.JpaKahootRepository;
import com.tp.repository.impl.JpaUserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KahootService {

    private final JpaKahootRepository jpaKahootRepository;
    private final JpaUserRepository jpaUserRepository;
    private final KahootMapper kahootMapper;
    public KahootService() {
         this.jpaKahootRepository =new JpaKahootRepository();
         this.jpaUserRepository =new JpaUserRepository();
         this.kahootMapper = KahootMapper.INSTANCE ;
    }

    public KahootDTO createKahoot(KahootDTO kahootDTO , Long userId) {

        User user = this.jpaUserRepository.findOne(userId);
        if (user == null) {
            throw new IllegalArgumentException("user not found");
        }
        Kahoot kahoot = this.kahootMapper.kahootDTOToKahoot(kahootDTO);
        kahoot.setCreatedAt(new Date());
        user.addKahoot(kahoot);
        this.jpaKahootRepository.save(kahoot);
        return this.kahootMapper.kahootToKahootDTO(kahoot);
    }


    public List<KahootDTO> getAllKahoots(){
       List<KahootDTO> kahootsDTO = new ArrayList<>();
        for (Kahoot kahoot : this.jpaKahootRepository.findAll()) {
            kahootsDTO.add(this.kahootMapper.kahootToKahootDTO(kahoot));
        }

        return kahootsDTO;
    }



    public KahootDTO getKahoot(Long kahootId) {

        Kahoot kahoot = this.jpaKahootRepository.findOne(kahootId);
        return this.kahootMapper.kahootToKahootDTO(kahoot);
    }


 }