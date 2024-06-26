package com.kipaskipas.order.model;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
  @GenericGenerator(name = "pg-uuid", strategy = "uuid2")
  @Column(name = "id", length = 50)
  private String id;

  @NotEmpty(message = "name_is_required")
  @Column(name = "name", length = 50)
  private String name;

  @NotEmpty(message = "address_is_required")
  @Column(name = "address", length = 200)
  private String address;

  @NotEmpty(message = "phone_is_required")
  @Column(name = "phone", length = 200)
  private String phone;

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