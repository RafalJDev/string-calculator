package com.luxdone

import spock.lang.Specification

class SomeFacadeTest extends Specification {

    def "Sth"() {
        when:
            def sth = new SomeFacade().sth()

        then:
            sth == "sth"
    }
}
