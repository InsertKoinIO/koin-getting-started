![logo](./docs/img/koin_main_logo.png)

# What is KOIN? - [https://insert-koin.io](https://insert-koin.io)
 
A pragmatic lightweight dependency injection framework for Kotlin developers. `Koin is a DSL, a light container and a pragmatic API`

## Latest Version - [![Maven Central](https://img.shields.io/maven-central/v/io.insert-koin/koin-core)](https://search.maven.org/search?q=io.insert-koin)

You can find the following page to help setup your project: [Koin Gradle Setup](https://insert-koin.io/docs/setup/v3)


# Where to find resources? 🌐

Latest News
- Follow us on Twitter for latest news: [@insertkoin_io](https://twitter.com/insertkoin_io)
- Koin developers on Medium: [koin developers hub](https://medium.com/koin-developers)

Any question about Koin usage? 
- Come talk on slack [#koin](https://kotlinlang.slack.com/?redir=%2Fmessages%2Fkoin) channel
- Post your question on [Stackoverflow - #koin tag](https://stackoverflow.com/questions/tagged/koin)

Found a bug or a problem on a specific feature? Open an issue on [Github issues](https://github.com/InsertKoinIO/koin/issues)

# Contributing 🛠

Want to help or share a proposal about Koin? problem on a specific feature? 

- Open an issue to explain the issue you want to solve [Open an issue](https://github.com/InsertKoinIO/koin/issues)
- Come talk on slack [#koin-dev](https://kotlinlang.slack.com/?redir=%2Fmessages%2Fkoin-dev) channel
- After discussion to validate your ideas, you can open a PR or even a draft PR if the contribution is a big one [Current PRs](https://github.com/InsertKoinIO/koin/pulls)

Additional readings about basic setup: https://github.com/InsertKoinIO/koin/blob/master/CONTRIBUTING.adoc

<a href="https://github.com/InsertKoinIO/koin/graphs/contributors"><img src="https://opencollective.com/koin/contributors.svg?width=890&button=false" /></a>

# Sponsorship

[![Backers on Open Collective](https://opencollective.com/koin/backers/badge.svg)](#backers)
[![Sponsors on Open Collective](https://opencollective.com/koin/sponsors/badge.svg)](#sponsors) 

Support this project by becoming a sponsor. Your logo will show up here with a link to your website. [[Become a sponsor](https://opencollective.com/koin#sponsor)]

## Going further

This sample uses Koin's core APIs only. For production work, the
team behind Koin (Kotzilla) maintains four official, complementary
tools. One data layer, four surfaces:

- **Kotzilla SDK** — captures the data the Console and the MCP
  Server read. Drop in via `monitoring()` below; coordinates in
  `libs.versions.toml`.
- **[Kotzilla Console](https://console.kotzilla.io/?utm_source=koin-getting-started&utm_medium=readme&utm_campaign=awareness)** — visual
  exploration of that data: timelines, distributions, app-vitals
  dashboards.
- **Kotzilla MCP Server** — same data in the terminal, exposed
  to Claude Code / Cursor or other AI agents for SDK setup
  guidance, in-flow diagnosis, fixes, and build reports.
- **Koin IDE Plugin** ("Koin Dependency Injection (Official)"
  on JetBrains Marketplace) — Koin configuration viz, Insights
  View, and AI-powered fix prompts in Android Studio / IntelliJ.
  Requires Kotzilla account sign-in.

Reference integration: https://github.com/kotzilla-io/kmp-app-monitoring
Setup details: docs/observability.md
