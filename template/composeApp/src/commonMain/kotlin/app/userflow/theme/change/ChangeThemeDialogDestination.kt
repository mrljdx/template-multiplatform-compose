package app.userflow.theme.change

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy

/**
 * Navigation destination for the change theme dialog screen.
 */
object ChangeThemeDialogDestination : NavigationDestination<Unit>() {

    override val id: String = "change_theme_dialog_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) { ChangeThemeDialog() }

}