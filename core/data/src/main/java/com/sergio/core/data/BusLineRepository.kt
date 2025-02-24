package com.sergio.core.data

import com.sergio.core.model.BusLine
import kotlinx.coroutines.flow.Flow

interface BusLineRepository {
    suspend fun getAllBusLines(): Flow<List<BusLine>>
}