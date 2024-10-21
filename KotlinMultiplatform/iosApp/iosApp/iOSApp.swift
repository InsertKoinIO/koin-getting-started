import SwiftUI
import Shared

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
