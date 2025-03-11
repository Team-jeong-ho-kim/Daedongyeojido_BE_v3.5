package com.example.daedongv3_5.domain.club.presentation;

import com.example.daedongv3_5.domain.club.application.CreateClubService;
import com.example.daedongv3_5.domain.club.presentation.dto.request.ClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {
    private final CreateClubService createClubService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClub(@RequestBody ClubRequest request) {
        createClubService.createClub(request);
    }
}
