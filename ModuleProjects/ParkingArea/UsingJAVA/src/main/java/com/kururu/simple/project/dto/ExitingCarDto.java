package com.kururu.simple.project.dto;

import lombok.*;

/**
 * <h2>Parking Area [DTO for Exiting car function]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExitingCarDto {

    /* Vehicle Number */
    private String vehicleNumber;

    /* Client Number */
    private String clientNumber;

    @Deprecated
    public void setClientNumber(String clientNumber) {
        this.clientNumber = "Non-Member";
    }
}
