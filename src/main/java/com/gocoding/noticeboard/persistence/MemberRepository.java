package com.gocoding.noticeboard.persistence;

import com.gocoding.noticeboard.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
