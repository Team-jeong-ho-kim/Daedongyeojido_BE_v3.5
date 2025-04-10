package com.example.daedongv3_5.domain.club.presentation;

import com.example.daedongv3_5.domain.club.application.*;
import com.example.daedongv3_5.domain.club.presentation.dto.request.ClubRequest;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {
    private final CreateClubService createClubService;
    private final QueryAllClubService queryAllClubService;
    private final UpdateClubInfoService updateClubInfoService;
    private final DeleteClubService deleteClubService;
    private final QueryClubInfoService queryClubInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClub(@RequestBody @Valid ClubRequest request) {
        createClubService.createClub(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubListResponse> queryAllClub() {
        return queryAllClubService.queryAllClub();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubResponse queryClubInfo(@PathVariable Long id) {
        return queryClubInfoService.queryClubInfo(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateClubInfo(@RequestBody @Valid UpdateClubRequest request) {
        updateClubInfoService.updateClub(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClub(@PathVariable Long id) {
        deleteClubService.deleteClub(id);
    }
}