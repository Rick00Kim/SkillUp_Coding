package com.kururu.skillup.module.utility.convert;

import com.kururu.skillup.module.constant.EnumInterface;
import lombok.AllArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
@AllArgsConstructor
public abstract class SkillUpEnumsConverter<T extends Enum<T> & EnumInterface<E>, E> implements AttributeConverter<T, E> {

    private final Class<T> enumClass;

    @Override
    public E convertToDatabaseColumn(T value) {
        return value.getCode();
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        return Arrays.asList(enumClass.getEnumConstants())
                .stream()
                .filter(e -> e.getCode() == dbData)
                .findFirst()
                .orElse(null);
    }
}
