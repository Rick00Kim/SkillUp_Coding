package com.kururu.simple.project.repository;

import static com.kururu.simple.project.constant.ParkingAreaEnums.DEL_FLG;

import com.kururu.simple.project.entity.LotInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LotInformationRepositoryTest {

    @Autowired
    private LotInformationRepository lotInformationRepository;

    @Test
    public void test_insert() {
        final LotInformation tetEntity = LotInformation.builder()
                .lotName("TEST_LOT_NAME")
                .acceptableSmall(10)
                .acceptableMedium(10)
                .acceptableHeavy(10)
                .delFlg(DEL_FLG.NOT_DELETED)
                .build();
        lotInformationRepository.save(tetEntity);

        final LotInformation inserted = lotInformationRepository.findByLotName(tetEntity.getLotName()).get(0);


    }

}
