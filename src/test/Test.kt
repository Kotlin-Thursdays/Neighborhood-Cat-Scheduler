import com.example.demo.model.CatScheduleModel
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
import org.junit.Assert
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxToolkit
import org.testfx.framework.junit.ApplicationTest
import org.testfx.matcher.control.TextInputControlMatchers.hasText

data class Control(val type: KClass<out Node>, // put in uiNodeType here
                   val id: String,
                   val isAssigned: Boolean = false)

class Test: ApplicationTest() {

    /*override fun start(stage: Stage?) {
        setInScope(CatScheduleModel(), CatScheduleScope())
        val sceneRoot = view
        addAllIdsToDescendents(sceneRoot.root)
        stage?.scene = Scene(sceneRoot.root, 100.0, 100.0)
        stage?.show()
    }*/

    val primaryStage = FxToolkit.registerPrimaryStage()

    private val listOfControls = listOf(
            Control(Form::class,"#peep"),
            Control(TextField::class,"#beep"),
            Control(TextField::class,"#boop"),
            Control(TextField::class, "#bop"),
            Control(Button::class,"#derp")
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
        // use this to save the label
        val fragment = find<Editor>(CatScheduleScope())
        addAllIdsToDescendents(fragment.root)
        clickOn(lookup("#beep")).write("Something")
        verifyThat("#beep", hasText("Something"))
        // Assert.assertTrue(view.scope.model.isDirty)
    }

    @Test fun testButton() {
        val button = lookup("#derp") as Button
        clickOn("#derp")
        // verifyThat(view, view.)
    }

}