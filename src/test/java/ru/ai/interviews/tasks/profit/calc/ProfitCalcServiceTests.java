package ru.ai.interviews.tasks.profit.calc;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ai.interviews.tasks.profit.calc.application.ProfitCalcService;
import ru.ai.interviews.tasks.profit.calc.domain.entity.Operation;
import ru.ai.interviews.tasks.profit.calc.domain.entity.OperationType;
import ru.ai.interviews.tasks.profit.calc.domain.value.PortfolioStatistic;
import ru.ai.interviews.tasks.profit.calc.domain.value.ProfitByTicker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalcServiceTests {
    private final ProfitCalcService profitCalcService = new ProfitCalcService();

    @Test
    @DisplayName("""
        Расчет статистики портфеля акций.
        """)
    void testCase1() {
        final PortfolioStatistic expected = PortfolioStatistic.builder()
            .absProfit(22500D)
            .profitByTickers(
                List.of(
                    ProfitByTicker.builder()
                        .ticker("AFKS")
                        .profit(-8000D)
                        .build(),
                    ProfitByTicker.builder()
                        .ticker("GAZP")
                        .profit(25000D)
                        .build(),
                    ProfitByTicker.builder()
                        .ticker("SBER")
                        .profit(6500D)
                        .build()
                )
            )
            .build();

        final PortfolioStatistic actual = profitCalcService.calc(getOperations());

        assertEquals(expected, actual);
    }

    private List<Operation> getOperations() {
        return List.of(
          Operation.builder()
              .number(1L)
              .operationType(OperationType.BUY)
              .ticker("AFKS")
              .price(12D)
              .qnt(2000)
              .build(),
            Operation.builder()
                .number(2L)
                .operationType(OperationType.BUY)
                .ticker("GAZP")
                .price(200D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(3L)
                .operationType(OperationType.BUY)
                .ticker("SBER")
                .price(110D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(4L)
                .operationType(OperationType.BUY)
                .ticker("AFKS")
                .price(13D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(5L)
                .operationType(OperationType.BUY)
                .ticker("AFKS")
                .price(14D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(6L)
                .operationType(OperationType.BUY)
                .ticker("GAZP")
                .price(205D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(7L)
                .operationType(OperationType.BUY)
                .ticker("SBER")
                .price(112D)
                .qnt(500)
                .build(),
            Operation.builder()
                .number(7L)
                .operationType(OperationType.BUY)
                .ticker("SBER")
                .price(112D)
                .qnt(500)
                .build(),
            Operation.builder()
                .number(8L)
                .operationType(OperationType.SELL)
                .ticker("AFKS")
                .price(13D)
                .qnt(1000)
                .build(),
            Operation.builder()
                .number(9L)
                .operationType(OperationType.BUY)
                .ticker("GAZP")
                .price(210D)
                .qnt(10000)
                .build(),
            Operation.builder()
                .number(10L)
                .operationType(OperationType.SELL)
                .ticker("AFKS")
                .price(10D)
                .qnt(3000)
                .build(),
            Operation.builder()
                .number(11L)
                .operationType(OperationType.SELL)
                .ticker("SBER")
                .price(115D)
                .qnt(1500)
                .build(),
            Operation.builder()
                .number(12L)
                .operationType(OperationType.DIV)
                .ticker("GAZP")
                .price(1D)
                .qnt(10000)
                .build(),
            Operation.builder()
                .number(13L)
                .operationType(OperationType.SELL)
                .ticker("GAZP")
                .price(210D)
                .qnt(12000)
                .build(),
            Operation.builder()
                .number(14L)
                .operationType(OperationType.TAX)
                .price(1D)
                .qnt(1000)
                .build()
        );
    }
}
