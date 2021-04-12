package com.aa.awesomecareer.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateModel {
	private Integer id;
	private Integer userId;
	private String title;
	private Date issuedTime;
}
