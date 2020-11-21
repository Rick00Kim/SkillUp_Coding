package com.kururu.simple.project.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <h2>Parking Area [Properties about file]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class KururuFileProperties {

    /* Base Directory */
    @Value("${kururu.file.base-dir}")
    private String baseDir;

    /* Daily Directory */
    @Value("${kururu.file.daily-dir}")
    private String dailyDir;

    /* Custom Directory */
    @Value("${kururu.file.custom-dir}")
    private String customDir;

}
