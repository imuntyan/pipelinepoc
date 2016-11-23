package com.openlane.pipelinepoc.functional

import com.jayway.restassured.RestAssured
import com.openlane.pipelinepoc.Application
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification


@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [Application.class] )
@WebIntegrationTest(randomPort = true)
@IntegrationTest
class AbstractFunctionTest extends Specification {

    @Value('${local.server.port}')
    Integer serverPort

    void setup() {
        RestAssured.port = this.serverPort;
    }
}
