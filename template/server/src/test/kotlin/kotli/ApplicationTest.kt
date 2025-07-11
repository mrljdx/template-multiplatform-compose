package kotli

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.config.ApplicationConfig
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `health is good`() = testApplication {
        environment {
            config = ApplicationConfig("application.yaml")
        }
        client.get("/api/health").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                expected = """{"text":"GMI"}""",
                actual = bodyAsText()
            )
        }
    }
}
