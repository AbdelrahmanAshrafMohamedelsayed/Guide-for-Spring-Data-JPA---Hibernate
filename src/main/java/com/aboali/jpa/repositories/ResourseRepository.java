package com.aboali.jpa.repositories;

import com.aboali.jpa.models.Resource;
import com.aboali.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourseRepository extends JpaRepository<Resource, Integer> {
}
