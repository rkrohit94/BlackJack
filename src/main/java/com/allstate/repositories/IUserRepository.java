package com.allstate.repositories;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;

import javax.jws.soap.SOAPBinding;
import com.allstate.Entities.User;
/**
 * Created by localadmin on 23/01/17.
 */
public interface IUserRepository extends CrudRepository<User,Integer>{
}
