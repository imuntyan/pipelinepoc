package com.openlane.pipelinepoc.rest

import com.openlane.pipelinepoc.Application
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * Created by Igor.Muntyan on 11/22/2016.
 */

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [Application.class] )
@WebIntegrationTest
@Stepwise
class RestServiceSpec extends Specification {

    @Value('${local.server.port}')
    Integer serverPort

    @Shared
    def client = new RESTClient( "http://localhost:" + serverPort )

    def pr() {
        println serverPort
    }

    def "http server test"() {

        when:
        ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:"+serverPort + "/status", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == 'OK'

    }


}
