package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.ScheduleDTO;

public interface ScheduleService {
	public List<Schedule> getAllSchedules();

	public ScheduleDTO getScheduleById(Long id);

	public Schedule saveSchedule(Schedule schedule);

	public void deleteSchedule(Long id);
}
