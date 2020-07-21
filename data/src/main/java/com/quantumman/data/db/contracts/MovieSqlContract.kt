package com.quantumman.data.db.contracts

class MovieSqlContract {
    companion object {
        const val fetch = "SELECT * FROM ${RoomContract.tableMovie}"
    }
}