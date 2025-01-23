package org.jsp.libraryManagement.Repository;

import org.jsp.libraryManagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
