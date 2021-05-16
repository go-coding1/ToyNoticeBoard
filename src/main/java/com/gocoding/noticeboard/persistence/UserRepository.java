package com.gocoding.noticeboard.persistence;

import com.gocoding.noticeboard.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
