package com.example.Card.controller;

import com.example.Card.ICardService.ICardService;
import com.example.Card.dto.AccountCreationDto;
import com.example.Card.dto.CardDto;
import com.example.Card.dto.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/card", produces = (MediaType.APPLICATION_JSON_VALUE))
@Tag(name = "Card", description = "APIs for managing card.")
public class CardController {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

    @Value("${build.version}")
    private String buildVersion;



    @Autowired
    private AccountCreationDto accountCreationDto;

    @Autowired
    private ICardService iCardService;


    @Operation(
            summary = "Create a new Card",
            description = "This endpoint allows you to create a new loan by providing necessary details in the requstparam.",
            tags = {"Card"}
    )
    //http://localhost:8887/api/card/create
    @PostMapping("/create")
    public Result craeteCard(@RequestParam("mobileno") String mobileNo) {
        Result card = iCardService.createCard(mobileNo);
        return card;
    }

    @Operation(
            summary = "Fetch a new Card",
            description = "This endpoint allows you to fetch a new card by providing necessary details in the requstparam.",
            tags = {"Card"}
    )
    //http://localhost:8887/api/card/get
    @GetMapping("/get")
    public Result getCard(@RequestParam("mobileNo") String mobileNo) {
        Result result = iCardService.fetchedCard(mobileNo);
        return result;
    }

    @Operation(
            summary = "Fetch a new Card",
            description = "This endpoint allows you to update a new card by providing necessary details in the requstparam.",
            tags = {"Card"}
    )
    //http://localhost:8887/api/card/update
    @PutMapping("/update")
    public Result updateCard(@RequestBody CardDto cardDto) {
        Result result = iCardService.updateCard(cardDto);
        return result;
    }

    @Operation(
            summary = "Fetch a new Card",
            description = "This endpoint allows you to delete a new card by providing necessary details in the requstparam.",
            tags = {"Card"}
    )
    //http://localhost:8887/api/card/delete
    @DeleteMapping("/delete")
    public Result deleteCard(@RequestParam("mobileNo") String mobileNO) {
        Result result = iCardService.deleteCard(mobileNO);
        return result;
    }

//    ===========================================================
    //two api for spring profile
//    ===========================================================

    @GetMapping("/get/version")
    public ResponseEntity<?> getVersionFromApplicationYmlFromDifferntEnv() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping("/get/multiple-value")
    public ResponseEntity<?> getMultipleValueWithDiiferntEnv() {
        return new ResponseEntity<>(accountCreationDto, HttpStatus.OK);
    }
}
