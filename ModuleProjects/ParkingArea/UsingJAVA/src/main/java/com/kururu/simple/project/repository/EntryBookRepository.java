package com.kururu.simple.project.repository;

import com.kururu.simple.project.entity.EntryBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h2>Parking Area [JPA Repository of ENTRY_BOOK]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public interface EntryBookRepository extends JpaRepository<EntryBookEntity, String> {
}
