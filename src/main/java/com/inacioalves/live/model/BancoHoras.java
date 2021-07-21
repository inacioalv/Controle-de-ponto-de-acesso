package com.inacioalves.live.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class BancoHoras {
	
	
	@Embeddable
	@Getter
	@Setter
	@EqualsAndHashCode
	@NoArgsConstructor
	@AllArgsConstructor
	public class bancoHorasId implements  Serializable{

		private static final long serialVersionUID = 1L;
		
		private Long idBandoHoras;
		private Long idMovimentacao;
		private Long idUsuario;
	
	}
	
	@Id
	@EmbeddedId
	@GeneratedValue
	private bancoHorasId id;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;

}
