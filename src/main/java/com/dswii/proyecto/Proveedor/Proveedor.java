package com.dswii.proyecto.Proveedor;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ruc",nullable = false)
	private String ruc;

	@Column(name = "nomProvee", length = 100, nullable = false)
	private String nomProvee;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "telefono", length = 10)
	private String telefono;

	@Column(name = "direccion", length = 200)
	private String direccion;
	

}
