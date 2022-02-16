package model_zero

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TasksSpec extends Specification implements DomainUnitTest<Tasks> {
    Tasks t = new Tasks(name:'nome')
    void "test something"() {
        expect:
        t.validate() == true
    }
}
