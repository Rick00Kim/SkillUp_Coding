package com.kururu.simple.project.entity;

import lombok.*;

import javax.persistence.Column;
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

    private static final long serialVersionUID = 1L;

    /* Vehicle number */
    @NotNull
    @Max(20)
    @Column(name = "VEHICLE_NUMBER")
    private String vehicleNumber;

    /* Client number */
    @NotNull
    @Max(20)
    @Column(name = "CLIENT_NUMBER")
    private String clientNumber;

    /* Lot Number */
    @NotNull
    @Column(name = "LOT_NUMBER")
    private Long lotNumber;

    @Override
    public int hashCode() {

        int result = vehicleNumber.hashCode();
        result = 31 * result + clientNumber.hashCode();
        result = 31 * result + lotNumber.hashCode();
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
        if (!clientNumber.equals(that.clientNumber))
            return false;
        return lotNumber.equals(that.lotNumber);
    }
}
