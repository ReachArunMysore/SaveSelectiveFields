package com.example.demo.repo;

import com.example.demo.entity.MobileDeviceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileDeviceStatusRepo extends CrudRepository<MobileDeviceStatus, Long> {
}
