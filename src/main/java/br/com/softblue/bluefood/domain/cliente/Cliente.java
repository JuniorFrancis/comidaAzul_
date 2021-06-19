package br.com.softblue.bluefood.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
public class Cliente extends Usuario{

	@Column(length = 8, nullable=false)
	public String CPF;
	
	@Column(length = 11, nullable=false)
	public String CEP;
	

	
}