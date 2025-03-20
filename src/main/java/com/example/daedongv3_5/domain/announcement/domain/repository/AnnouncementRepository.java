package com.example.daedongv3_5.domain.announcement.domain.repository;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
