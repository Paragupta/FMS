package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.mapper.ScheduleMapper;
import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.ScheduleDTO;
import com.pjsoft.fms.repository.ScheduleRepository;
import com.pjsoft.fms.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private ScheduleMapper scheduleMapper;

	@Override
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public ScheduleDTO getScheduleById(Long id) {
		return scheduleMapper.entityToDtoMapper(scheduleRepository.findById(id).orElse(null));
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public void deleteSchedule(Long id) {
		scheduleRepository.deleteById(id);
	}
}
