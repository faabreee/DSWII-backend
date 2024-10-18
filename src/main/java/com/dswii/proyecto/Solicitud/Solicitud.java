package com.dswii.proyecto.Solicitud;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.dswii.proyecto.Producto.Producto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "idPro")
	private Integer idPro;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "idProveedor")
	private int idProveedor;

	@Column(name = "correo", length = 100)
	private String correo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "descripcion", columnDefinition = "TEXT")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idPro", insertable = false, updatable = false)
	private Producto objProducto;
}
