package kotli.template.multiplatform.compose.data.database

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object SqliteLinkerProcessor : BaseFeatureProcessor() {

    const val ID = "data.database.sqlite-linker"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientBuildGradle,
            CleanupMarkedLine("{data.database.sqlite-linker}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientBuildGradle,
            RemoveMarkedLine("{data.database.sqlite-linker}")
        )
    }

}