package com.example.Card.repository;

import com.example.Card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
    Optional<Card> findByMobileNo(String mobileNo);
}
