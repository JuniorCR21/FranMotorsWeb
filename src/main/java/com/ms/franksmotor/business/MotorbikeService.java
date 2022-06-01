package com.ms.franksmotor.business;

import com.ms.franksmotor.model.request.MotorbikeRequest;
import com.ms.franksmotor.model.response.MotorbikeResponse;
import java.util.Optional;

public interface MotorbikeService {

	Optional<MotorbikeResponse> createMotorBike (MotorbikeRequest request);
}
