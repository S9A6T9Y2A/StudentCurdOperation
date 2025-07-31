package com.sp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_register")
@Setter
@Getter
public class Student {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "student-seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 40)
	private String name;

	@Column(length = 60)
	private String email;

	@Column(length = 30)
	private String course;

}
