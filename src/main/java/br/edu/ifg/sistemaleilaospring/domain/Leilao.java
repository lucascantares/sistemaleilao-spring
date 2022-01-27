package br.edu.ifg.sistemaleilaospring.domain;

import java.io.Serializable;

public class Leilao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	long codLeilao;
	String item;
	String dataAbertura;
	double lanceMinimo;
	double lanceAtual;
	String dataFechameto;
	String situacao;
	public Leilao() {
		
	}
	public Leilao(long codLeilao, String item, String dataAbertura, double lanceMinimo, double lanceAtual,
			String dataFechameto, String situacao) {
		super();
		this.codLeilao = codLeilao;
		this.item = item;
		this.dataAbertura = dataAbertura;
		this.lanceMinimo = lanceMinimo;
		this.lanceAtual = lanceAtual;
		this.dataFechameto = dataFechameto;
		this.situacao = situacao;
	}
	public long getCodLeilao() {
		return codLeilao;
	}
	public void setCodLeilao(long codLeilao) {
		this.codLeilao = codLeilao;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public double getLanceMinimo() {
		return lanceMinimo;
	}
	public void setLanceMinimo(float lanceMinimo) {
		this.lanceMinimo = lanceMinimo;
	}
	public double getLanceAtual() {
		return lanceAtual;
	}
	public void setLanceAtual(float lanceAtual) {
		this.lanceAtual = lanceAtual;
	}
	public String getDataFechameto() {
		return dataFechameto;
	}
	public void setDataFechameto(String dataFechameto) {
		this.dataFechameto = dataFechameto;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codLeilao ^ (codLeilao >>> 32));
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((dataFechameto == null) ? 0 : dataFechameto.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lanceAtual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lanceMinimo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leilao other = (Leilao) obj;
		if (codLeilao != other.codLeilao)
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataFechameto == null) {
			if (other.dataFechameto != null)
				return false;
		} else if (!dataFechameto.equals(other.dataFechameto))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Double.doubleToLongBits(lanceAtual) != Double.doubleToLongBits(other.lanceAtual))
			return false;
		if (Double.doubleToLongBits(lanceMinimo) != Double.doubleToLongBits(other.lanceMinimo))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}
	
}
