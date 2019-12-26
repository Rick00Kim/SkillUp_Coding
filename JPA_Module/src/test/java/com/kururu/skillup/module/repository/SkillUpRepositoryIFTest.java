package com.kururu.skillup.module.repository;

import com.google.common.collect.Lists;
import com.kururu.skillup.module.AbstractAppTest;
import com.kururu.skillup.module.constant.SkillUpEnums;
import com.kururu.skillup.module.model.SkillUpEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SkillUpRepositoryIFTest extends AbstractAppTest {

    private static final String OPERATOR_NAME = "JUNIT_SKILLUP_REPOSITORY";

    private List<SkillUpEntity> testInitialData = Lists.newArrayList();

    @Autowired
    private SkillUpRepositoryIF repository;

    @Before
    public void before() {
        IntStream.range(0, 3).forEach(i -> repository.save(createSkillUpEntity(i)));
        testInitialData = repository.findAll().stream().sorted(Comparator.comparingLong(SkillUpEntity::getId)).collect(Collectors.toList());
    }

    @Test
    public void test_update() {
        SkillUpEntity targetEntity = testInitialData.stream().findAny().get();
        Timestamp updateTimestamp = new Timestamp(new Date().getTime());
        String updateName = "UPDATE_USER";
        targetEntity.setQuantity(1500);
        targetEntity.setDelFlg(SkillUpEnums.DEL_FLG.DELETED);
        targetEntity.setKinds(SkillUpEnums.KINDS.UPDATE);
        targetEntity.setUpdTs(updateTimestamp);
        targetEntity.setUpdName(updateName);

        repository.save(targetEntity);
        SkillUpEntity actualEntity = repository.findById(targetEntity.getId()).get();
        assertThat(actualEntity.getQuantity(), is(1500));
        assertThat(actualEntity.getDelFlg(), is(SkillUpEnums.DEL_FLG.DELETED));
        assertThat(actualEntity.getKinds(), is(SkillUpEnums.KINDS.UPDATE));
        assertThat(actualEntity.getUpdTs(), is(updateTimestamp));
        assertThat(actualEntity.getUpdName(), is(updateName));
    }

    @Test
    public void test_delete() {
        repository.deleteAll();
        List<SkillUpEntity> result = repository.findAll();
        assertThat(result.size(), is(0));
    }

    private SkillUpEntity createSkillUpEntity(int id) {
        Date date = new Date();
        return SkillUpEntity.builder()
                .kinds(SkillUpEnums.KINDS.ADD)
                .contents("Test Contents")
                .quantity(id * 200)
                .delFlg(SkillUpEnums.DEL_FLG.NOT_DELETED)
                .insTs(new Timestamp(date.getTime()))
                .insName(OPERATOR_NAME)
                .updTs(new Timestamp(date.getTime()))
                .updName(OPERATOR_NAME)
                .version(1L)
                .build();
    }
}
