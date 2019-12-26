package com.kururu.skillup.module.repository;

import com.kururu.skillup.module.model.SkillUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillUpRepository extends JpaRepository<SkillUpEntity, Long> {
}
