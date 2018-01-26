package com.itDev.puntoVentas.data.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idventa;

	private Timestamp fechacreacion;

	private Timestamp fechapego;

	private String identificadorcliente;

	private BigDecimal montoentregado;

	private BigDecimal montorecibido;

	private BigDecimal montototal;

	private String status;

	private String tipopago;

	private String tipoventa;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="venta")
	private List<Detalle> detalles;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="idsucursal")
	private Sucursal sucursal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Venta() {
	}

	public Integer getIdventa() {
		return this.idventa;
	}

	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Timestamp getFechapego() {
		return this.fechapego;
	}

	public void setFechapego(Timestamp fechapego) {
		this.fechapego = fechapego;
	}

	public String getIdentificadorcliente() {
		return this.identificadorcliente;
	}

	public void setIdentificadorcliente(String identificadorcliente) {
		this.identificadorcliente = identificadorcliente;
	}

	public BigDecimal getMontoentregado() {
		return this.montoentregado;
	}

	public void setMontoentregado(BigDecimal montoentregado) {
		this.montoentregado = montoentregado;
	}

	public BigDecimal getMontorecibido() {
		return this.montorecibido;
	}

	public void setMontorecibido(BigDecimal montorecibido) {
		this.montorecibido = montorecibido;
	}

	public BigDecimal getMontototal() {
		return this.montototal;
	}

	public void setMontototal(BigDecimal montototal) {
		this.montototal = montototal;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipopago() {
		return this.tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getTipoventa() {
		return this.tipoventa;
	}

	public void setTipoventa(String tipoventa) {
		this.tipoventa = tipoventa;
	}

	public List<Detalle> getDetalles() {
		return this.detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Detalle addDetalle(Detalle detalle) {
		getDetalles().add(detalle);
		detalle.setVenta(this);

		return detalle;
	}

	public Detalle removeDetalle(Detalle detalle) {
		getDetalles().remove(detalle);
		detalle.setVenta(null);

		return detalle;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}