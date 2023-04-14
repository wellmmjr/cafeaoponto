package com.example.cafeaoponto.data.model.v1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente extends Usuario implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="first_name", nullable = false, length = 20)
		private String firstName;
		
		@Column(name="second_name", length = 50)
		private String secondName;
		
		@Column(length = 100)
		private String address;
		
		@Column(length = 20)
		private String gender;
		
		@Column(length = 20)
		private Boolean enabled;
}
