package ru.venidiktov.springiscoming.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.venidiktov.springiscoming.repository.BankDao;
import ru.venidiktov.springiscoming.service.MoneyService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Iron bank", description = "Запросы в \"Железный банк\"")
public class IronBankController {
    private final MoneyService moneyService;
    private final BankDao bankDao;

    @GetMapping(path = "/credit", produces = MediaType.TEXT_HTML_VALUE)
    @Operation(summary = "Выдать кредит")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(examples = {
            @ExampleObject(name = "Отказать", value = "Отказать дому Stark, извините вы можете <b>не пережить</b> зиму"),
            @ExampleObject(name = "Одобрить", value = "<i>Одобрить дому Targaryen.</i><br/>Текущий баланс банка: <b>999999000</b>")
    })})})
    public String credit(
            @RequestParam @Parameter(description = "Дом", example = "Stark", examples = {
                    @ExampleObject(name = "Stark", value = "Stark"),
                    @ExampleObject(name = "Targaryen", value = "Targaryen"),
                    @ExampleObject(name = "Lannister", value = "Lannister")}) String name,
            @RequestParam @Parameter(description = "Сумма золота", example = "1000") long amount) {
        long resultDeposit = moneyService.transfer(name, amount);
        if (resultDeposit == -1) {
            return "Отказать дому %s, извините вы можете <b>не пережить</b> зиму".formatted(name);
        }
        return "<i>Одобрить дому %s.</i><br/>Текущий баланс банка: <b>%s</b>".formatted(name, resultDeposit);
    }

    @GetMapping(path = "/state", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Количество золота в банке")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(examples = @ExampleObject("999999000"))})})
    public long currentState() {
        return bankDao.getIronBank().getTotalAmount();
    }
}
