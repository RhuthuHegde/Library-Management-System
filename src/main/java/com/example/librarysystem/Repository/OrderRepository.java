package com.example.librarysystem.Repository;

import com.example.librarysystem.Models.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<BookOrder,Long> {
}
