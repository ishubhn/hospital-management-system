package io.management.hospital.service.impl;

public class NoSuchDoctorEntityException extends RuntimeException {
	public NoSuchDoctorEntityException(String errMessage) {
		super(errMessage);
	}
}
