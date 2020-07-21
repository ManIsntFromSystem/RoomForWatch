package com.quantumman.data.db.contracts

class PopularMovieSqlContract {
    companion object {
        const val fetch = "SELECT * FROM ${RoomContract.tablePopularMovies}"
    }
}