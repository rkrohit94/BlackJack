package com.allstate.repositories;

import com.allstate.Entities.Game;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 23/01/17.
 */
public interface IGameRepository extends CrudRepository<Game,Integer> {
}
