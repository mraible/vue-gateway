import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the FieldTestPaginationEntity entity.
 */
class FieldTestPaginationEntityGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the FieldTestPaginationEntity entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJson
        .check(header("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all fieldTestPaginationEntities")
            .get("/api/field-test-pagination-entities")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new fieldTestPaginationEntity")
            .post("/api/field-test-pagination-entities")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "stringAlice":"SAMPLE_TEXT"
                , "stringRequiredAlice":"SAMPLE_TEXT"
                , "stringMinlengthAlice":"SAMPLE_TEXT"
                , "stringMaxlengthAlice":"SAMPLE_TEXT"
                , "stringPatternAlice":"SAMPLE_TEXT"
                , "integerAlice":"0"
                , "integerRequiredAlice":"0"
                , "integerMinAlice":"0"
                , "integerMaxAlice":"0"
                , "longAlice":"0"
                , "longRequiredAlice":"0"
                , "longMinAlice":"0"
                , "longMaxAlice":"0"
                , "floatAlice":"0"
                , "floatRequiredAlice":"0"
                , "floatMinAlice":"0"
                , "floatMaxAlice":"0"
                , "doubleRequiredAlice":"0"
                , "doubleMinAlice":"0"
                , "doubleMaxAlice":"0"
                , "bigDecimalRequiredAlice":"0"
                , "bigDecimalMinAlice":"0"
                , "bigDecimalMaxAlice":"0"
                , "localDateAlice":"2020-01-01T00:00:00.000Z"
                , "localDateRequiredAlice":"2020-01-01T00:00:00.000Z"
                , "instantAlice":"2020-01-01T00:00:00.000Z"
                , "instanteRequiredAlice":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeAlice":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeRequiredAlice":"2020-01-01T00:00:00.000Z"
                , "durationAlice":null
                , "durationRequiredAlice":null
                , "booleanAlice":null
                , "booleanRequiredAlice":null
                , "enumAlice":"ENUM_VALUE_1"
                , "enumRequiredAlice":"ENUM_VALUE_1"
                , "uuidAlice":null
                , "uuidRequiredAlice":null
                , "byteImageAlice":null
                , "byteImageRequiredAlice":null
                , "byteImageMinbytesAlice":null
                , "byteImageMaxbytesAlice":null
                , "byteAnyAlice":null
                , "byteAnyRequiredAlice":null
                , "byteAnyMinbytesAlice":null
                , "byteAnyMaxbytesAlice":null
                , "byteTextAlice":null
                , "byteTextRequiredAlice":null
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_fieldTestPaginationEntity_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created fieldTestPaginationEntity")
                .get("${new_fieldTestPaginationEntity_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created fieldTestPaginationEntity")
            .delete("${new_fieldTestPaginationEntity_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
