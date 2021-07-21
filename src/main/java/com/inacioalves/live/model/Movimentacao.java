package com.inacioalves.live.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimentacao{
	

	@Embeddable
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	public class MovimentacaoId implements Serializable {
		
		private static final long serialVersionUID = 1L;

		private Long idMovimentacao;
		private Long idUsuario;
	
	}

	@Id
	@EmbeddedId
	@GeneratedValue
	private MovimentacaoId id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	
	@ManyToOne
	private Ocorrencia ocorrencia;
	@ManyToOne
	private Calendario calendario;

}
