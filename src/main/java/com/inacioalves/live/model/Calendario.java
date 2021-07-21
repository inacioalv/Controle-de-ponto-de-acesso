package com.inacioalves.live.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calendario {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private TipoData tipo;
	private String descricao;
	private LocalDateTime dataEspecial;

}
