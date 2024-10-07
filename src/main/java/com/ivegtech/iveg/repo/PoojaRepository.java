package com.ivegtech.iveg.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivegtech.iveg.entity.Pooja;

@Repository
public interface PoojaRepository extends JpaRepository<Pooja, Long> {

	List<Pooja> findAll();
}
