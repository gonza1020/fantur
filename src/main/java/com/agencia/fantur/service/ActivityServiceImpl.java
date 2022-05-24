package com.agencia.fantur.service;

import com.agencia.fantur.model.Activity;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity,Long>{
    boolean checkActivity(Long id){
        Activity a = repository.findById(id).orElse(null);
        if(a != null){
            return true;
        }
        return false;
    }
}
