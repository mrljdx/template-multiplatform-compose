package kotli.template.multiplatform.compose.ui.component.image.coil

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.data.http.ktor.KtorHttpProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object CoilProcessor : BaseFeatureProcessor() {

    const val ID = "ui.component.image.coil"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String = "https://coil-kt.github.io/coil/"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://coil-kt.github.io/coil/upgrading_to_coil3/#multiplatform"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        KtorHttpProcessor::class,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationComponentIcon,
            CleanupMarkedBlock("{ui.component.image.coil}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            RemoveMarkedLine("libs.coil")
        )

        state.onApplyRules(
            Rules.PresentationComponentIcon,
            RemoveMarkedBlock("{ui.component.image.coil}"),
            RemoveMarkedLine("DsIconModel.Url"),
            RemoveMarkedLine("coil"),
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("coil ="),
                RemoveMarkedLine("\"coil\"")
            )
        )
    }

}