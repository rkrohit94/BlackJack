package com.allstate.service;

import com.allstate.Entities.User;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by localadmin on 23/01/17.
 */
@Service
public class UserService {

    private IUserRepository repository;

    @Autowired
    public void setRepository(IUserRepository repository) {
        this.repository = repository;
    }

    public User create(User user){
        return this.repository.save(user);
    }

    public Iterable<User> findUsers(){
        return this.repository.findAll();
    }

    public User findById(int id){
        return this.repository.findOne(id);
    }

}
