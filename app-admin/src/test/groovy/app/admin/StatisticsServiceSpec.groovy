package app.admin

import app.admin.jobsboard.Job
import app.admin.jobsboard.Publisher
import app.admin.jobsboard.Tag
import app.admin.jobsboard.Type
import grails.buildtestdata.mixin.Build
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(StatisticsService)
@Mock([Job, Tag])
@Build([Job, Tag, Type, Publisher])
class StatisticsServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "get top publishers when we do not have any in the sysyem"() {
        when: "we get the top publishers"
            def publishers = service.getTopPublishers()
        then: "no publishers"
            publishers.size() == 0
    }

    void "get top publishers when we have multiple jobs published by the same publisher"() {
        given: "two jobs published by the same publisher"
            def tag = Tag.build()
            def type = Type.build()
            def publisher = Publisher.build()
            Job.build(publisher: publisher, type: type, tags: [tag])
            Job.build(publisher: publisher, type: type, tags: [tag])
        when: "we get top publishers"
            def publishers = service.getTopPublishers()
            def pair =  publishers.find { key, value -> key.name == publisher.name }
        then:
            publishers.size() == 1
            pair.value == 2


    }
}
