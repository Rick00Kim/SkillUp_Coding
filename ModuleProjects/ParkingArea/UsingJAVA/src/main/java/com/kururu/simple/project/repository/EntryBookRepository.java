package com.kururu.simple.project.repository;

import com.kururu.simple.project.repository.condition.CountExistAreaCondition;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <h2>Parking Area [JPA Repository of ENTRY_BOOK]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Repository
public interface EntryBookRepository extends JpaRepository<EntryBook, EntryBookIdentity> {

    @Query("select count(a) from ENTRY_BOOK a " +
            "where a.key.lotNumber = :#{#condition.lotNumber} " +
            "and a.carSize = :#{#condition.carSize} " +
            "and a.arrivalTime between :#{#condition.pairTermADay.left} and :#{#condition.pairTermADay.right} " +
            "and a.departureTime is null")
    int countExistEmptyArea(@Param("condition") final CountExistAreaCondition condition);


}
