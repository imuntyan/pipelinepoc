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
    def client = new RESTClient()

    def "status endpoint test using groovyx.net.http.RESTClient"() {

        client.setUri("http://localhost:" + serverPort);

        when: "a rest call is performed to the status page"
        def response = client.get(path: "/status")

        then: "the correct message is expected"
        with(response) {
            data.text == "OK"
            status == 200
        }
    }

    @Shared
    def restTemplate = new RestTemplate()

    def "status endpoint test using org.springframework.web.client.RestTemplate"() {

        when:
        ResponseEntity entity = restTemplate.getForEntity("http://localhost:"+serverPort + "/status", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == 'OK'

    }


}
