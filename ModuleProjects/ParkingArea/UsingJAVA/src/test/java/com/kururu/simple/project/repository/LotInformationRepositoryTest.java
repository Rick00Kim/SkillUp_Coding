package com.kururu.simple.project.repository;

import static com.kururu.simple.project.constant.ParkingAreaEnums.DEL_FLG;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.kururu.simple.project.entity.LotInformation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder
public class LotInformationRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private LotInformationRepository repository;

    @Test
    public void test_save() {
        final LotInformation testEntity = createDefaultEntity();
        repository.save(testEntity);
        assertThat(repository.existsById(testEntity.getLotNumber()), is(true));
    }

    @Test
    public void test_findByLotName() {
        final LotInformation target = insertDefaultEntity();
        assertThat(repository.findByLotName(target.getLotName()), notNullValue());
    }

    private LotInformation insertDefaultEntity() {
        return repository.save(createDefaultEntity());
    }

    private LotInformation createDefaultEntity() {
        return LotInformation.builder()
                .lotName(RandomStringUtils.randomAlphanumeric(100))
                .acceptableSmall(10)
                .acceptableMedium(10)
                .acceptableHeavy(10)
                .delFlg(DEL_FLG.NOT_DELETED)
                .build();
    }

}
