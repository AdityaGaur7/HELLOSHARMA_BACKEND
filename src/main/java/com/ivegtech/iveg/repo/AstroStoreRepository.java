package com.ivegtech.iveg.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivegtech.iveg.entity.AstroStore;

@Repository
public interface AstroStoreRepository extends JpaRepository<AstroStore, Long> {
}
