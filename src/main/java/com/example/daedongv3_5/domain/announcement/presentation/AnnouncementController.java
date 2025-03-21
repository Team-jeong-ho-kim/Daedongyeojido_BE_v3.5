package com.example.daedongv3_5.domain.announcement.presentation;

import com.example.daedongv3_5.domain.announcement.domain.application.*;
import com.example.daedongv3_5.domain.announcement.presentation.dto.request.AnnouncementRequest;
import com.example.daedongv3_5.domain.announcement.presentation.dto.request.UpdateAnnouncementRequest;
import com.example.daedongv3_5.domain.announcement.presentation.dto.response.AnnouncementListResponse;
import com.example.daedongv3_5.domain.announcement.presentation.dto.response.AnnouncementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@RequiredArgsConstructor
public class AnnouncementController {
    private final CreateAnnouncementService createAnnouncementService;
    private final QueryAllAnnouncementService queryAllAnnouncementService;
    private final QueryAnnouncementService queryAnnouncementService;
    private final UpdateAnnouncementService updateAnnouncementService;
    private final DeleteAnnouncementService deleteAnnouncementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnnouncement(@RequestBody @Valid AnnouncementRequest request) {
        createAnnouncementService.createAnnouncement(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnnouncementListResponse> queryAll() {
        return queryAllAnnouncementService.queryAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnnouncementResponse queryAnnouncement(@PathVariable Long id) {
        return queryAnnouncementService.queryAnnouncement(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAnnouncement(@RequestBody @Valid UpdateAnnouncementRequest request) {
        updateAnnouncementService.updateAnnouncement(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnnouncement(@PathVariable Long id) {
        deleteAnnouncementService.deleteAnnouncement(id);
    }


}
