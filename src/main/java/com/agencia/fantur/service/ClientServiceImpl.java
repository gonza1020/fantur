package com.agencia.fantur.service;

import com.agencia.fantur.exception.ResourceNotFoundException;
import com.agencia.fantur.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<User, Long>{
    public User findById(Long id) {
        return  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Long",id));
    }
    public User update(User entity, Long id) {

        User existingUser = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));

        existingUser.setCuit(entity.getCuit());
        existingUser.setEmail(entity.getEmail());
        existingUser.setFirstName(entity.getFirstName());
        existingUser.setLastName(entity.getLastName());
        existingUser.setUserName(entity.getUserName());
        existingUser.setPassword(entity.getPassword());
        existingUser.setPhone(entity.getPhone());
        existingUser.setRolId(entity.getRolId());

        return repository.save(existingUser);
    }
}
