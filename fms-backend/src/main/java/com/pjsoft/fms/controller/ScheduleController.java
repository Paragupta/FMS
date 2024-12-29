package com.pjsoft.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.ScheduleDTO;
import com.pjsoft.fms.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@GetMapping
	public List<Schedule> getAllSchedules() {
		return scheduleService.getAllSchedules();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable Long id) {
		return ResponseEntity.ok(scheduleService.getScheduleById(id));
	}

	@PostMapping
	public Schedule createSchedule(@RequestBody Schedule schedule) {
		return scheduleService.saveSchedule(schedule);
	}

	@PutMapping("/{id}")
	public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
		schedule.setId(id);
		return scheduleService.saveSchedule(schedule);
	}

	@DeleteMapping("/{id}")
	public void deleteSchedule(@PathVariable Long id) {
		scheduleService.deleteSchedule(id);
	}
}
