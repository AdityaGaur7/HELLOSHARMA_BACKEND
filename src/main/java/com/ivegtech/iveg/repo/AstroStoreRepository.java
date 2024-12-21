package com.ivegtech.iveg.repo;

import com.ivegtech.iveg.entity.AstroStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface AstroStoreRepository extends JpaRepository<AstroStore, Long> {

}
