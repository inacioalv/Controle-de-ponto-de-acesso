package com.inacio.Lives.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private BigDecimal tolerancia;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalDateTime inicioJornada;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime finalJornada;
	
	@ManyToOne
	private CategoriaUsuario categoriaUsuarioId;
	@ManyToOne
	private Empresa empresaId;
	@ManyToOne
	private NivelAcesso acessoId;
	@ManyToOne
	private JornadaTrabalho jornadaTrabalhoId;

}
