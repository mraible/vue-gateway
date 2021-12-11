import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the FieldTestInfiniteScrollEntity entity.
 */
class FieldTestInfiniteScrollEntityGatlingTest extends Simulation {

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

    val scn = scenario("Test the FieldTestInfiniteScrollEntity entity")
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
            exec(http("Get all fieldTestInfiniteScrollEntities")
            .get("/api/field-test-infinite-scroll-entities")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new fieldTestInfiniteScrollEntity")
            .post("/api/field-test-infinite-scroll-entities")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "stringHugo":"SAMPLE_TEXT"
                , "stringRequiredHugo":"SAMPLE_TEXT"
                , "stringMinlengthHugo":"SAMPLE_TEXT"
                , "stringMaxlengthHugo":"SAMPLE_TEXT"
                , "stringPatternHugo":"SAMPLE_TEXT"
                , "integerHugo":"0"
                , "integerRequiredHugo":"0"
                , "integerMinHugo":"0"
                , "integerMaxHugo":"0"
                , "longHugo":"0"
                , "longRequiredHugo":"0"
                , "longMinHugo":"0"
                , "longMaxHugo":"0"
                , "floatHugo":"0"
                , "floatRequiredHugo":"0"
                , "floatMinHugo":"0"
                , "floatMaxHugo":"0"
                , "doubleRequiredHugo":"0"
                , "doubleMinHugo":"0"
                , "doubleMaxHugo":"0"
                , "bigDecimalRequiredHugo":"0"
                , "bigDecimalMinHugo":"0"
                , "bigDecimalMaxHugo":"0"
                , "localDateHugo":"2020-01-01T00:00:00.000Z"
                , "localDateRequiredHugo":"2020-01-01T00:00:00.000Z"
                , "instantHugo":"2020-01-01T00:00:00.000Z"
                , "instanteRequiredHugo":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeHugo":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeRequiredHugo":"2020-01-01T00:00:00.000Z"
                , "durationHugo":null
                , "durationRequiredHugo":null
                , "booleanHugo":null
                , "booleanRequiredHugo":null
                , "enumHugo":"ENUM_VALUE_1"
                , "enumRequiredHugo":"ENUM_VALUE_1"
                , "uuidHugo":null
                , "uuidRequiredHugo":null
                , "byteImageHugo":null
                , "byteImageRequiredHugo":null
                , "byteImageMinbytesHugo":null
                , "byteImageMaxbytesHugo":null
                , "byteAnyHugo":null
                , "byteAnyRequiredHugo":null
                , "byteAnyMinbytesHugo":null
                , "byteAnyMaxbytesHugo":null
                , "byteTextHugo":null
                , "byteTextRequiredHugo":null
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_fieldTestInfiniteScrollEntity_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created fieldTestInfiniteScrollEntity")
                .get("${new_fieldTestInfiniteScrollEntity_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created fieldTestInfiniteScrollEntity")
            .delete("${new_fieldTestInfiniteScrollEntity_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
