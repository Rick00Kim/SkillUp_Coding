package com.kururu.simple.project.utility.common;

/**
 * <h2>Parking Area [Enum Interface]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public interface ParkingAreaEnumInterface<T> {

    /**
     * Get Code of Enum
     *
     * @return T
     */
    T getCode();

    /**
     * Get Description of Enum
     *
     * @return String
     */
    String getDescription();
}
