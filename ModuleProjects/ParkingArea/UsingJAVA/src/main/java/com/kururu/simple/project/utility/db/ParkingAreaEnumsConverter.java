package com.kururu.simple.project.utility.db;

import com.kururu.simple.project.constant.ParkingAreaEnumInterface;
import lombok.AllArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.Arrays;

/**
 * <h2>Parking Area [Enums Converter for Table column]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Convert
@AllArgsConstructor
public abstract class ParkingAreaEnumsConverter<T extends Enum<T> & ParkingAreaEnumInterface<E>, E> implements AttributeConverter<T, E> {

    private final Class<T> enumClass;

    @Override
    public E convertToDatabaseColumn(T value) {
        return value.getCode();
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> e.getCode() == dbData)
                .findFirst()
                .orElse(null);
    }
}
