package com.sergio.core.domain

import com.sergio.core.data.BusLineRepository
import com.sergio.core.model.BusLine
import com.sergio.core.model.BusStop
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test


class FakeBusLineRepository : BusLineRepository {
    override suspend fun getAllBusLines(): Flow<List<BusLine>> {
        val sampleBusStop = BusStop()
        val sampleBusLine = BusLine(
            lineCode = "001",
            busLineDirectionOne = BusLine.BusLineDirection(0, sampleBusStop),
            busLineDirectionTwo = BusLine.BusLineDirection(1, sampleBusStop),
            busStopsOfLine = listOf(sampleBusStop)
        )

        return flowOf(listOf(sampleBusLine))
    }
}


class GetListOfBusLinesUseCaseIntegrationTest {

    private val fakeRepository = FakeBusLineRepository()
    private val getListOfBusLinesUseCase = GetListOfBusLinesUseCase(fakeRepository)

    @Test
    fun `use case integration test should emit correct bus lines`() = runTest {
        val flowResult = getListOfBusLinesUseCase.invoke()

        flowResult.collect { busLines ->
            assertEquals(1,busLines.size)
            assertEquals("001", busLines.first().lineCode)

        }

    }


}