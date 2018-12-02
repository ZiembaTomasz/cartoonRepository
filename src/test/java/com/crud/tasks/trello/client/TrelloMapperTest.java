package com.crud.tasks.trello.client;


import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void mapToCardTest(){

        TrelloCardDto trelloCardDto = new TrelloCardDto("Jacek", "Martens", "second", "1234");

        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
    }
    @Test
    public void mapToCardDto(){

        TrelloCard trelloCard = new TrelloCard("Andrew", "Podolski", "third", "1356");

        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
    }
    @Test
    public void mapToListTest(){

        TrelloListDto trelloListDto = new TrelloListDto("Smith", "Will", true);

        List<TrelloListDto>trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        List<TrelloList>trelloLists = trelloMapper.mapToList(trelloListDtos);

        assertEquals(trelloLists.get(0).getName(), trelloListDtos.get(0).getName());

    }
    @Test
    public void mapToListDto(){
        TrelloList trelloList = new TrelloList("37", "George", false);
        List<TrelloList>trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        List<TrelloListDto>trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        assertEquals(trelloLists.get(0).getName(), trelloListDtos.get(0).getName());
    }
    @Test
    public void testMapToBoardDto(){
        List<TrelloList>lists = new ArrayList<>();
        List<TrelloBoard>trelloBoardList = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("34", "Jones",lists);
        trelloBoardList.add(trelloBoard);
        List<TrelloBoardDto>trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoardList);
        assertEquals(trelloBoardList.get(0).getId(), trelloBoardDtos.get(0).getId());
    }
    @Test
    public void testMapToBoard(){
        List<TrelloListDto>trelloListsDto = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("32", "Spider", trelloListsDto);
        List<TrelloBoardDto>trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);
        List<TrelloBoard>trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        assertEquals(trelloBoardDtos.get(0).getId(), trelloBoards.get(0).getId());

    }
}
