package com.inacioalves.live.model;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Localidade {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	@ManyToOne
	private NivelAcesso nivelAcesso;
}
