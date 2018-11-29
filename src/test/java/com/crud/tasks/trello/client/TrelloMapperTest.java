package com.crud.tasks.trello.client;


import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void mapToCardTest(){
        TrelloCard trelloCard = new TrelloCard("Andrew", "Podolski", "third", "1356");
        TrelloCardDto trelloCardDto = new TrelloCardDto("Jacek", "Martens", "second", "1234");
        trelloCard = trelloMapper.mapToCard(trelloCardDto);
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
    }
    @Test
    public void mapToCardDto(){
        TrelloCardDto trelloCardDto = new TrelloCardDto("Jacek", "Martens", "second", "1234");
        TrelloCard trelloCard = new TrelloCard("Andrew", "Podolski", "third", "1356");
        trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());



    }

}
