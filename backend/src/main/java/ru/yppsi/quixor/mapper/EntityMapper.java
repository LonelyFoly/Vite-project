package ru.yppsi.quixor.mapper;

import javax.persistence.Entity;
import java.util.List;

/**
 * Interface for all {@link Entity} mappers.

 * @param <D> Dto
 * @param <E> Entity
 */
public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntities(List<D> dtoList);

    List<D> toDtos(List<E> entityList);
}
