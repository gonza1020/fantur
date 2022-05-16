package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "standard_package")
public class StandardPackage extends Package{
}
