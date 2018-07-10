package com.example.demoww.dao;

import com.example.demoww.entity.DateEntify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateDao extends JpaRepository<DateEntify,Integer> {
}
