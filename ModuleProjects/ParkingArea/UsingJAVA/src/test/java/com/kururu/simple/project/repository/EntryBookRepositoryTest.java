package com.kururu.simple.project.repository;

import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;

import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import com.kururu.simple.project.utility.common.DateComponent;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder
public class EntryBookRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private EntryBookRepository repository;

    @Autowired
    private DateComponent dateComponent;

    @Test
    public void test_save() {
        final EntryBook testEntity = createDefaultEntity();
        repository.save(testEntity);
        assertThat(repository.existsById(testEntity.getKey()), is(true));
    }

    private EntryBook createDefaultEntity() {
        return EntryBook.builder()
                .key(EntryBookIdentity.builder()
                        .clientNumber(RandomStringUtils.randomAlphanumeric(20))
                        .vehicleNumber(RandomStringUtils.randomAlphanumeric(20))
                        .build())
                .arrivalTime(dateComponent.getCurrentTimestamp())
                .departureTime(dateComponent.getCurrentTimestamp())
                .hoursOfUse(RandomUtils.nextInt(0, 99))
                .costOfUse(RandomUtils.nextInt(0, 999999999))
                .endBusinessFlg(END_BUSINESS_FLG.BUSINESS_NOT_ENDED)
                .build();
    }

}
