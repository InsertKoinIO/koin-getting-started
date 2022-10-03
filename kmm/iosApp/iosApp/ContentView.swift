import SwiftUI
import shared

struct ContentView: View {
    let helloText = KMPUserPresenterHelper().sayHello()

	var body: some View {
		Text(helloText)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
