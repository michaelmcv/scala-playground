class TitleMatcher extends Matcher {
	def matchMetaData(input: String): String = {
		val filenameParts = input.split('.')
		filenameParts(0)
	}
}