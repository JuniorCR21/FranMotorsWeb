package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.MotorbikeService;
import com.ms.franksmotor.model.db.Client;
import com.ms.franksmotor.model.db.Motorbike;
import com.ms.franksmotor.model.request.MotorbikeRequest;
import com.ms.franksmotor.model.response.MotorbikeResponse;
import com.ms.franksmotor.repository.ClientRepository;
import com.ms.franksmotor.repository.MotorbikeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorbikeServiceImpl implements MotorbikeService{
	
	@Autowired
	private MotorbikeRepository motorbikeRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Optional<MotorbikeResponse> createMotorBike(MotorbikeRequest request) {
		Optional<Client> client = clientRepository.findById(request.getClientId());
		if (client.isPresent()) {
			Motorbike motorbike = new Motorbike();
			motorbike.setBrand(request.getBrand());
			motorbike.setNumberPlate(request.getNumberPlate());
			motorbike.setSerialNumber(request.getSerialNumber());
			motorbike.setStatus(request.getStatus());
			motorbike.setYear(request.getYear());
			motorbike.setClient(client.get());
			motorbike = motorbikeRepository.save(motorbike);
			return Optional.of(new MotorbikeResponse(motorbike.getId(), 
					motorbike.getNumberPlate(), motorbike.getBrand(), 
					motorbike.getSerialNumber(), motorbike.getStatus(), 
					motorbike.getYear()));
		}
		return Optional.empty();
	}

}
