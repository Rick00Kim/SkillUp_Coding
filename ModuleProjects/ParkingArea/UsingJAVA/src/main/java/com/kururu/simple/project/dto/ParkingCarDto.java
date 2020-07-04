package com.kururu.simple.project.dto;

import com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;
import lombok.*;

/**
 * <h2>Parking Area [DTO for Parking car function]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingCarDto {

    /* Vehicle Number */
    private String vehicleNumber;

    /* Car Size from Input */
    private CAR_SIZE inputCarSize;
}
