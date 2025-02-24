package com.sergio.core.model

data class BusLine(
    val lineCode: String,
    val busLineDirectionOne: BusLineDirection,
    val busLineDirectionTwo: BusLineDirection,
    val busStopsOfLine: List<BusStop>
) {

    data class BusLineDirection(
        val directionNumber: Int,
        val directionEndBusStopStop: BusStop
    )
}

