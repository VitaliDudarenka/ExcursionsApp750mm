package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase(
        val postExecutorThread: Scheduler,
        val workExecutorThread: Scheduler = Schedulers.io()) {

    constructor(postExecutorThread: PostExecutorThread)
            : this(postExecutorThread.getScheduler())

}