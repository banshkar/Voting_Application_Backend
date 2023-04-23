package com.bridgelabz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.Vote;

public interface VoteRepo extends JpaRepository<Vote, Integer>{

}
