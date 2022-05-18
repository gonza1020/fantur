package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StandardPackage extends Package{
}
