import javafx.application.Platform
import javafx.scene.Scene
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import tornadofx.*
import java.time.Instant

open class TornadoFxTest : ApplicationTest() {
    lateinit var wrapper: TestView
    override fun start(stage: Stage) {
        wrapper = TestView()
        val scene = Scene(wrapper.root, 800.0, 600.0)
        stage.scene = scene
        stage.show()
    }

    protected inline fun <reified T : UIComponent> showViewWithParams(params: Map<*, Any?>?) =
            wrapper.addViewWithParams<T>(params)

    class TestView : View() {
        override val root = stackpane { }
        inline fun <reified T : UIComponent> findView(params: Map<*, Any?>?) = find<T>(params)
        inline fun <reified T : UIComponent> addViewWithParams(params: Map<*, Any?>?): T {
            Platform.runLater {
                root.add(findView<T>(params))
            }
            waitFor(condition = { root.children.size > 0 })
            return root.children[0].uiComponent()!!
        }
    }
}

fun waitFor(condition: () -> Boolean, maxMillis: Long = 10000) {
    val startTime = Instant.now()
    while (!condition() && Instant.now().isBefore(startTime.plusMillis(maxMillis))) {
        Thread.sleep(1000)
    }
}