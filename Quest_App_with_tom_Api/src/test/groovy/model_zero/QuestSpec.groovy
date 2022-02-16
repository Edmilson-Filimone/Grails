package model_zero

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class QuestSpec extends Specification implements DomainUnitTest<Quest> {
    Quest q = new Quest(name:'name')
    
    void "test something"() {
        expect:
        q.validate()    
    }

    void "testado o blank constraints"(){
        expect:
        q.name = '  '
        then:
        q.validate()

    }
}
