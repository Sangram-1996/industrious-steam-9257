package com.masai.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.LogInData;

public interface LoginDataDao  extends JpaRepository<LogInData, Integer>{

}
