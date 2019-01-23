import com.example.demo.model.CatScheduleScope
import com.example.demo.view.Editor
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.TextField
import org.junit.Test
import tornadofx.*
import kotlin.reflect.KClass
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import junit.framework.Assert.*
import org.junit.Before
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxToolkit
import org.testfx.framework.junit.ApplicationTest

data class Control(val type: KClass<out Node>, // put in uiNodeType here
                   val id: String,
                   val isAssigned: Boolean = false)

class TestView: View() {
    override val root = vbox()
}

class Test: ApplicationTest() {

    lateinit var primaryStage: Stage
    val view = TestView()

    private lateinit var textfield: TextField
    private lateinit var button: Button

    @Before
    fun setUpFx() {
        primaryStage = FxToolkit.registerPrimaryStage()
        val fragment = find<Editor>(CatScheduleScope())

        view.root.add(fragment.root)

        addAllIdsToDescendents(view.root)

        interact {
            primaryStage.scene = Scene(view.root)
            primaryStage.show()
            primaryStage.toFront()

            textfield = from(view.root).lookup("#beep").query()
            button = from(view.root).lookup("#derp").query()
        }
    }

    private val listOfControls = listOf(
            Control(Form::class,"peep"),
            Control(TextField::class,"beep"),
            Control(TextField::class,"boop"),
            Control(TextField::class, "bop"),
            Control(Button::class,"derp")
    )


    private fun addAllIdsToDescendents(parent: Parent) {
        for (node in parent.childrenUnmodifiable) {
            checkToAttachNodeId(node)
            if (node is Parent) {
                addAllIdsToDescendents(node)
            }
        }
    }

    private fun checkToAttachNodeId(node: Node) {
        listOfControls.forEach { control ->
            if (control.type.isInstance(node) &&
                    !control.isAssigned &&
                    node.id == null) {
                node.id = control.id
                control.isAssigned
            }
        }
    }

    @Test fun testTextfield() {
        clickOn(textfield).write("Something")

        assertEquals("Something", textfield.text)
    }

    @Test fun testButton() {
        assertTrue(button.isDisabled)
        clickOn(textfield).write("Something")

        assertTrue(!button.isDisabled)
        clickOn(button)
    }

}