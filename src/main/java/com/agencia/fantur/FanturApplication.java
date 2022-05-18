package com.agencia.fantur;

import com.agencia.fantur.enums.ActivityType;
import com.agencia.fantur.enums.Schedule;
import com.agencia.fantur.enums.TicketType;
import com.agencia.fantur.model.*;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.repository.CityRepository;
import com.agencia.fantur.repository.PackageRepository;
import com.agencia.fantur.repository.ResidenceRepository;
import com.agencia.fantur.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class FanturApplication implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(FanturApplication.class, args);


		System.out.println("Ejecutando aplicacion en Spring Boot");
	}
	@Autowired
	private PackageRepository packageRepository;
	@Autowired
	private ResidenceRepository residenceRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	CityRepository cityRepository;

	@Override
	public void run(String... args) throws Exception {
		Package packageStandard = new StandardPackage();
		City city =  new City();
		city.setName("Qatar");
		city.setZipCode(123123);
		//cityRepository.save(city);

		Residence residence = new Residence();
		residence.setEnd(new Date());
		residence.setSince(new Date());
		residence.setCity(city);
		residence.setDescription("Hotel turismo 5 estrellas en corrientes");
		residence.setPrice(1234.54);
		//residenceRepository.save(residence);

		Ticket ticket1 = new Ticket();
		ticket1.setTicketType(TicketType.AIR);
		ticket1.setFrom(city);
		ticket1.setTo(city);
		ticket1.setPrice(1234.0);
		ticket1.setDepartureDate(new Date());
		ticket1.setReturnDate(new Date());


	/*
		Activity activity1 = new Activity();

		activity1.setPrice(1234.0);
		activity1.setSchedule(Schedule.NIGHT);
		activity1.setType(ActivityType.MATCH);


		List<Activity> activities = new ArrayList<>();
		activities.add(activity1);*/

		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);

		packageStandard.setResidence(residence);
		packageStandard.setPrice(12345.323);
		packageStandard.setTickets(tickets);
		//packageStandard.setActivities(activities);
		packageRepository.save(packageStandard);
	}
}
