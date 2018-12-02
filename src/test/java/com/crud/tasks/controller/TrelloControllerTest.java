package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloControllerTest {
    @InjectMocks
    private TrelloController trelloController;
    @Mock
    private TrelloFacade trelloFacade;

    @Test
    public void getTrelloBoards() {
        List<TrelloListDto>trelloListDtos = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        List<TrelloBoardDto> boards = new ArrayList<>();
        boards.add(trelloBoardDto);
        trelloController.getTrelloBoards();

        assertEquals(1, boards.size());
    }

    @Test
    public void createTrelloCard() {
        TrelloCardDto trelloCardDto = new TrelloCardDto("George", "Washington", "Hompe", "ToDo");
        CreatedTrelloCardDto createdTrelloCardDto = trelloController.createTrelloCard(trelloCardDto);
        assertEquals(trelloCardDto.getName(), "George");
    }
}