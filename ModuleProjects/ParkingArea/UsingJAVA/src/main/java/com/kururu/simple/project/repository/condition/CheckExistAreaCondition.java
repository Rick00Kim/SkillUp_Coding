package com.kururu.simple.project.repository.condition;

import static com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckExistAreaCondition implements Serializable {

    private Long lotNumber;

    private CAR_SIZE carSize;

    private Timestamp before;

    private Timestamp after;

}
