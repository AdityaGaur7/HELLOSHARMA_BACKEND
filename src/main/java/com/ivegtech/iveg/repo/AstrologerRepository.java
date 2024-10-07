package com.ivegtech.iveg.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivegtech.iveg.entity.Astrologer;

@Repository
public interface AstrologerRepository extends JpaRepository<Astrologer, Long> {

	List<Astrologer> findAll();

	
}