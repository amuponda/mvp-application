package app.admin

import app.admin.jobsboard.Job
import app.admin.jobsboard.Publisher
import app.admin.jobsboard.Tag
import app.admin.jobsboard.Type
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.buildtestdata.mixin.Build
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(StatisticsTagLib)
@Mock(StatisticsService)
@Build([Tag, Type, Publisher, Job])
class StatisticsTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "top publishers when there are no publishers"() {
        expect:
            applyTemplate('<s:top type="publishers" />') == ""
    }

    void "top publishers, tags and types"() {
        given:
            def tag = Tag.build()
            def type = Type.build()
            def publisher = Publisher.build()
            Job.build(publisher: publisher, type: type, tags: [tag])
            Job.build(publisher: publisher, type: type, tags: [tag])

        expect:
            applyTemplate('<s:top type="publishers" />') == "<strong>Publishers (1)</strong> <ul><li>app.admin.jobsboard.Publisher : 1:2</li></ul>"
            applyTemplate('<s:top type="types" />') == "<strong>Types (1)</strong> <ul><li>app.admin.jobsboard.Type : 1:2</li></ul>"
            applyTemplate('<s:top type="tags" />') == "<strong>Tags (1)</strong> <ul><li>[app.admin.jobsboard.Tag : 1]:2</li></ul>"
    }
}
