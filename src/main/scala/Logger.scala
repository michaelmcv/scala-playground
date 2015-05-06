import java.util.logging.Level

object Logger {
	var loggingLevel: Level = Level.INFO

	def log(level: Level, logMessage: String) : Unit = {
		if(level.intValue >= loggingLevel.intValue)
		printf("%s - %s %n", level, logMessage)
	}
}