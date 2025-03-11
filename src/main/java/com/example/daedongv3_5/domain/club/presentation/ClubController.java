package com.example.daedongv3_5.domain.club.presentation;

import com.example.daedongv3_5.domain.club.application.CreateClubService;
import com.example.daedongv3_5.domain.club.application.DeleteClubService;
import com.example.daedongv3_5.domain.club.application.QueryAllClubService;
import com.example.daedongv3_5.domain.club.application.UpdateClubService;
import com.example.daedongv3_5.domain.club.presentation.dto.request.ClubRequest;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
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
    private final UpdateClubService updateClubService;
    private final DeleteClubService deleteClubService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClub(@RequestBody ClubRequest request) {
        createClubService.createClub(request);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubListResponse> queryAllClub() {
        return queryAllClubService.queryAllClub();
    }

    @PatchMapping("/{clubName}")
    @ResponseStatus(HttpStatus.OK)
    public void udpateClub(@PathVariable String clubName, @RequestBody UpdateClubRequest request) {
        updateClubService.updateClub(clubName, request);
    }

    @DeleteMapping("/{clubName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClub(@PathVariable String clubName) {
        deleteClubService.deleteClub(clubName);
    }
}
