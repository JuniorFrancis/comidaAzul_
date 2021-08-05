package br.com.softblue.bluefood.domain.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
@Table(name = "restaurante")
public class Restaurante extends Usuario {

	@NotBlank
	@Pattern(regexp= "{14} [0-9]", message = "O CNPJ possu� formato inv�lido")
	@Column(length=14, nullable = false)
	public String cnpj;
	
	@Size(max = 80)
	public String logotipo;
	
	@NotNull(message = "A taxa de entrega n�o pode ser vazia")
	@Min(0)
	@Max(99)
	private BigDecimal taxaEntrega;
	
	@NotNull(message = "O tempo de entrega n�o pode ser vazio")
	@Min(0)
	@Max(120)
	private Integer tempoEntregaBase;
	
	@ManyToMany
	@JoinTable(
			name = "restaurante_has_categoria",
			joinColumns = @JoinColumn(name = "restaurante_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id")
			)
	private Set<CategoriaRestaurante> categorias = new HashSet<CategoriaRestaurante>(0);
	
	
}