package by.a750mm.excursionsapp750mm.domain.entity

import java.lang.Exception

data class AppException(
        val errorType: AppErrorType) : Exception(), DomainEntity