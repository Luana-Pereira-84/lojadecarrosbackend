package br.edu.usj.ads.lojadecarros;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{
    List<veiculo> findAll();

    List<veiculo> findByNome(String placa);

    List<veiculo> findByNomeContainingIgnoreCase(String placa);
}
 