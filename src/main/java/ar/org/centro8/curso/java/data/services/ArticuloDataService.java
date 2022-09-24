package ar.org.centro8.curso.java.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.ArticuloRepository;

@Service
public class ArticuloDataService {
    @Autowired
    private ArticuloRepository articuloRepository;

    public void save(Articulo articulo){
        articuloRepository.save(articulo);
    }

    public void remove(Integer id){
        articuloRepository.delete(articuloRepository.findById(id).get());
    }

    public void update (Articulo articulo){
        articuloRepository.save(articulo);
    }

    public Articulo getById(Integer id){
        return articuloRepository.findById(id).orElse(new Articulo());
    }

    public List<Articulo> getAll(){
        return (List<Articulo>)articuloRepository.findAll();
    }

    public List<Articulo> getByRubro(String rubro){
        return (List<Articulo>)articuloRepository.findByRubro(Rubro.valueOf(rubro));
    }

    public List<Articulo> getLikeDescripcion(String descripcion){
        return articuloRepository.findByDescripcionContaining(descripcion);
    }




}
