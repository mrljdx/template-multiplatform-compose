package app.showcases

import app.showcases.datasource.paging.basic.BasicPagingShowcase
import app.showcases.userflow.theme.change.ChangeThemeDialogShowcase
import app.showcases.userflow.theme.change.ChangeThemeScreenShowcase
import app.showcases.userflow.theme.toggle.ToggleThemeShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase,
        ShowcaseItemGroup("Datasource :: Paging"),
        BasicPagingShowcase
    )

}