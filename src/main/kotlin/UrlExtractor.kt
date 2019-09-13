import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.get
import kotlin.browser.document

fun main() {
    getInput()
        .addEventListener("change", { event ->
            apply()
        })
    document.forms[0]?.getElementsByTagName("input")?.get(0)
        ?.addEventListener("click", { event ->
            apply()
        })

}

fun apply() {
    document.getElementById("extracted")?.innerHTML = buildString {
        val extracted = getInput().value.split("?")
            .map { it.split("&") } ?: return
        append("■ protocol, hostname, path" + "\n")
        append(extracted[0][0] + "\n")
        append("----------\n")
        append("■ parameters" + "\n")
        append(extracted[1].joinToString("\n"))
    }
}

private fun getInput() = document.forms[0]?.firstElementChild as HTMLTextAreaElement
