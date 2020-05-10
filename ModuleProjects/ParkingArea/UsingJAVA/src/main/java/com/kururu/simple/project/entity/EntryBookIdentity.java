package com.kururu.simple.project.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class EntryBookIdentity implements Serializable {

    /* Vehicle number */
    @NotNull
    @Max(20)
    private String vehicleNumber;

    /* Client number */
    @NotNull
    @Max(20)
    private String clientNumber;

    @Override
    public int hashCode() {

        int result = vehicleNumber.hashCode();
        result = 31 * result + clientNumber.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        final EntryBookIdentity that = (EntryBookIdentity) obj;

        if (!vehicleNumber.equals(that.vehicleNumber))
            return false;
        return clientNumber.equals(that.clientNumber);
    }
}
