package com.ono.ledger.implementations

import com.ono.ledger.interfaces.ITextUtil
import com.ono.ledger.enums.OperationType

class ITextManipulationImpl : ITextUtil {
    override fun validateValue(value: String, operationType: OperationType) {

    }

    private fun isStringValid(value: String?): String {
        return if (value.isNullOrEmpty() && value.isNullOrBlank()) "Invalid String" else ""
    }

}