package com.kipaskipas.order.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "orders")
public class Order {

  // private static final long serialVersionUID = 6164062577693929852L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
  @GenericGenerator(name = "pg-uuid", strategy = "uuid2")
  @Column(name = "id", length = 50)
  private String id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @NotEmpty(message = "customer_name_is_required")
  @Column(name = "customer_name", length = 50)
  private String customerName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Product product;

  @NotEmpty(message = "product_name_is_required")
  @Column(name = "product_name", length = 50)
  private String productName;

  @NotEmpty(message = "amount_is_required")
  @Column(name = "amount")
  private BigDecimal amount;

  @NotEmpty(message = "price_is_required")
  @Column(name = "price")
  private Integer price;

  @NotEmpty(message = "stock_is_required")
  @Column(name = "stock")
  private Integer stock;

  @Column(name = "is_actived")
  private Boolean isActived = true;

  @Column(name = "is_deleted")
  private Boolean isDeleted = false;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Date createdAt;

  @Column(name = "created_by", length = 50, updatable = false)
  private String createdBy;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

  @Column(name = "updated_by", length = 50)
  private String updatedBy;

}