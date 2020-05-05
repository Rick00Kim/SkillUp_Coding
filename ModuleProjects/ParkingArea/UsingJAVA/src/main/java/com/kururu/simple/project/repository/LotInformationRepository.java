package com.kururu.simple.project.repository;

import com.kururu.simple.project.entity.LotInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h2>Parking Area [JPA Repository of LOT_INFORMATION]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public interface LotInformationRepository extends JpaRepository<LotInformationEntity, Long> {
}
