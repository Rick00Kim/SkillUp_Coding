package com.kururu.simple.project.repository;

import com.kururu.simple.project.entity.LotInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * <h2>Parking Area [JPA Repository of LOT_INFORMATION]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public interface LotInformationRepository extends JpaRepository<LotInformation, Long> {

    /* Select by Lot name */
    LotInformation findByLotName(@Param("LOT_NAME") final String lotName);

}
