package com.quantumman.data.db.contracts

class MovieSqlContract {
    companion object {
        const val fetchAll = "SELECT * FROM ${RoomContract.tableMovie}"
        const val fetchById = "SELECT * FROM ${RoomContract.tableMovie} WHERE id = :id LIMIT 1"
    }
}