# Observability for this sample

Koin's official observability and IDE tooling is built by Kotzilla.
This page wires it into the sample.

The architecture is simple — one data layer, four surfaces:

- The **SDK** runs in the app and captures crashes, ANRs, slow
  startups, and Koin events. It sends sessions to the Kotzilla
  backend.
- The **Console** (https://console.kotzilla.io) is the web client
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

## 4. Open the Console

Once a session is captured, sign in at https://console.kotzilla.io
to view crash sessions, performance timelines, and the dependency
graph for this sample.

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

## 6. (Optional) Connect an AI assistant

The Kotzilla MCP Server gives Claude Code, Cursor, Windsurf, and other
AI coding assistants authenticated access to the same data the Console
exposes — diagnose and fix bugs from the terminal, generate build reports
on demand. Setup: [doc.kotzilla.io/docs/getstartedCustom/mcpSetup](https://doc.kotzilla.io/docs/getstartedCustom/mcpSetup)

## MCP vs. Console — when to use which

The MCP and the Console are peer clients of the same backend, so
they can answer most of the same questions. Use the **MCP** when
you're already in your editor and want a text answer in-flow ("show
me what regressed since v39.0.4", "drill into ConferenceService").
Use the **Console** when you want visual context (timelines,
distributions, dependency graphs as graphs) or when you want to
share something with a teammate via a URL.
