package i0.sealights.koltin.loggertest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoggertestApplication

fun main(args: Array<String>) {
	runApplication<LoggertestApplication>(*args)
}
