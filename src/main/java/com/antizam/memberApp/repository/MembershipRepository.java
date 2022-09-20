package com.antizam.memberApp.repository;

import com.antizam.memberApp.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update membership set amount=:amount, description=:description, " +
            "date_paid=:datePaid, is_paid=:isPaid where id=:id", nativeQuery = true)
    void membershipUpdate(@Param("id") int id,
                          @Param("amount") BigDecimal amount,
                          @Param("description") String description,
                          @Param("datePaid") LocalDate datePaid,
                          @Param("isPaid") boolean isPaid);
}

