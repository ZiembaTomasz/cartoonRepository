package com.crud.tasks.controller;

import com.crud.tasks.domain.Episod;
import com.crud.tasks.domain.EpisodDto;
import com.crud.tasks.domain.Season;
import com.crud.tasks.domain.SeasonDto;
import com.crud.tasks.service.EpisodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/season")
@RestController
@AllArgsConstructor
public class SeasonController {
    private EpisodService episodService;
    @RequestMapping(method = RequestMethod.GET, value = "/{seasonId}/episodes")
    public List<EpisodDto>getEpisods(@PathVariable Long seasonId){

        return episodService.getEpisods(seasonId);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/{seasonId}/episode")
    public EpisodDto createEpisod(@RequestBody EpisodDto episodDto, @PathVariable Long seasonId){
        return episodService.saveEpisod(episodDto, seasonId);

    }

}
