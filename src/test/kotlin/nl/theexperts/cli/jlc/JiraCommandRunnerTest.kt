package nl.theexperts.cli.jlc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import picocli.CommandLine
import java.io.PrintWriter
import java.io.StringWriter

class JiraCommandRunnerTest {

    val app = JiraCommandRunner()
    val cmd = CommandLine(app)
    var sw: StringWriter? = null

    @BeforeEach
    fun setUp() {
        sw = StringWriter()
        cmd.out = PrintWriter(sw!!)
    }

    @Test
    fun `Happy flow`() {
        val exitCode = cmd.execute("world")
        assertThat(exitCode).isEqualTo(CommandLine.ExitCode.OK)
        assertThat(sw.toString()).isEqualTo("Hello, world\n")
    }

    @Test
    fun `Capitalize option`() {
        val exitCode = cmd.execute("world", "--capitalize")
        assertThat(exitCode).isEqualTo(CommandLine.ExitCode.OK)
        assertThat(sw.toString()).isEqualTo("Hello, WORLD\n")
    }

    @Test
    fun `Wrong input`() {
        val exitCode = cmd.execute("hello", "world")
        assertThat(exitCode).isEqualTo(2)
    }

}