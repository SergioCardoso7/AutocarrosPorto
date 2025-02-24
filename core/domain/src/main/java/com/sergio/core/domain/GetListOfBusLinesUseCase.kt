package com.sergio.core.domain

import com.sergio.core.data.BusLineRepository
import com.sergio.core.model.BusLine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListOfBusLinesUseCase @Inject constructor(private val busLineRepository: BusLineRepository) {


    suspend operator fun invoke(): Flow<List<BusLine>> {

        return busLineRepository.getAllBusLines()

    }

}