import org.w3c.dom.get
import kotlin.browser.document

fun main() {
    val input = document.forms[0]?.firstElementChild
    input
        ?.addEventListener("change", { event ->
            apply()
        })
    document.forms[0]?.getElementsByTagName("input")?.get(0)
        ?.addEventListener("click", { event ->
            apply()
        })

}

fun apply() {
    document.getElementById("extracted")?.innerHTML = buildString {
        val extracted = document.forms[0]
            ?.textContent?.split("?")
            ?.map { it.split("&") } ?: return
        append("■ hostname" + "\n")
        append(extracted[0][0] + "\n")
        append("----------\n")
        append("■ parameters" + "\n")
        append(extracted[1].joinToString("\n"))
    }
}