package com.dswii.proyecto.Producto;

import java.util.Date;


import com.dswii.proyecto.Proveedor.Proveedor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "codPro", length = 100, nullable = false)
	private String codPro;

	@Column(name = "nomPro", length = 50, nullable = false)
	private String nomPro;

	@Column(name = "proveedor", nullable = false)
	private int proveedor;

	@Column(name = "stock", columnDefinition = "INT CHECK (stock >= 0)")
	private int stock;

	@Column(name = "precio")
	private double precio;

	@Column(name = "fechaCompra")
	private Date fechaCompra;

	@ManyToOne
	  @JoinColumn(name = "proveedor", insertable = false,updatable = false)
	  private Proveedor objProveedor;
	
	
}
