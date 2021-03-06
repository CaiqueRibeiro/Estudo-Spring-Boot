package com.caiqueribeiro.cursomc.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	private Double desconto;
	private Double preco;
	private Integer quantidade;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Double preco, Integer quantidade) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public double getSubtotal() {
		return (this.preco - this.desconto) * this.quantidade;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return this.id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		this.id.setPedido(pedido);
	}

	public Produto getProduto() {
		return this.id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		this.id.setProduto(produto);
	}
		
	public ItemPedidoPK getId() {
		return id;
	}
	public void setId(ItemPedidoPK id) {
		this.id = id;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(this.getProduto().getNome());
		builder.append(", Qte: ");
		builder.append(this.getQuantidade());
		builder.append(", Preço Unitário: ");
		builder.append(nf.format(this.getPreco()));
		builder.append(", Subtotal: ");
		builder.append(this.getSubtotal());
		builder.append("\n");
		return builder.toString();
	}
	
	

}
