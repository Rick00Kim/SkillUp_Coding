package com.kururu.simple.project.repository;

import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>Parking Area [JPA Repository of ENTRY_BOOK]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Repository
public interface EntryBookRepository extends JpaRepository<EntryBook, EntryBookIdentity> {
}
