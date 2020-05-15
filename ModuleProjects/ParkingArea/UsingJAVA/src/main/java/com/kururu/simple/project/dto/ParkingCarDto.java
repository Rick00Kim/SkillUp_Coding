package com.kururu.simple.project.dto;

import com.kururu.simple.project.constant.ParkingAreaEnums;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingCarDto {

    private String inputLotName;

    private String vehicleNumber;

    private ParkingAreaEnums.CAR_SIZE inputCarSize;
}
