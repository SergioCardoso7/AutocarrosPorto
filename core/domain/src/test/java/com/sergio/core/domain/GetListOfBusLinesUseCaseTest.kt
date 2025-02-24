package com.sergio.core.domain

import com.sergio.core.data.BusLineRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetListOfBusLinesUseCaseTest {



    private val testDispatcher = StandardTestDispatcher()
    private lateinit var busLineRepository: BusLineRepository
    private lateinit var getListOfBusLinesUseCase: GetListOfBusLinesUseCase


    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        busLineRepository = mockk(relaxed = true)
        getListOfBusLinesUseCase = GetListOfBusLinesUseCase(busLineRepository)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke should call getAllBusLine from repository`() = runTest {
        getListOfBusLinesUseCase.invoke()

        coVerify(exactly = 1) { busLineRepository.getAllBusLines()  }
    }

}