package com.kururu.simple.project.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ExitingCarDto {

    /* Vehicle Number */
    private String vehicleNumber;

    /* Client Number */
    private String clientNumber;

    /**
     * (Deprecated)Not Supported Membership service yet
     * Default set = [Non-member]
     *
     * @param clientNumber UserInput
     */
    @Deprecated
    public void setClientNumber(String clientNumber) {
        log.warn(String.format("Not Supported yet. Set Default value(Non-Member), User Input is %s.", clientNumber));
        this.clientNumber = "Non-Member";
    }
}
