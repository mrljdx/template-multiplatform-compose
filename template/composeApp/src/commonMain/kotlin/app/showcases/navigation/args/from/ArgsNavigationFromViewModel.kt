package app.showcases.navigation.args.from

import app.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.core.BaseViewModel
import shared.core.navigation.NavigationState
import shared.core.state.StoreObject

class ArgsNavigationFromViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    val userNameStore = StoreObject<String>()

    fun onBack() {
        navigationState.onBack()
    }

    fun onNavigate() {
        navigationState.onNext(
            destination = ArgsNavigationToDestination,
            data = ArgsNavigationToDestination.Data(
                userName = userNameStore.get()
            )
        )
    }

}
