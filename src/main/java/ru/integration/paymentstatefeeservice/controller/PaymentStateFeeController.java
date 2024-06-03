package ru.integration.paymentstatefeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.integration.paymentstatefeeservice.dto.PaymentStateFeeResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Контроллер для операций об уплате государственной пошлины
 */
@RestController
@RequestMapping("/api/v1/payment/")
@RequiredArgsConstructor
@Tag(name = "Контроллер для операций об уплате государственной пошлины")
@Slf4j
public class PaymentStateFeeController {

    @PostMapping("/uai")
    @Operation(description = "Обновление контрагента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешная обработка"),
            @ApiResponse(responseCode = "400", description = "Ошибка форматно-логического контроля"),
            @ApiResponse(responseCode = "404", description = "Платеж по указанному УИН не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка обработки")
    })
    public ResponseEntity<PaymentStateFeeResponseDTO> update(@RequestBody String uai) {
        log.info("Поступило сообщение об уплате государственной пошлины {}", uai);
        return ResponseEntity.ok(PaymentStateFeeResponseDTO.builder()
                .paymentDate(LocalDateTime.now())
                .payerKpp("187374544")
                .payerInn("595707270040")
                .payerName("ООО Тест")
                .amount(new BigDecimal("100.15"))
                .payeeOktmo("54321")
                .purpose("тестовое назначение")
                .upi("123")
                .build()
        );
    }
}
