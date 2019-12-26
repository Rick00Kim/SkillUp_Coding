package com.kururu.skillup.module.repository;

import com.kururu.skillup.module.model.SkillUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillUpRepositoryIF extends JpaRepository<SkillUpEntity, Long> {
}
