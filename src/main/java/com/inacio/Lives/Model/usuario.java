package com.inacio.Lives.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime finalJornada;
	
	@ManyToOne
	private CategoriaUsuario categoriaUsuario;
	@ManyToOne
	private Empresa empresa;
	@ManyToOne
	private NivelAcesso acesso;
	@ManyToOne
	private JornadaTrabalho jornadaTrabalho;

}
