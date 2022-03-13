package com.ono.ledger.interfaces

import com.ono.ledger.enums.OperationType

interface ITextUtil {
    fun validateValue(value: String, operationType: OperationType)
}