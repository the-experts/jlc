package nl.theexperts.cli.jlc

import picocli.CommandLine
import picocli.CommandLine.*
import picocli.CommandLine.Model.*
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@Command(name = "hello", description = ["Prints hello to somebody"])
class JiraCommandRunner : Callable<Int> {
    @Parameters(index = "0", defaultValue = "stranger", description = ["The name for greeting"])
    private var name: String? = null

    @Option(names = ["-c", "--capitalize"], defaultValue = "false", description = ["Capitalize the name"])
    private var isCapitalizeEnabled = false

    @Spec
    lateinit var spec: CommandSpec

    override fun call(): Int {
        val effectiveName = name ?: "stranger"
        spec.commandLine().out.println("Hello, " + (if (isCapitalizeEnabled) effectiveName.uppercase() else effectiveName))
        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val exitCode = CommandLine(JiraCommandRunner()).execute(*args)
            exitProcess(exitCode)
        }
    }
}
