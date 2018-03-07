package com.websystique.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SOLICITUD")
public class Solicitud implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name="INSTITUCION_ID", unique=true, nullable=false)
	private Integer institucionId;
	
	@NotEmpty
	@Column(name="INSTITUCION_NOMBRE", nullable=false)
	private String institucionNombre;
	
	@Column(name="ESTADO_ID", unique=true, nullable=false)
	private Integer estadoId;
	
	@NotEmpty
	@Column(name="ESTADO_DES", nullable=false)
	private String estadoDes;
	
	@ManyToOne
    @JoinColumn(name="USER_ID")
	private User user;

	public Solicitud() {
		super();
	}

	public Solicitud(Integer id, Integer institucionId, String institucionNombre, Integer estadoId, String estadoDes, User user) {
		super();
		this.id = id;
		this.institucionId = institucionId;
		this.institucionNombre = institucionNombre;
		this.estadoId = estadoId;
		this.estadoDes = estadoDes;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInstitucionId() {
		return institucionId;
	}

	public void setInstitucionId(Integer institucionId) {
		this.institucionId = institucionId;
	}

	public String getInstitucionNombre() {
		return institucionNombre;
	}

	public void setInstitucionNombre(String institucionNombre) {
		this.institucionNombre = institucionNombre;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getEstadoDes() {
		return estadoDes;
	}

	public void setEstadoDes(String estadoDes) {
		this.estadoDes = estadoDes;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", institucionId=" + institucionId + ", institucionNombre=" + institucionNombre
				+ ", estadoId=" + estadoId + ", estadoDes=" + estadoDes + "]";
	}

	
	
	
}
