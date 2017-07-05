package app.admin

import app.admin.jobsboard.Job
import grails.transaction.Transactional
import groovy.util.logging.Slf4j

@Slf4j
@Transactional
class StatisticsService {

    def getTopPublishers() {
        log.info("The first publisher is: ${app.admin.jobsboard.Publisher.list().first()}")
        Job.list().countBy { it.publisher }
    }

    def getTopTypes() {
        Job.list().countBy { it.type }
    }

    def getTopTags() {
        Job.list().countBy { it.tags }
    }
}
