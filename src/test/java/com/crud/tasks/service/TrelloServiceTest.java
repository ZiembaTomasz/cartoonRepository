package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {
    @InjectMocks
    private TrelloService trelloService;
    @Mock
    private TrelloClient trelloClient;

    @Test
    public void fetchTrelloBoards() {
        TrelloListDto trelloListDto = new TrelloListDto("Hanny", "Piere", false);
        List<TrelloListDto>trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

         List<TrelloBoardDto>boards = trelloService.fetchTrelloBoards();
        assertEquals(0, boards.size());
    }
    @Test
    public void createTrelloCardTest(){
        TrelloCardDto trelloCardDto = new TrelloCardDto("Hej", "Angel", "Come", "To");

        trelloService.createTrelloCard(trelloCardDto);
        assertEquals("Hej", trelloCardDto.getName());
    }
}