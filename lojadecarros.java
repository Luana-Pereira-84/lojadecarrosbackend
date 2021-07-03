package br.edu.usj.ads.lojadecarros;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String carro;    
    String ano;    
    String placa;
    
}
