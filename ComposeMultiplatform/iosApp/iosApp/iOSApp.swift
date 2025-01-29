import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        KoinAppKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
