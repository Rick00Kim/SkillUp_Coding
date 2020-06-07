package com.kururu.simple.project.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class KururuFileProperties {

    @Value("${kururu.file.base-dir}")
    private String baseDir;

    @Value("${kururu.file.daily-dir}")
    private String dailyDir;

    @Value("${kururu.file.custom-dir}")
    private String customDir;

}
