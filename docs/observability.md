# Observability for this sample

Koin's official observability and IDE tooling is built by Kotzilla.
This page wires it into the sample.

The architecture is simple — one data layer, four surfaces:

- The **SDK** runs in the app and captures crashes, ANRs, slow
  startups, and Koin events. It sends sessions to the Kotzilla
  backend.
- The **Console** (https://console.kotzilla.io/?utm_source=koin-getting-started&utm_medium=observability-md&utm_campaign=awareness) is the web client
  for that backend: sessions, dependency graphs, app vitals.
- The **MCP Server** is another client of the same backend, for
  AI assistants in the terminal.
- The **Koin IDE Plugin** ("Koin Dependency Injection
  (Official)" on JetBrains Marketplace) is the official Koin
  plugin maintained by the Koin team. It does Koin runtime
  checks locally at edit time, and is also an authenticated
  client to the Kotzilla backend — surfacing application issues
  from any SDK-instrumented app in the user's account. Generates
  AI-powered prompts to fix detected issues. Requires Kotzilla
  account sign-in.

## 1. Add the SDK

In `libs.versions.toml`, uncomment the Kotzilla coordinates

## 2. Drop in `monitoring()`

    import io.kotzilla.generated.monitoring

    startKoin {
        modules(appModule)
        monitoring()
    }

`monitoring()` is the recommended form on all targets (SDK 2.0.4+).
On Android-only projects, `analytics()` is also valid and not
deprecated; the block form `analytics { … }` is deprecated outside
Android.

## 3. Configure `kotzilla.json`

The SDK reads its API key and config from `kotzilla.json`. Generate
yours from the Console (see the Kotzilla docs for the exact steps).

## 4. Explore your data

Once a session is captured, two surfaces read the same backend:

- **Kotzilla Console** (https://console.kotzilla.io/?utm_source=koin-getting-started&utm_medium=observability-md&utm_campaign=awareness) — visual exploration:
  timelines, dependency graphs, app vitals dashboards. The right surface
  when you want to share or explore visually.
- **Kotzilla MCP Server** — same data in the terminal, exposed to your AI
  assistant (Claude Code, Cursor, Windsurf). Diagnose and fix bugs in-flow,
  generate build reports, diff across versions — without leaving your editor.
  Setup: [doc.kotzilla.io/docs/getstartedCustom/mcpSetup](https://doc.kotzilla.io/docs/getstartedCustom/mcpSetup)

## 5. (Optional) Install the Koin IDE Plugin

Install ["Koin Dependency Injection (Official)"](https://plugins.jetbrains.com/plugin/26131-koin-dependency-injection-official-)
from the JetBrains Marketplace. Requires Kotzilla account
sign-in. The plugin does Koin runtime checks locally at edit
time, and is also an authenticated client to the Kotzilla
backend — surfacing application issues (perf, ANRs, crashes)
from any SDK-instrumented app in your account. Once this
sample's SDK has sent data, you'll see its issues here too. For
any detected issue, the plugin can generate an AI-powered
prompt with full context (impacted components, dependency
chains, performance insights) — ready to send to Claude Code,
Junie, Copilot, or Gemini.

## MCP vs. Console — when to use which

The MCP and the Console are peer clients of the same backend, so
they can answer most of the same questions. Use the **MCP** when
you're already in your editor and want a text answer in-flow ("show
me what regressed since v39.0.4", "drill into ConferenceService").
Use the **Console** when you want visual context (timelines,
distributions, dependency graphs as graphs) or when you want to
share something with a teammate via a URL.
