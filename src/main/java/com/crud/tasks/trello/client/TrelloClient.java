package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.user}")
    private String trelloUsername;
    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards(){

        URI url = getUri();
        System.out.println(url);

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();

    }
    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto){
        URI url =UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("badges", "all")
                .queryParam("idList", trelloCardDto.getListId()).build().encode().toUri();
        return restTemplate.postForObject(url, null, CreatedTrelloCard.class);

    }

    private URI getUri() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                    .queryParam("key", trelloAppKey)
                    .queryParam("token", trelloToken)
                    .queryParam("fields", "name,id")
                    .queryParam("lists", "all").build().encode().toUri();

    }
}
