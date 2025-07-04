package kotli.template.multiplatform.compose.platform.server.ktor

import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.common.CommonKtorProcessor
import kotli.template.multiplatform.compose.platform.PlatformProcessor
import kotli.template.multiplatform.compose.platform.shared.SharedDomainProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object KtorProcessor : PlatformProcessor() {

    const val ID = "platform.server.ktor"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Server)
    override fun getWebUrl(state: TemplateState): String = "https://ktor.io"
    override fun getIntegrationUrl(state: TemplateState): String = "https://ktor.io/docs/server-create-a-new-project.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 8.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SharedDomainProcessor::class,
        CommonKtorProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.ServerDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.RootBuildGradle,
            RemoveMarkedLine("kotlin.jvm")
        )
        state.onApplyRules(
            Rules.RootSettingsGradle,
            RemoveMarkedLine("server")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("logback"),
                RemoveMarkedLine("server"),
                RemoveMarkedLine("kotlin.jvm"),
                RemoveMarkedLine("ktor.plugin"),
                RemoveMarkedLine("kotlin-test-junit")
            )
        )
    }

}