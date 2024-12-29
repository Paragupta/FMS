package com.pjsoft.fms.pojo.request;

import java.math.BigInteger;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightDTO {

	private Long id;

	private BigInteger flightNo;

	private String carrierName;

	private String flightModel;

	private int seatCapacity;

	private List<ScheduledFlightDTO> scheduledFlightList;

}
