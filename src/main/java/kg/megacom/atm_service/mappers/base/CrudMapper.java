package kg.megacom.atm_service.mappers.base;

import java.util.List;

public interface CrudMapper  <E,D>{
    E toEntity (D d);
    D toDto(E e);
    List<E> toEntities(List<D> d);
    List<D>toDtos(List<E> e);
}
