package com.pjsoft.fms.pojo.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassengerDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private LocalDate dateOfBirth;

}
