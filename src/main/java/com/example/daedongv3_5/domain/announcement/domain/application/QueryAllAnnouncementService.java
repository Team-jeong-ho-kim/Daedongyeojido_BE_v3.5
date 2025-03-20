package com.example.daedongv3_5.domain.announcement.domain.application;

import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.presentation.dto.response.AnnouncementListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllAnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Transactional(readOnly = true)
    public List<AnnouncementListResponse> queryAll() {
        return announcementRepository.findAll()
                .stream()
                .map(announcement -> new AnnouncementListResponse(announcement))
                .collect(Collectors.toList());
    }
}
