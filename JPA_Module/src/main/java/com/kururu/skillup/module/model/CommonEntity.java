package com.kururu.skillup.module.model;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonEntity {

    @NonNull
    private Timestamp insTs;

    @NonNull
    private String insName;

    @NonNull
    private Timestamp updTs;

    @NonNull
    private String updName;

    @NonNull
    private Long version;
}
