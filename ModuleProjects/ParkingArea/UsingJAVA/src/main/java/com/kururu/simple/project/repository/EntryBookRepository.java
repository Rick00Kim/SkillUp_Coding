package com.kururu.simple.project.repository;

import com.kururu.simple.project.repository.condition.CountExistAreaCondition;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import com.kururu.simple.project.repository.condition.IncomeFileCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h2>Parking Area [JPA Repository of ENTRY_BOOK]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Repository
public interface EntryBookRepository extends JpaRepository<EntryBook, EntryBookIdentity> {

    @Query("SELECT COUNT(A) FROM ENTRY_BOOK A " +
            "WHERE A.key.lotNumber = :#{#condition.lotNumber} " +
            "AND A.carSize = :#{#condition.carSize} " +
            "AND A.arrivalTime BETWEEN :#{#condition.pairTermADay.left} AND :#{#condition.pairTermADay.right} " +
            "AND A.departureTime IS NULL")
    int countExistEmptyArea(@Param("condition") final CountExistAreaCondition condition);

    @Query("SELECT A FROM ENTRY_BOOK A " +
            "WHERE A.key.lotNumber = :#{#condition.lotNumber} " +
            "AND A.arrivalTime BETWEEN :#{#condition.pairTermADay.left} AND :#{#condition.pairTermADay.right} " +
            "AND A.endBusinessFlg = '0'")
    List<EntryBook> selectEntryBookForIncomeFile(@Param("condition") IncomeFileCondition condition);

}
