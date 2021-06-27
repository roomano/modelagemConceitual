package com.roomano786.mc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	public Cidade() {

	}

	public Cidade(Integer id, String nome, Provincia provincia) {
		super();
		this.id = id;
		this.nome = nome;
		this.provincia = provincia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Provincia getEstado() {
		return provincia;
	}

	public void setEstado(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cidade cidade = (Cidade) o;
		return id.equals(cidade.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
