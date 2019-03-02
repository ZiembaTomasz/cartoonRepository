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
public class EpisodesController {
    private EpisodService episodService;
    @RequestMapping(method = RequestMethod.GET, value = "/{seasonId}/episodes")
    public List<EpisodDto>getEpisods(@PathVariable Long seasonId){

        return episodService.getEpisods(seasonId);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{seasonId}/episode")
    public EpisodDto getEpisod(@PathVariable Long episodId){
        return episodService.getEpisod(episodId);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/{seasonId}/episode/{episodId}")
    public EpisodDto updateEpisod(@RequestBody EpisodDto episodDto, @PathVariable Long seasonId,
                                  @PathVariable Long episodId){
        return episodService.saveEpisod(episodDto, seasonId);

    }
    @RequestMapping(method = RequestMethod.POST, value = "/{seasonId}/episode")
    public void createEpisod(@RequestBody EpisodDto episodDto, @PathVariable Long seasonId){
         episodService.saveEpisod(episodDto, seasonId);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{seasonId}/episode/{episodId}")
    public void deleteEpisode(@PathVariable Long episodId, @PathVariable Long seasonId){
        episodService.deleteEpisode(episodId);
    }

}
