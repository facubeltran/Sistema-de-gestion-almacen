package ar.org.centro8.curso.java.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;

@Repository
public interface ArticuloRepository  extends CrudRepository<Articulo,Integer>{
    public abstract List<Articulo>findByDescripcionContaining(String descripcion);
    public abstract List<Articulo> findByRubro(Rubro rubro);
    public abstract List<Articulo> findByStock(Integer stock);
    
}
