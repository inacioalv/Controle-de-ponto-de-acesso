package com.inacio.Lives.Model;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BancoHoras {

	@Id
	@EmbeddedId
	@GeneratedValue
	private bancoHorasId id;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class bancoHorasId implements  Serializable{

		private static final long serialVersionUID = 1L;
		
		private Long idBandoHoras;
		private Long idMovimentacao;
		private Long idUsuario;
	
	}
}
